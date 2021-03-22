package com.nt.dto;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePolicyDTO implements Serializable {
	private int policyId;
	private String policyName;
	private String company;
	private int tenure;
}
