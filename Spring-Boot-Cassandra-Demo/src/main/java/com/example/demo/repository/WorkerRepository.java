package com.example.demo.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Worker;

@Repository
public interface WorkerRepository extends CassandraRepository<Worker, Integer> {

	@AllowFiltering
	List<Worker> findByWorkingStatus(boolean workingStatus);

	@AllowFiltering	
	List<Worker> findByName(String name);
}
