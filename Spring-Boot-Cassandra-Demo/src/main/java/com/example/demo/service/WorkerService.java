package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Worker;

public interface WorkerService {

	Worker addWorker(Worker worker);

	List<Worker> getAllWorkers();

	Optional<Worker> getWorkerById(int id);

	List<Worker> getByWorkingStatus();

	Worker updateWorker(Worker worker);

	void removeWorker(int id);

	void removeAllWorkers();

	List<Worker> getWorkerByName(String name);

}
