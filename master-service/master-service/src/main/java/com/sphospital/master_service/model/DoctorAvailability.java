package com.sphospital.master_service.model;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sp_mas_docter_availability")
public class DoctorAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hp_avail_row_id")
    private int hpAvailRowId;

    @Column(name = "hp_doc_emp_id", nullable = false)
    private String hpDocEmpId;

    @Column(name = "hp_avail_days", nullable = false)
    private String hpAvailDays;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hp_avail_time_from", nullable = false)
    private LocalTime hpAvailTimeFrom;

    @JsonFormat(pattern = "HH:mm")
    @Column(name = "hp_avail_time_to", nullable = false)
    private LocalTime hpAvailTimeTo;

	public int getHpAvailRowId() {
		return hpAvailRowId;
	}

	public void setHpAvailRowId(int hpAvailRowId) {
		this.hpAvailRowId = hpAvailRowId;
	}

	public String getHpDocEmpId() {
		return hpDocEmpId;
	}

	public void setHpDocEmpId(String hpDocEmpId) {
		this.hpDocEmpId = hpDocEmpId;
	}

	public String getHpAvailDays() {
		return hpAvailDays;
	}

	public void setHpAvailDays(String hpAvailDays) {
		this.hpAvailDays = hpAvailDays;
	}

	public LocalTime getHpAvailTimeFrom() {
		return hpAvailTimeFrom;
	}

	public void setHpAvailTimeFrom(LocalTime hpAvailTimeFrom) {
		this.hpAvailTimeFrom = hpAvailTimeFrom;
	}

	public LocalTime getHpAvailTimeTo() {
		return hpAvailTimeTo;
	}

	public void setHpAvailTimeTo(LocalTime hpAvailTimeTo) {
		this.hpAvailTimeTo = hpAvailTimeTo;
	}
    
    
}