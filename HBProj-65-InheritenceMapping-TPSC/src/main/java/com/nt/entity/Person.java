package com.nt.entity;

import java.io.Serializable;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Person  implements Serializable{
	private int pid;
	@NonNull
	private String pname;
	@NonNull
	private String padd;
	@NonNull
	private String company;
}
