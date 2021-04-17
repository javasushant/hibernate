package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Department;
import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class MtoDAOImpl implements MtoDAO {

	@Override
	public void saveData() {
		//get Session
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//prepare Object (Parent)
			Department dept1=new Department("Aggriculture", "Bihar");
			Department dept2=new Department("Social", "Bihar");
			//prepare Object (Child)
			Employee emp1= new Employee("Ravi", "SPJ", 30000.0, dept1);
			Employee emp2= new Employee("raja", "Namapur", 88000.0, dept1);
			Employee emp3= new Employee("ramesh", "DDP", 66000.0, dept2);
			Employee emp4= new Employee("suresh", "Patna", 85000.0, dept2);
			
			//begin transaction
			tx=ses.beginTransaction();
			ses.save(emp1); ses.save(emp2); ses.save(emp3); ses.save(emp4);
			//comit the code
			tx.commit();
			System.out.println("Objects are saved (child to parent)");
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				 System.out.println("Objects are not saved (child to parent)");
			}//if
		}//catch
	}//saveData

	@Override
	public void deletingAllChildsAndItsParent() {
		//get Session
				Transaction tx=null;
				try(Session ses=HibernateUtil.getSession()){
					Employee emp1=ses.get(Employee.class, 261);
					Employee emp2=ses.get(Employee.class, 263);
					
					//begin transaction
					tx=ses.beginTransaction();
					ses.delete(emp1);
					ses.delete(emp2);
					tx.commit();
					System.out.println("All childs and  its parent are deleted");
				}
				catch(HibernateException he) {
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
						tx.rollback();
						 System.out.println("Objects are not saved (child to parent)");
					}//if
				}//catch
		
	}//mthod

	@Override
	public void deletingOneChildFromCollectionOfChildsBelonginToAParent() {
		//get Session
		Transaction tx=null;
		try(Session ses=HibernateUtil.getSession()){
			//begin tx
			tx=ses.beginTransaction();
			//prepare and execute HQL query
			Query query=ses.createQuery("DELETE FROM Employee WHERE eno=?1");
			query.setParameter(1, 264);
			int count=query.executeUpdate();
			if(count==1)
				System.out.println("One child of Collection childs belonging to a Parent  is deleted");
			tx.commit();
			
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				 System.out.println("Objects are not saved (child to parent)");
			}//if
		}//catch
	}

	@Override
	public void loadDataUsingChild() {
		//get Session
				Transaction tx=null;
				try(Session ses=HibernateUtil.getSession()){
					//prepare and execute HQL query
					Query query=ses.createQuery("FROM Employee");
					//process the result
					List<Employee> list= query.getResultList();
					list.forEach(emp->{
						System.out.println(emp);
						Department dept=emp.getDept();
						System.out.println(dept);
					});
				}
				catch(HibernateException he) {
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
						tx.rollback();
						 System.out.println("Objects are not saved (child to parent)");
					}//if
				}//catch
	}
}//class
