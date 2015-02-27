package com.dop.cms.test.login;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class LoginTest {

	public LoginTest() {
	}

	@Test
	public void testLogin(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cms@gmail.com", "Password@220");
		assertEquals("If credentials are correct", "Password@220",map.get("cms@gmail.com"));
	}
	
	@Test
	public void testAttempts(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cms@gmail.com", "2");
		assertEquals("Number of failed attempts", "2",map.get("cms@gmail.com"));
	}
	
	@Test
	public void testStatus(){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("cms@gmail.com", "Accept");
		assertEquals("Number of failed attempts", "Accept",map.get("cms@gmail.com"));
	}
	
	
}
