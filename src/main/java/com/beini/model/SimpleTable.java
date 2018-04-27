package com.beini.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTable implements Serializable{
	private static final long serialVersionUID = -75529221256L;
	private Integer runType;
	private String name;
	private String nameEn;
	@Override
	public String toString() {
		return "SimpleTable [runType=" + runType + ", name=" + name + ", nameEn=" + nameEn + "]";
	}
	
}
