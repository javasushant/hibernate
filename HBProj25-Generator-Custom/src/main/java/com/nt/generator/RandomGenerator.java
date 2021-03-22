package com.nt.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomGenerator implements IdentifierGenerator {
	
	public RandomGenerator() {
		System.out.println("RandomGenerator ::0-param-constructor");
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		System.out.println("RandomGenerator.generate()");
		//generator random number
		Random rad = new Random();
		int idVal = rad.nextInt(1000);
		
		return idVal;
	}

}
