package com.sphospital.master_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sphospital.master_service.model.DoctorMaster;
import com.sphospital.master_service.service.DoctorMasterService;

@RestController
public class DoctorMasterController {

	@Autowired
	private DoctorMasterService doctorMasterService;
	
	@PostMapping("/saveDoctor")
	public List<DoctorMaster> saveDoctor(@RequestBody DoctorMaster doctor) {
		return doctorMasterService.saveDoctor(doctor);
	}
	
	@GetMapping("/getAllDoctors")
	public List<DoctorMaster> getAllDoctor() {
		System.err.println("test");
		return doctorMasterService.findAll();
	}
	
	@GetMapping("/getDoctorById/{docId}")
	public DoctorMaster getDoctorById(@PathVariable int docId) {
		return doctorMasterService.getDoctorById(docId);
	}
	
}
