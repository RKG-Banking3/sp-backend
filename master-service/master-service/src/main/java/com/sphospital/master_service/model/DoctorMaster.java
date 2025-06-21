package com.sphospital.master_service.model;

public class DoctorMaster {

	private int docId;
	private String doctorName;
	private String doctorMobileNo;
	private String doctorCity;
	
	
	
	public DoctorMaster(int rowId, String doctorName, String doctorMobileNo, String doctorCity) {
		super();
		this.docId = rowId;
		this.doctorName = doctorName;
		this.doctorMobileNo = doctorMobileNo;
		this.doctorCity = doctorCity;
	}
	public int getRowId() {
		return docId;
	}
	public void setRowId(int rowId) {
		this.docId = rowId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorMobileNo() {
		return doctorMobileNo;
	}
	public void setDoctorMobileNo(String doctorMobileNo) {
		this.doctorMobileNo = doctorMobileNo;
	}
	public String getDoctorCity() {
		return doctorCity;
	}
	public void setDoctorCity(String doctorCity) {
		this.doctorCity = doctorCity;
	}
	
	
	
}
