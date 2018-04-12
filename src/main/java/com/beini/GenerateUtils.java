package com.beini;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;

public class GenerateUtils {

	public static void main(String[] args) {
		GenerateUtils gu = new GenerateUtils();
		String fields = gu.getFieldNamesToString(Object.class);
		System.out.println(fields);
		System.out.println("============================================================");
		fields = gu.getFieldNameToString(Object.class);
		System.out.println(fields);
	}
	
	
	public String getFieldNamesToString(Class<?> clazz) {
		List<String> list = getFieldNames(clazz);
		return Joiner.on(",").join(list);
	}
	public String getFieldNameToString(Class<?> clazz) {
		List<String> list = getFieldName(clazz);
		return Joiner.on(",").join(list);
	}
	
	public  List<String> getFieldName(Class<?> clazz) {
		List<String> list = new ArrayList<String>();
		Field fields[] = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (!"serialVersionUID".equals(field.getName()))
				list.add(field.getName());
		}
		return list;
	}

	private List<String> getFieldNames(Class<?> clazz) {
		List<String> list = new ArrayList<String>();
		Field fields[] = clazz.getDeclaredFields();
		for (Field field : fields) {
			String temp = getUpperCamel(field.getName());
			if (!"SERIAL_VERSION_U_I_D".equals(temp))
				list.add(temp);
		}
		return list;
	}

	private String getUpperCamel(String name) {
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, name);
	}
}
