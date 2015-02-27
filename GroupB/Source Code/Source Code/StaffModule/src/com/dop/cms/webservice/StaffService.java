package com.dop.cms.webservice;

import javax.jws.WebService;

import com.dop.cms.data.Patient;

@WebService
public interface StaffService {
	public Patient getBill();
}
