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
 * 处理数组类型的null值，集合类型为null时转化为 []
 *
 */
public class MyNullArrayJsonSerializer extends JsonSerializer {
	
	@Override
	public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		if (value == null) {
			jgen.writeStartArray();
			jgen.writeEndArray();
		}
	}
}

