package com.nt.test;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.procedure.ProcedureCall;
//import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class FunctionalCallTest {

	public static void main(String[] args) {
		
		try(Session ses= HibernateUtil.getSession()){
			//create StoreProcedure Object having PL/SQL procedure name
			String result=ses.doReturningWork(new ReturningWork<String>() {

				@Override
				public String execute(Connection con) throws SQLException {
					//write plain jdbc code to work with PL/SQL function 
					CallableStatement cs =con.prepareCall("{?=call FX_aUTH(?,?)}");
					cs.registerOutParameter(1, Types.VARCHAR);
					cs.setString(2, "raja");
					cs.setString(3, "rani");
					//execute callble statement
					cs.execute();
					String result = cs.getString(1);
					return result;
				}//execute()
			}//annonymus inner class
			); //method call
			System.out.println("Result is "+result);
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}

}
