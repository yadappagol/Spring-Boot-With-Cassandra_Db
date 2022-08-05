package com.example.demo.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Worker {

	@PrimaryKey
	private int id;
	private String name;
	private String surname;
	private boolean workingStatus;

}
