package com.advancia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advancia.batch.simplepayroll.*;
/*
 * <servlet>
 * 	<servlet-name>un nome di fantasia</servlet-name>
 * 	<servlet-class>com.advancia.web.PayrollJobSubmitterServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * 	<servlet-name>un nome di fantasia</servlet-name>
 * 	<url-pattern>/payrollJob/submit</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns = "/payrollJob/submit")
public class PayrollJobSubmitterServlet extends HttpServlet {

	
	
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {			
			long executionId = startNewBatchJob();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private long startNewBatchJob() throws Exception {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		Properties props = new Properties();
		props.setProperty("payrollInputDataFileName", "payrollInputDataFileName");
		return jobOperator.start("SimplePayrollJob", props);
	}
}
