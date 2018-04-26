package com.advancia.schedule;

import java.util.logging.Logger;

import javax.ejb.*;

@LocalBean
@Singleton
@Startup
public class SimpleScheduler {
	private static final Logger LOG = Logger.getLogger(SimpleScheduler.class.getName());

	@Schedule(second = "*/3")
	public void sveglia() {
		LOG.info("sveglia!");
	}
}
