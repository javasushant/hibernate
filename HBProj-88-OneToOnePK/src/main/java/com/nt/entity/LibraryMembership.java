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
public class LibraryMembership implements Serializable {
	
	private Long lId;
	@NonNull
	private String membershipType;
	@NonNull
	private String issuedBy;
	@NonNull
	private LocalDateTime validFrom;
	@NonNull
	private LocalDateTime validUpto;
	
	private Student studentDetails;
	
	
	
	public LibraryMembership() {
		System.out.println("LibraryMembership :: 0-param -constructor");
	}



	@Override
	public String toString() {
		return "LibraryMembership [lId=" + lId + ", membershipType=" + membershipType + ", issuedBy=" + issuedBy
				+ ", validFrom=" + validFrom + ", validUpto=" + validUpto + ", studentDetails=" + studentDetails + "]";
	}



	public Long getlId() {
		return lId;
	}



	public void setlId(Long lId) {
		this.lId = lId;
	}



	public String getMembershipType() {
		return membershipType;
	}



	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
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



	public Student getStudentDetails() {
		return studentDetails;
	}



	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}



	
	
	
}
