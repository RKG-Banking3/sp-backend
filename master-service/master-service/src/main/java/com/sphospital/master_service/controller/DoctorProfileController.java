package com.sphospital.master_service.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sphospital.master_service.model.DoctorProfile;
import com.sphospital.master_service.service.DoctorProfileService;

@RestController
public class DoctorProfileController {

	@Autowired
	private DoctorProfileService doctorProfileService;
	
	@PostMapping("/saveDoctorDetails")
	public ResponseEntity<Map<String, Object>> saveDoctorDetails(@RequestBody Map<String, Object> requestMap) {
		Map<String, Object> responseHashMap = new HashMap<String, Object>();
		try {
			responseHashMap = doctorProfileService.saveDoctorDetails(requestMap);
		}catch(Exception e) {
			responseHashMap.put("Success", false);
			responseHashMap.put("errorMsg", e.getMessage());
		}
        return new ResponseEntity<Map<String, Object>>(responseHashMap,HttpStatus.OK);
    }
	
	@GetMapping("/getDoctorsList")
	public ResponseEntity<Map<String, Object>>  getDoctorsList() {
		Map<String, Object> responseHashMap = new HashMap<String, Object>();
		try {
			responseHashMap = doctorProfileService.getDoctorsList();
		}catch(Exception e) {
			responseHashMap.put("Success", false);
			responseHashMap.put("errorMsg", e.getMessage());
		}
        return new ResponseEntity<Map<String, Object>>(responseHashMap,HttpStatus.OK);
	}

	
	@GetMapping("/getDoctorsDetailsByEmpId")
	public DoctorProfile getDoctorsDetailsByEmpId(@RequestParam String docId) {
		return doctorProfileService.getDoctorsDetailsByEmpId(docId);
	}
	
}
