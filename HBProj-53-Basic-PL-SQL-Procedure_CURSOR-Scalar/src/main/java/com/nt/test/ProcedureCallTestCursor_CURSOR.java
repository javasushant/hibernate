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

public class ProcedureCallTestCursor_CURSOR {

	public static void main(String[] args) {
		
		try(Session ses= HibernateUtil.getSession()){
			//create StoreProcedure Object having PL/SQL procedure name
			ProcedureCall procedure = ses.createStoredProcedureCall("P_GET_EMPS_BY_ADDRS");
			//Bind Parameter
			procedure.registerParameter(1, String.class, ParameterMode.IN).bindValue("SOJ");
			procedure.registerParameter(2, String.class, ParameterMode.IN).bindValue("NMPR");
			procedure.registerParameter(3, new Object[] {}.getClass(), ParameterMode.REF_CURSOR);
			//call PL/SQL procedure
			ResultSetOutput output= (ResultSetOutput) procedure.getOutputs().getCurrent();
			List<Object[]> list=output.getResultList();
			list.forEach(row->{
				for(Object val:row) {
				System.out.print(val+" ");
				}
				System.out.println();
			});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
