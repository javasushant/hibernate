package com.nt.test;


import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.procedure.ProcedureCall;
//import org.hibernate.query.Query;
import org.hibernate.result.ResultSetOutput;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ProcedureCallTestCursor {

	public static void main(String[] args) {
		
		try(Session ses= HibernateUtil.getSession()){
			//create StoreProcedure Object having PL/SQL procedure name
			ProcedureCall procedure = ses.createStoredProcedureCall("P_GET_EMPS_BY_SALARY_RANGE",Employee.class);
			//Bind Parameter
			procedure.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(50000);
			procedure.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(1000000);
			procedure.registerParameter(3, Employee.class, ParameterMode.REF_CURSOR);
			//call PL/SQL procedure
			ResultSetOutput output= (ResultSetOutput) procedure.getOutputs().getCurrent();
			List<Employee> list=output.getResultList();
			list.forEach(emp->{
				System.out.println(emp);
			});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
