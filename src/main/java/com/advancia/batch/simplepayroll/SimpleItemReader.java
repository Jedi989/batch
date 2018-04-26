package com.advancia.batch.simplepayroll;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Properties;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named; 

@Named
public class SimpleItemReader extends AbstractItemReader {

	@Inject
	private JobContext jobContext;
	private String line = null; //aggiunto da me
	private int recordNumber = 0; //aggiunto da me

	@Override
	public void open(Serializable prevCheckpointInfo) throws Exception {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties jobParameters = jobOperator.getParameters(jobContext.getExecutionId());
		String resourceName = (String) jobParameters.get("payrollInputDataFileName");
		FileInputStream inputStream = new FileInputStream(resourceName);
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

		Integer recordNumber = 0;
		if (prevCheckpointInfo != null)
			recordNumber = (Integer) prevCheckpointInfo;
		for (int i = 1; i < recordNumber; i++) { // Skip upto recordNumber
			line = br.readLine();
		}
		System.out.println("[SimpleItemReader] Opened Payroll file for reading from record number: " + recordNumber);
		br.close(); //aggiunto da me
	}

	@Override
	public Object readItem() throws Exception {
		Object record = null;
		if (line != null) {
			String[] fields = line.split("[, \t\r\n]+");
			PayrollInputRecord payrollInputRecord = new PayrollInputRecord();
			payrollInputRecord.setId(Integer.parseInt(fields[0]));
			payrollInputRecord.setBaseSalary(Integer.parseInt(fields[1]));
			record = payrollInputRecord;
			// Now that we could successfully read, Increment the record number
			recordNumber++;
		}
		return record;
	}

	@Override
	public Serializable checkpointInfo() throws Exception {
		return recordNumber;
	}

}