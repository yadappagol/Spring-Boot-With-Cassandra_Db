package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Worker;
import com.example.demo.service.WorkerService;

@RestController
@RequestMapping("/api/v1/workers")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	/**
	 * URL :http://localhost:8080/api/v1/workers
	 */
	@PostMapping
	public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
		try {
			Worker addWorker = workerService.addWorker(worker);
			return new ResponseEntity<>(addWorker, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * URL :http://localhost:8080/api/v1/workers
	 */
	@GetMapping
	public ResponseEntity<List<Worker>> getAllWorkers() {
		try {
			List<Worker> allWorkers = workerService.getAllWorkers();
			if (allWorkers.isEmpty())
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(allWorkers, HttpStatus.FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * URL :http://localhost:8080/api/v1/workers/{id}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Worker>> getWorkerById(@PathVariable int id) {
		Optional<Worker> workerById = workerService.getWorkerById(id);
		if (workerById.isPresent()) {
			return new ResponseEntity<>(workerById, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * URL :http://localhost:8080/api/v1/workers/{name}
	 */
	@GetMapping("/byname/{name}")
	public ResponseEntity<List<Worker>> getWorkerByName(@PathVariable String name) {
		List<Worker> workerByName = workerService.getWorkerByName(name);
		return new ResponseEntity<>(workerByName, HttpStatus.FOUND);
	}

	/**
	 * URL :http://localhost:8080/api/v1/workers/workingworkers
	 */
	@GetMapping("/workingworkers")
	public ResponseEntity<List<Worker>> getByWorkingStatus() {
		try {
			List<Worker> byWorkingStatus = workerService.getByWorkingStatus();

			if (byWorkingStatus.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(byWorkingStatus, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * URL :http://localhost:8080/api/v1/workers/
	 */
	@PutMapping("/")
	public ResponseEntity<Worker> updateWorker(@RequestBody Worker worker) {
		try {
			Worker updateWorker = workerService.updateWorker(worker);
			return new ResponseEntity<>(updateWorker, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	/**
	 * URL :http://localhost:8080/api/v1/workers/{id}
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeWorker(@PathVariable int id) {

		try {
			workerService.removeWorker(id);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * URL :http://localhost:8080/api/v1/workers/
	 */
	@DeleteMapping("/")
	public ResponseEntity<?> removeAllWorkers() {
		try {
			workerService.removeAllWorkers();
			return new ResponseEntity<>("Deleted SuccessFully..", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
