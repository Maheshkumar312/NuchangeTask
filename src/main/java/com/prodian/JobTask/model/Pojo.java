package com.prodian.JobTask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Pojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	 @GeneratedValue(generator="system-uuid")
//	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private Integer count;
	private String url;
	private String uniqueId;
	
}
