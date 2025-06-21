package com.sphospital.doctor_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sphospital.doctor_service.model.DoctorMaster;

@FeignClient(name="master-service")
public interface DoctorMasterServiceProxy {
	@GetMapping("/getDoctorById/{docId}")
	public DoctorMaster getDoctorById(@PathVariable int docId);
}
