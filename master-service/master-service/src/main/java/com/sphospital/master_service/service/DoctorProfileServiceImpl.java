package com.sphospital.master_service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sphospital.master_service.model.DoctorAvailability;
import com.sphospital.master_service.model.DoctorProfile;
import com.sphospital.master_service.repo.DoctorAvailabilityRepo;
import com.sphospital.master_service.repo.DoctorProfileRepo;

@Service
public class DoctorProfileServiceImpl implements DoctorProfileService{

	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private DoctorProfileRepo doctorProfileRepo;
	
	@Autowired
	private DoctorAvailabilityRepo doctorAvailabilityRepo;

	@Override
	public DoctorProfile getDoctorsDetailsByEmpId(String hpDocEmpId) {
		return doctorProfileRepo.findByHpDocEmpId(hpDocEmpId);
	}

	@Override
	public Map<String, Object> saveDoctorDetails(Map<String, Object> requestMap) {
		Map<String, Object> responseHashMap = new HashMap<String, Object>();
		try {
			Object doctorProfileObj = requestMap.get("doctorProfile");
			DoctorProfile doctorProfile;

			if (doctorProfileObj instanceof DoctorProfile) {
			    doctorProfile = (DoctorProfile) doctorProfileObj;
			} else {
			    doctorProfile = objectMapper.convertValue(doctorProfileObj, DoctorProfile.class);
			}if (doctorProfile != null) {
			    doctorProfile = doctorProfileRepo.save(doctorProfile);
			    responseHashMap.put("doctorProfile", doctorProfile);
			    List<DoctorAvailability> doctorAvailability = new ArrayList<>();
			    Object availabilityObj = requestMap.get("doctorAvailability");

			    if (availabilityObj instanceof List<?>) {
			        doctorAvailability = objectMapper.convertValue(
			            availabilityObj,
			            new TypeReference<List<DoctorAvailability>>() {}
			        );
			    }
			    if (!doctorAvailability.isEmpty()) {
			        doctorAvailability = doctorAvailabilityRepo.saveAll(doctorAvailability);
			        responseHashMap.put("doctorAvailability", doctorAvailability);
			    }
			}
			responseHashMap.put("Success", true);

		}catch(DataIntegrityViolationException e) {
			responseHashMap.put("Success", false);
			String message = e.getMostSpecificCause().getMessage();
		    if (message.contains("hp_doc_emp_id")) {
		        responseHashMap.put("errorMsg", "Doctor ID already exists. Please use a unique ID.");
		    } else if (message.contains("hp_mob_no")) {
		        responseHashMap.put("errorMsg", "Mobile number is already registered.");
		    } else if (message.contains("hp_doc_email")) {
		        responseHashMap.put("errorMsg", "Email is already registered.");
		    } else {
		        responseHashMap.put("errorMsg", "Duplicate entry or constraint violation. ie) "+e.getMessage());
		    }
		}
		return responseHashMap;
	}
	
	@Override
	public Map<String, Object> getDoctorsList() {
		Map<String, Object> responseHashMap = new HashMap<String, Object>();
		try {
			List<DoctorProfile> profiles = doctorProfileRepo.findAll();
		    List<Map<String, Object>> searchResults = new ArrayList<>();

		    for (DoctorProfile profile : profiles) {
		        Map<String, Object> profileMap = new HashMap<>();
		        profileMap.put("hpDocEmpId", profile.getHpDocEmpId());
		        profileMap.put("hpDocName", profile.getHpDocName());
		        profileMap.put("hpDocEmail", profile.getHpDocEmail());
		        profileMap.put("hpMobNo", profile.getHpMobNo());
		        profileMap.put("hpLocation", profile.getHpLocation());
		        profileMap.put("hpLangKnown", profile.getHpLangKnown());
		        profileMap.put("hpQualification", profile.getHpQualification());
		        profileMap.put("hpDocSpeciality", profile.getHpDocSpeciality());
		        profileMap.put("hpDocExperience", String.valueOf(profile.getHpDocExperience()));
		        List<DoctorAvailability> availabilities = doctorAvailabilityRepo.findByHpDocEmpId(profile.getHpDocEmpId());
		        List<Map<String, Object>> availabilityList = new ArrayList<>();

		        for (DoctorAvailability availability : availabilities) {
		            Map<String, Object> availMap = new HashMap<>();
		            availMap.put("hpDocEmpId", availability.getHpDocEmpId());
		            availMap.put("hpAvailDays", availability.getHpAvailDays());
		            availMap.put("hpAvailTimeFrom", availability.getHpAvailTimeFrom().toString());
		            availMap.put("hpAvailTimeTo", availability.getHpAvailTimeTo().toString());
		            availMap.put("hpAvailRowId", availability.getHpAvailRowId() == 0 ? null : availability.getHpAvailRowId());
		            availabilityList.add(availMap);
		        }
		        profileMap.put("availabilityList", availabilityList);
		        searchResults.add(profileMap);
		    }
		    responseHashMap.put("searchResults", searchResults);
			responseHashMap.put("Success", true);

		}catch(DataIntegrityViolationException e) {
			responseHashMap.put("Success", false);
			responseHashMap.put("errorMsg", " "+e.getMessage());
		}
		return responseHashMap;
	}

}
