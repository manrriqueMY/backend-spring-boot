package com.example.demo.services.daos;

import com.example.demo.models.Poll;

import org.springframework.data.repository.CrudRepository;

public interface IDPoll extends CrudRepository<Poll, Long> {

}