package com.example.demo.services.implementes;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.models.Poll;
import com.example.demo.services.daos.IDPoll;
import com.example.demo.services.interfaces.SPoll;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPoll implements SPoll {

	@Autowired
	private EntityManager em;

	@Autowired
	private IDPoll pollDao;

	public List<Poll> get() {
		return (List<Poll>) pollDao.findAll();
	}

	public Poll save(Poll poll) {
		return pollDao.save(poll);
	}

	public List report() {
		Criteria crit = em.unwrap(Session.class).createCriteria(Poll.class);
		ProjectionList proList = Projections.projectionList();
		proList.add(Projections.count("music"));
		proList.add(Projections.groupProperty("music").as("name"));
		crit.setProjection(proList);
		return crit.list();
	}
}