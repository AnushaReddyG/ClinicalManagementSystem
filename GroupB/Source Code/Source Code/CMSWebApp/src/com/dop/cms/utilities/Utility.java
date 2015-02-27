package com.dop.cms.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Properties;

public class Utility {
	private static final String PROPERTIES_FILE="WebContent/WEB-INF/properties/ws.properties";
	public static String encode(String s) throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(s.getBytes("UTF-8"));
	}
	public static String decode(String s) throws UnsupportedEncodingException {
		return new String(Base64.getDecoder().decode(s));
	}

	public static void loadPropertyFile(){
		File file = new File(PROPERTIES_FILE);
		FileInputStream fileInput;
		try {
			Properties properties = new Properties();
			fileInput = new FileInputStream(file);
			properties.load(fileInput);
			
				fileInput.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {


		loadPropertyFile();


	}
}
