package com.advancia.batch.simplepayroll;

import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class SimpleItemWriter extends AbstractItemWriter {

	@PersistenceContext
	EntityManager em;

	@Override
	public void writeItems(List<Object> items) throws Exception {
		for (Object obj : items) {
			System.out.println("PayrollRecord: " + obj);
			em.persist(obj);
		}
	}

}