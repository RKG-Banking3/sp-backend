package com.sphospital.doctor_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sphospital.doctor_service.model.DoctorMaster;
import com.sphospital.doctor_service.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
//	@PostMapping("/saveDoctor")
//	public List<DoctorMaster> saveDoctor(@RequestBody DoctorMaster doctor) {
//		return doctorService.saveDoctor(doctor);
//	}
	
	@GetMapping("/getDoctorRecord/{docId}")
	public DoctorMaster getDoctorById(@PathVariable int docId) {
		return doctorService.getDoctorById(docId);
	}
	
}
