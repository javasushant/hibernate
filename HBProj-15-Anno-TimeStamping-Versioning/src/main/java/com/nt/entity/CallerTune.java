package com.nt.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CALLERTUNE_ANNO_TS_Ver")
public class CallerTune implements Serializable {
	@Id
	@Type(type="int")
	@GeneratedValue
	private Integer callerTuneId;
	
	@Column(name = "callerTune_Nm", length = 20)
	@Type(type="string")
	private String callerTune;
	
	@Column(name = "callerTune_Provider" , length = 20)
	@Type(type="string")
	private String provider;
	
	@Column(name="Mobile")
	@Type(type = "long")
	private Long mobileNo;
	
	@Column(name="ChaneCount")
	@Type(type="int")
	@Version
	private Integer changeCount;
	
	/*
	 * @CreationTimestamp 
	 * // @Type(type="timestamp") 
	 * private Date createdOnDate;
	 * 
	 * @UpdateTimestamp 
	 * // @Type(type="timestamp")
	 *  private Date updatedOn;
	 */
	
	/*
	 * @CreationTimestamp
	 * 
	 * @Type(type="timestamp") 
	 * private Timestamp createdOnDate;
	 * 
	 * @UpdateTimestamp
	 * 
	 * @Type(type="timestamp") 
	 * private Timestamp updatedOn;
	 */
	
	@CreationTimestamp
	private LocalDateTime createdOnDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedOn;
}
