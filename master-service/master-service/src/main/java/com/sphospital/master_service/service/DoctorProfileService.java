package com.sphospital.master_service.service;

import java.util.Map;

import com.sphospital.master_service.model.DoctorProfile;

public interface DoctorProfileService {

	Map<String, Object> saveDoctorDetails(Map<String, Object> doctorMaster);

	Map<String, Object> getDoctorsList();
	
	DoctorProfile getDoctorsDetailsByEmpId(String hpDocEmpId);
	
}
