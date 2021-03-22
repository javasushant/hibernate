package com.nt.test;


import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.procedure.ProcedureCall;
//import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class ProcedureCallTest {

	public static void main(String[] args) {
		
		try(Session ses= HibernateUtil.getSession()){
			//create StoreProcedure Object having PL/SQL procedure name
			ProcedureCall procedure = ses.createStoredProcedureCall("P_AUTHENTICATION");
			//Bind Parameter
			procedure.registerParameter("UNAME", String.class, ParameterMode.IN).bindValue("raja");
			procedure.registerParameter("PASS", String.class, ParameterMode.IN).bindValue("rani");
			procedure.registerParameter("RESULT", String.class, ParameterMode.OUT);
			//call PL/SQL procedure
			String result = (String) procedure.getOutputParameterValue("RESULT");
			System.out.println("RESULT IS "+result);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
