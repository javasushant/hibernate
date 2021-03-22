package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallerTune implements Serializable {
	private Integer callerTuneId;
	private String callerTune;
	private String provider;
	private Long mobileNo;
	private Integer changeCount;
	private Date timeOfUpdate;
//	private LocalDateTime timeOfUpdate;  /*works in Annotation driven only*/
}
