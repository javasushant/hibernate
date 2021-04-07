package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "ALL_COLLLECTION_ANNO_TRAVELLER")
public class Traveller implements Serializable{
	@Id
	@GeneratedValue
	private Integer travellerId;
	@NonNull
	@Column(length = 14)
	private String travellerName;
	@NonNull
	private LocalDateTime dob;
	@NonNull
	@OrderColumn(name = "PHONE_INDEX")
	@ElementCollection
	@JoinColumn(name = "TRAVELLER_ID",referencedColumnName = "TRAVELLERID")
	@CollectionTable(name = "ALL_COLLECTION_PHONES")
	private Set<Long> phones;
	@NonNull
	@OrderColumn(name = "NICKNAMES_INDEX")
	@ListIndexBase(value = 1)
	@ElementCollection
	@JoinColumn(name = "TRAVELLER_ID",referencedColumnName = "TRAVELLER_ID")
	@CollectionTable(name = "ALL_COLLECTION_NICKNAMES")
	private List<String> nickNames;
	
	@NonNull
	@MapKeyColumn(name = "TOUR_NAME",length = 30)
	@JoinColumn(name = "TRAVELLER_ID", referencedColumnName = "TRAVELLERID")
	@ElementCollection
	@CollectionTable(name = "ALL_COLLECTION_TOURPLACE")
	private Map<String, String> placeVisited;
}
