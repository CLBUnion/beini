package com.beini.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVo implements Serializable{
	private static final long serialVersionUID = -3110583L;
	
	
	private Integer id;
	private String name;
}
