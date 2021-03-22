package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

import lombok.Data;
@Data
@Entity
public class Programmer_Project implements Serializable {
	@EmbeddedId
	private PrgmrProjId id;
	private String prgmrName;
	private Integer age;
	private String projName;
	private Integer teamSize;
}
