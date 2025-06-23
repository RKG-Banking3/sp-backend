package com.sphospital.master_service.helper;

public class Helper {

	public static String safeValue(Object object) {
		if(object == null)
			return "";
		return String.valueOf(object);
	}
	
	public static String safeValue(String str) {
		if(str == null || str.equalsIgnoreCase("null"))
			return "";
		return str.trim();
	}
	
}
