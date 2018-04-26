package com.advancia.batch.simplepayroll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("simpleItemWriter")
public class SimpleItemWriter extends AbstractItemWriter {

	//@PersistenceContext
	//EntityManager em;
	
	@Override
	public void writeItems(List<Object> items) throws Exception {
		
		String fileOutputName = "risultato";
		String path = "C:\\temp";
		
		File outputFile = new File (path, fileOutputName);
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
		for (Object obj : items) {
			System.out.println("PayrollRecord: " + obj);
			//em.persist(obj);
			br.write((String) obj);
			
		}
	}

}