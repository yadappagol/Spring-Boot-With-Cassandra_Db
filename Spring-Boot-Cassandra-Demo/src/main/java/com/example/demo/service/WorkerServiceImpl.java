package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository workerRepository;

	@Override
	public Worker addWorker(Worker worker) {
		return workerRepository.save(worker);
	}

	@Override
	public List<Worker> getAllWorkers() {
		return workerRepository.findAll();
	}

	@Override
	public Optional<Worker> getWorkerById(int id) {
		return workerRepository.findById(id);
	}

	@Override
	public List<Worker> getByWorkingStatus() {
		return workerRepository.findByWorkingStatus(true);
	}

	@Override
	public Worker updateWorker(Worker worker) {
		return workerRepository.save(worker);

	}

	@Override
	public void removeWorker(int id) {
		workerRepository.deleteById(id);
	}

	@Override
	public void removeAllWorkers() {
		workerRepository.deleteAll();
	}

	@Override
	public List<Worker> getWorkerByName(String name) {
		return workerRepository.findByName(name);
	}

}
