package com.dop.cms.data;

import java.util.ArrayList;

public class Patient {

	ArrayList<Integer> patientId = new ArrayList<Integer>();
	ArrayList<String> address = new ArrayList<String>();
	ArrayList<String> email = new ArrayList<String>();
	ArrayList<String> phone = new ArrayList<String>();
	ArrayList<String> bill = new ArrayList<String>();
	ArrayList<String> dateL = new ArrayList<String>();
	ArrayList<String> name = new ArrayList<String>();
	ArrayList<String> statusA = new ArrayList<String>();
	
	public ArrayList<String> getStatusA() {
		return statusA;
	}
	public void setStatusA(ArrayList<String> statusA) {
		this.statusA = statusA;
	}
	public ArrayList<Integer> getPatientId() {
		return patientId;
	}
	public void setPatientId(ArrayList<Integer> patientId) {
		this.patientId = patientId;
	}
	public ArrayList<String> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}
	public ArrayList<String> getEmail() {
		return email;
	}
	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}
	public ArrayList<String> getPhone() {
		return phone;
	}
	public void setPhone(ArrayList<String> phone) {
		this.phone = phone;
	}
	public ArrayList<String> getBill() {
		return bill;
	}
	public void setBill(ArrayList<String> bill) {
		this.bill = bill;
	}
	public ArrayList<String> getDateL() {
		return dateL;
	}
	public void setDateL(ArrayList<String> dateL) {
		this.dateL = dateL;
	}
	public ArrayList<String> getName() {
		return name;
	}
	public void setName(ArrayList<String> name) {
		this.name = name;
	}
	
	
}
