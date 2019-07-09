package com.laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			return new HttpUtil(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public <T> T toModel(Class<T> tClass) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(this.value, tClass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
