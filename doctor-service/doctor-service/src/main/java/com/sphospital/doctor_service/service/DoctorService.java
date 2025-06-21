package com.sphospital.doctor_service.service;

import java.util.List;

import com.sphospital.doctor_service.model.DoctorMaster;

public interface DoctorService {

//	List<DoctorMaster> saveDoctor(DoctorMaster doctor);

	DoctorMaster getDoctorById(int docId);

}
