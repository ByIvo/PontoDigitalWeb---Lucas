package br.com.pontowebdigital.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtils
{
	public static <T> T buildObjectFromJson(Class<T> clazz, String json)
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		return gson.fromJson(json, clazz);
	}
	
	public static String buildJsonFromObject(Object obj)
	{
		Gson gson = new Gson();
		
		return gson.toJson(obj);
	}

}
