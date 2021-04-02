package com.nt.entity;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name="INH_PAYMENT_TPSC")
@Inheritance(strategy = InheritanceType.JOINED)

//@DiscriminatorColumn(name="PAYMENT_TYPE", discriminatorType =DiscriminatorType.STRING,length = 15)

public abstract class Payment {
	@Id
	@GeneratedValue
	private Integer pid;
	private Double amount;
	@CreationTimestamp
	private LocalDateTime pdate;
}
