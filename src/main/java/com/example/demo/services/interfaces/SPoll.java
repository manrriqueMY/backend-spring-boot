package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.models.Poll;

public interface SPoll {

    public List<Poll> get();

    public Poll save(Poll poll);

    public List report();

}