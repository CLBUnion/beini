package com.beini.gen_entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = -3854004123269370247L;
	private Integer id;
	private String name;
}
