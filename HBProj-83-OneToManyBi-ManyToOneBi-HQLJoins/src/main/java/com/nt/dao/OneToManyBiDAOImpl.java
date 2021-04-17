package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nt.utility.HibernateUtil;

public class OneToManyBiDAOImpl implements OneToManyBiDAO {

	@Override
	public void loadDataUsingParentToChildJoins() {
		try(Session ses=HibernateUtil.getSession()){
//			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Owner o inner join o.vehicles v");
//			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Owner o left join o.vehicles v");
//			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Owner o right join o.vehicles v");
			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Owner o full join o.vehicles v");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}

	@Override
	public void loadDataUsingChildToParentJoins() {
		try(Session ses=HibernateUtil.getSession()){
//			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Vehicle v inner join v.owner o");
//			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Vehicle v left join v.owner o");
//			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Vehicle v right join v.owner o");
			Query query=ses.createQuery("select o.ownerId,o.ownerName,o.ownerAddrs,v.vehicleId,v.vehicleName,v.companyName from Vehicle v full join v.owner o");
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				for(Object val:row) {
					System.out.print(val+" ");
				}
				System.out.println();
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}	
		
	

}//class
