package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Traveller implements Serializable{
	
	private Integer travellerId;
	@NonNull
	private String travellerName;
	@NonNull
	private LocalDateTime dob;
	@NonNull
	private Set<Long> phones;
	@NonNull
	private Map<String, Object> placeVisited;
}
