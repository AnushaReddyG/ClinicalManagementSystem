package com.dop.cms.utilities;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Utility {

	public static String encode(String s) throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
	}
	public static String decode(String s) throws UnsupportedEncodingException {
	    return new String(Base64.getDecoder().decode(s));
	}
	
	
}
