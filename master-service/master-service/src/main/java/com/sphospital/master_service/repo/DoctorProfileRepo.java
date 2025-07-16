package com.sphospital.master_service.repo;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sphospital.master_service.model.DoctorProfile;

@Repository
public interface DoctorProfileRepo extends JpaRepository<DoctorProfile, BigDecimal>{

	DoctorProfile findByHpDocEmpId(String hpDocEmpId);
	
}
