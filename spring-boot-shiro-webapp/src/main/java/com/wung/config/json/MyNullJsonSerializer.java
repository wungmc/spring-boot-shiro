/*
 * Copyright (C), 2011-2019.
 */
package com.wung.config.json;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * 字符串类型的null值，转化为空串
 *
 * @author wung
 */
public class MyNullJsonSerializer extends JsonSerializer {
	
	@Override
	public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException, JsonProcessingException {
		jsonGenerator.writeString("");
	}
}

