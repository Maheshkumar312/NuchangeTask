package com.prodian.JobTask.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodian.JobTask.model.Pojo;

public interface NuchangeRepo extends JpaRepository<Pojo,String>{

	public Pojo findByUrl(String url);
}
