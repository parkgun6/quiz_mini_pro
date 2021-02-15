package org.keroro.time.dao;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests {
	private TimeDAO timeDAO;
	
	@Before
	public void ready() {
		timeDAO = new TimeDAO();
	}
	
	@Test
	public void testGetTime() {
		log.info(timeDAO.getTime());
	}
}
