package com.usaa.batchstuff;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.concurrent.TimeUnit;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;

import org.jberet.runtime.JobExecutionImpl;
import org.junit.Before;
import org.junit.Test;

public class JobTest {

	private JobOperator jobOperator;

	@Before
	public void setUp() {
		jobOperator = BatchRuntime.getJobOperator();
	}

	@Test
	public void reversesStrings() throws Exception {
		runJobToCompletion("job");
		File outputFile = new File("c:\\Temp\\output.txt");
		LineNumberReader outputFileReader = new LineNumberReader(new FileReader(outputFile));

		String line1 = outputFileReader.readLine();
		String line2 = outputFileReader.readLine();

		assertThat(line1, is("cba"));
		assertThat(line2, is("fed"));

		outputFileReader.close();
		outputFile.delete();
	}

	private void runJobToCompletion(String jobName) throws InterruptedException {
		long jobExecutionId = jobOperator.start(jobName, null);
		JobExecutionImpl jobExecution = (JobExecutionImpl) jobOperator.getJobExecution(jobExecutionId);
		jobExecution.awaitTermination(10, TimeUnit.SECONDS);
	}

}
