package com.usaa.batchstuff;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.batch.api.chunk.ItemWriter;

public class MyWriter implements ItemWriter {

	private PrintWriter outputFileWriter;

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}

	@Override
	public void close() throws Exception {
		outputFileWriter.close();
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		outputFileWriter = new PrintWriter("c:\\Temp\\output.txt");
	}

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for (Object item : items) {
			outputFileWriter.println((String) item);
		}
	}

}
