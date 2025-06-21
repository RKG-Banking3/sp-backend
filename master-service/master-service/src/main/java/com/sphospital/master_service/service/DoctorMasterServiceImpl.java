package com.sphospital.master_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sphospital.master_service.model.DoctorMaster;

@Service
public class DoctorMasterServiceImpl implements DoctorMasterService{

	
	private static List<DoctorMaster> doctors = new ArrayList<DoctorMaster>();
	static {
		doctors.add(new DoctorMaster(101, "Rahul","9047897097","Bengaluru"));
		doctors.add(new DoctorMaster(101, "Gokul","9047897097","Chennai"));
	}
	
	@Override
	public List<DoctorMaster> saveDoctor(DoctorMaster doctorMaster) {
		doctors.add(doctorMaster);
		return doctors;
	}

	@Override
	public List<DoctorMaster> findAll() {
		// TODO Auto-generated method stub
		return doctors;
	}

	@Override
	public DoctorMaster getDoctorById(int docId) {
		 Optional<DoctorMaster> first = doctors.stream().filter(f->f.getRowId()==docId).findFirst();
		 if(first.isPresent())
			 return first.get();
		 
		 return null;
	}

}
