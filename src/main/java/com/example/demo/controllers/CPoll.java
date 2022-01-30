package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Poll;
import com.example.demo.services.interfaces.SPoll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/poll")
public class CPoll {
    @Autowired
    private SPoll spoll;

    @PostMapping(path = "/save", produces = "application/json")
    public Poll save(@RequestBody Poll poll) {
        return spoll.save(poll);
    }

    @GetMapping(path = "/get", produces = "application/json")
    public List<Poll> get() {
        return spoll.get();
    }

    @GetMapping(path = "/report", produces = "application/json")
    public List report() {
        return spoll.report();
    }
}