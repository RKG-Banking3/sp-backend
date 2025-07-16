package com.sphospital.master_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sp_mas_docter_profile")
public class DoctorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hp_doc_row_id")
    private int hpDocRowId;

    @Column(name = "hp_doc_emp_id", nullable = false, unique = true)
    private String hpDocEmpId;

    @Column(name = "hp_doc_name", nullable = false)
    private String hpDocName;

    @Column(name = "hp_doc_experience")
    private int hpDocExperience;

    @Column(name = "hp_lang_known")
    private String hpLangKnown;

    @Column(name = "hp_doc_email", unique = true)
    private String hpDocEmail;

    @Column(name = "hp_mob_no", unique = true)
    private String hpMobNo;

    @Column(name = "hp_location")
    private String hpLocation;

    @Column(name = "hp_qualification")
    private String hpQualification;
    
    @Column(name = "hp_doc_speciality")
    private String hpDocSpeciality;

    @Column(name = "hp_doc_image_path")
    private String hpDocImagePath;

	public int getHpDocRowId() {
		return hpDocRowId;
	}

	public void setHpDocRowId(int hpDocRowId) {
		this.hpDocRowId = hpDocRowId;
	}

	public String getHpDocEmpId() {
		return hpDocEmpId;
	}

	public void setHpDocEmpId(String hpDocEmpId) {
		this.hpDocEmpId = hpDocEmpId;
	}

	public String getHpDocName() {
		return hpDocName;
	}

	public void setHpDocName(String hpDocName) {
		this.hpDocName = hpDocName;
	}

	public int getHpDocExperience() {
		return hpDocExperience;
	}

	public void setHpDocExperience(int hpDocExperience) {
		this.hpDocExperience = hpDocExperience;
	}

	public String getHpLangKnown() {
		return hpLangKnown;
	}

	public void setHpLangKnown(String hpLangKnown) {
		this.hpLangKnown = hpLangKnown;
	}

	public String getHpDocEmail() {
		return hpDocEmail;
	}

	public void setHpDocEmail(String hpDocEmail) {
		this.hpDocEmail = hpDocEmail;
	}

	public String getHpMobNo() {
		return hpMobNo;
	}

	public void setHpMobNo(String hpMobNo) {
		this.hpMobNo = hpMobNo;
	}

	public String getHpLocation() {
		return hpLocation;
	}

	public void setHpLocation(String hpLocation) {
		this.hpLocation = hpLocation;
	}

	public String getHpQualification() {
		return hpQualification;
	}

	public void setHpQualification(String hpQualification) {
		this.hpQualification = hpQualification;
	}

	public String getHpDocSpeciality() {
		return hpDocSpeciality;
	}

	public void setHpDocSpeciality(String hpDocSpeciality) {
		this.hpDocSpeciality = hpDocSpeciality;
	}

	public String getHpDocImagePath() {
		return hpDocImagePath;
	}

	public void setHpDocImagePath(String hpDocImagePath) {
		this.hpDocImagePath = hpDocImagePath;
	}

}

