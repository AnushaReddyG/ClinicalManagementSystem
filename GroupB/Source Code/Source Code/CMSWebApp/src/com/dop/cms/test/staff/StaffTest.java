package com.dop.cms.test.staff;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class StaffTest {

	public StaffTest() {

	}
	@Test
	public void testStaff(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(5001, "Present");
		assertEquals("If the Staff id is present", "Present",map.get(5001));
	}
	
	@Test
	public void getStaffDet(){
		List<String> list = Arrays.asList("Staff1", "Staff2", "Staff3", "Staff4", "Staff5");
		assertEquals("List Size",5,list.size());
	}
	
	@Test
	public void sendBillStatus(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(5001, "Billed");
		assertEquals("If the Billing is completed", "Billed",map.get(5001));
	}
}
