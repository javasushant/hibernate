package com.nt.tes;

import java.util.Arrays;

import com.nt.entity.Test;

public class VariousObjectTest {

	public static void main(String[] args) {
		
		try {
			//load the class
			Class c = Class.forName(args[0]);
			//ceate the ibject for loaded class dynamically
			Object obj = c.newInstance();
			System.out.println("obj class aame :"+obj.getClass()+"obj hashCode  : "+obj.hashCode()+"obj data "+obj);
			System.out.println("c obj holded class related super class name" +c.getSuperclass().getName());
			System.out.println("c1 obj holded class related method definition :"+Arrays.toString(c.getDeclaredMethods()));
			System.out.println("c1 obj holded class related constructor "+Arrays.deepToString(c.getDeclaredConstructors()));
		System.out.println("====================================");
		System.out.println("");
			Class c1 = Test.class;
			System.out.println("c obj data " +c1.toString());
			System.out.println("c obj data " +c1.getName());
			System.out.println("c obj data " +c1.hashCode());
			System.out.println("c obj holded class related super class name" +c1.getSuperclass().getName());
			System.out.println("c1 obj holded class related method definition :"+Arrays.toString(c1.getDeclaredMethods()));
			System.out.println("c1 obj holded class related constructor "+Arrays.deepToString(c1.getDeclaredConstructors()));
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		
	}

}
