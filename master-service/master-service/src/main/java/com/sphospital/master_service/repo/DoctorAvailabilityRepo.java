package com.sphospital.master_service.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sphospital.master_service.model.DoctorAvailability;

public interface DoctorAvailabilityRepo extends JpaRepository<DoctorAvailability, BigDecimal>{
	Void deleteByHpDocEmpId(String hpDocEmpId);
	
	List<DoctorAvailability> findByHpDocEmpId(String hpDocEmpId);
}
