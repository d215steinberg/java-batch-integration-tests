package com.usaa.batchstuff;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;

public class MyReader implements ItemReader {

	private LineNumberReader inputFileReader;

	@Override
	public Serializable checkpointInfo() throws Exception {
		return null;
	}

	@Override
	public void close() throws Exception {
		inputFileReader.close();
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("input.txt");
		inputFileReader = new LineNumberReader(new InputStreamReader(inputStream));
	}

	@Override
	public String readItem() throws Exception {
		return inputFileReader.readLine();
	}

}
