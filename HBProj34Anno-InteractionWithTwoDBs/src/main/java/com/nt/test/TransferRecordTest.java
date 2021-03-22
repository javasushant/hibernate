package com.nt.test;

import org.hibernate.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.InsurancePolicy;
import com.nt.utility.HibernateUtilMysql;
import com.nt.utility.HibernateUtilOra;

public class TransferRecordTest 
{
    public static void main( String[] args )
    {
    	Transaction tx = null;
    	try(SessionFactory oraFactory= HibernateUtilOra.getSessionFactory();
    			SessionFactory mysqlFactory=HibernateUtilMysql.getSessionFactory()){
    		try(Session oraSes =HibernateUtilOra.openSession();
    				Session mysqlSes=HibernateUtilMysql.openSession()){
    			tx= mysqlSes.beginTransaction();
    			//load object /record from oracle \
    			InsurancePolicy policy = oraSes.get(InsurancePolicy.class,16);
    			System.out.println(policy);
    					if(policy==null) {
    						System.out.println("record not found");
    					}
    					else {
//    						//save object to mysql
    						mysqlSes.save(policy);
    						tx.commit();
    						System.out.println("record/object is transfered");
    					}
    		}//try2
    	}//try1
    	catch(HibernateException he) {
    		if(tx!=null  && tx.getStatus()!=null  && tx.getRollbackOnly())
    			tx.rollback();
    		he.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
