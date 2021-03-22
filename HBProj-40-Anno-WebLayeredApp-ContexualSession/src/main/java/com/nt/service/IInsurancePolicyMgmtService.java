package com.nt.service;

import com.nt.dto.InsurancePolicyDTO;
import com.nt.entity.InsurancePolicy;

public interface IInsurancePolicyMgmtService {
	public InsurancePolicyDTO fetchDetailsByPolicyId(int policyId);
}
