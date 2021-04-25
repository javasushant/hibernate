package com.nt.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "OTM_ANNO_PERSON_LIST")
public class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	@NonNull
	@Column(length = 15)
	private String pname;
	@NonNull
	@Column(length = 15)
	private String paddrs;
	@NonNull
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = BankAccount.class,orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	@OrderColumn(name = "LIST_INDEX")
	@ListIndexBase(value = 1)
	
	private List<BankAccount> accounts;
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	public Person() {
		System.out.println("Person.Person()");
	}
}
