package com.sphospital.doctor_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sphospital.doctor_service.model.DoctorMaster;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorMasterServiceProxy doctorMasterServiceProxy;
	
//	private static List<DoctorMaster> doctors = new ArrayList<DoctorMaster>();
//	static {
//		doctors.add(new DoctorMaster(101, "Rahul","9047897097","Bengaluru"));
//		doctors.add(new DoctorMaster(101, "Gokul","9047897097","Chennai"));
//	}
//	
//	@Override
//	public List<DoctorMaster> saveDoctor(DoctorMaster doctor) {
//		doctors.add(doctor);
//		return doctors;
//	}

	@Override
	public DoctorMaster getDoctorById(int docId) {
		return doctorMasterServiceProxy.getDoctorById(docId);
	}

}
