package com.sphospital.master_service.service;

import java.util.List;

import com.sphospital.master_service.model.DoctorMaster;

public interface DoctorMasterService {

	List<DoctorMaster> saveDoctor(DoctorMaster doctorMaster);

	List<DoctorMaster> findAll();

	DoctorMaster getDoctorById(int docId);
	
}
