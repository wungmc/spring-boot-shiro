/*
 * Copyright (C), 2011-2019.
 */
package com.wung.config.json;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author wung 2019-06-13.
 */
public class MyBeanSerializerModifier extends BeanSerializerModifier {
	
	/**
	 * 数组类型
	 */
	private JsonSerializer nullArrayJsonSerializer = new MyNullArrayJsonSerializer();
	
	/**
	 * 字符串等类型
	 */
	private JsonSerializer nullJsonSerializer = new MyNullJsonSerializer();

	private MytimeJsonSerializer mytimeJsonSerializer = new MytimeJsonSerializer();
	
	@Override
	public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
													 List beanProperties) {
		//循环所有的beanPropertyWriter
		for (Object beanProperty : beanProperties) {
			BeanPropertyWriter writer = (BeanPropertyWriter) beanProperty;
			//判断字段的类型，如果是array，list，set则注册nullSerializer
			if (isArrayType(writer)) {
				//给writer注册一个自己的nullSerializer
				writer.assignNullSerializer(this.nullArrayJsonSerializer);
			}
			else if (isString(writer)) {
				writer.assignNullSerializer(this.nullJsonSerializer);
			}else if (isDate(writer)){
				writer.assignSerializer(this.mytimeJsonSerializer);
			}
		}
		return beanProperties;
	}
	
	/**
	 * 判断是否为集合类型
	 */
	protected boolean isArrayType(BeanPropertyWriter writer) {
		Class clazz = writer.getPropertyType();
		return clazz.isArray() || clazz.equals(List.class) || clazz.equals(Set.class);
	}
	
	/**
	 * 判断是否为字符串类型
	 *
	 * @param writer
	 * @return
	 */
	protected boolean isString(BeanPropertyWriter writer) {
		Class clazz = writer.getPropertyType();
		return clazz == String.class;
	}

	/**
	 * 判断是否为时间
	 *
	 * @param writer
	 * @return
	 */
	protected boolean isDate(BeanPropertyWriter writer) {
		Class clazz = writer.getPropertyType();
		return clazz == Date.class;
	}
	
}
