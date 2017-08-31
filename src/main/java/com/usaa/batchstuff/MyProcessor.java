package com.usaa.batchstuff;

import javax.batch.api.chunk.ItemProcessor;

public class MyProcessor implements ItemProcessor {

	@Override
	public String processItem(Object itemFromReader) throws Exception {
		StringBuilder stringBuilder = new StringBuilder((String)itemFromReader);
		return stringBuilder.reverse().toString();
	}

}
