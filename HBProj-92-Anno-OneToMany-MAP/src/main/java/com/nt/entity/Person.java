package com.nt.entity;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_PERSON_ANNO_MAP")
public class Person implements Serializable {
	@Id
	@GeneratedValue
	private Integer pid;
	@NonNull
	@Column(length = 15)
	private String pname;
	@NonNull
	@Column(length = 15)
	private String paddrs;
	@NonNull
	@OneToMany(targetEntity = BankAccount.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@Fetch(FetchMode.JOIN)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@JoinColumn(name = "MAP_ID",referencedColumnName = "PID")
	@MapKeyColumn(name = "MAP_INDEX")
	
	private Map<String,BankAccount> accounts;
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	public Person() {
		System.out.println("Person.Person()");
	}
}
