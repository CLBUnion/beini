package com.beini.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductVo implements Serializable{
	private static final long serialVersionUID = -311058059686984763L;
	private Integer id;
	private String name;
}
