package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class InsurancePolicy implements Serializable {
	@Id
	@Column(name="POLICY_NO")
	private int policyNo;
	@Column(name="POLICY_NAME" ,length = 25)
	private String policyName;
	@Column(name="tenure" , length = 25)
	private String tenure;
	@Column(name="amount")
	private float amount;
}
