package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="INSURANCE_POLICY")
public class InsurancePolicy {
	@Id
	@GeneratedValue
	@Column(name="policy_id")
	private int policyId;
	@Column(name="policy_name" ,length = 24,unique = true, nullable = false)
	private String policyName;
	@Column(name="company" , length = 24)
	private String company;
	@Column(name="tenure")
	private int tenure;
}
