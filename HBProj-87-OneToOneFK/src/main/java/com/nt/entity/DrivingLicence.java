package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class DrivingLicence implements Serializable {
	
	private Long lId;
	@NonNull
	private String licenseType;
	@NonNull
	private String issuedBy;
	@NonNull
	private LocalDateTime validFrom;
	@NonNull
	private LocalDateTime validUpto;
	
	private Person licenseHolder;
	
	
	
	public DrivingLicence() {
		System.out.println("DrivingLicence :: 0-param -constructor");
	}

	@Override
	public String toString() {
		return "DrivingLicence [lId=" + lId + ", licenseType=" + licenseType + ", issuedBy=" + issuedBy + ", validFrom="
				+ validFrom + ", validUpto=" + validUpto ;
	}

	public Long getlId() {
		return lId;
	}

	public void setlId(Long lId) {
		this.lId = lId;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public LocalDateTime getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDateTime validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDateTime getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(LocalDateTime validUpto) {
		this.validUpto = validUpto;
	}

	public Person getLicenseHolder() {
		return licenseHolder;
	}

	public void setLicenseHolder(Person licenseHolder) {
		this.licenseHolder = licenseHolder;
	}

	
	
	
}
