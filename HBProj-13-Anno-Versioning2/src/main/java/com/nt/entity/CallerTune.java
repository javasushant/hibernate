package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CALLERTUNE_ANNO")
public class CallerTune implements Serializable {
	@Id
	@Type(type="int")
	@GeneratedValue
	private Integer callerTuneId;
	@Column(name = "callerTune_Nm")
	@Type(type="string")
	private String callerTune;
	@Column(name = "callerTune_Provider")
	@Type(type="string")
	private String provider;
	@Column(name="Mobile")
	@Type(type = "long")
	private Long mobileNo;
	@Column(name="ChaneCount")
	@Type(type="int")
	@Version
	private Integer changeCount;
}
