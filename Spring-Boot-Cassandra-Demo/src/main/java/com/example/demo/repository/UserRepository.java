package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.demo.model.User;

public interface UserRepository extends CassandraRepository<User, Integer> {

}
