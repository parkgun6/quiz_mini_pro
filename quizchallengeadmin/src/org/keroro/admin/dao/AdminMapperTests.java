package org.keroro.admin.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.keroro.admin.domain.Admin;
import org.keroro.common.util.PageInfo;

import lombok.Builder.Default;
import lombok.extern.log4j.Log4j;

@Log4j
public class AdminMapperTests {
	@Default
	private AdminDAO dao;
	
	@Before
	public void ready() {
		
		dao = new AdminDAO();

	}
	
	@Test
	public void testGetAdmin() {
		Admin admin = Admin.builder().aid("mingyuAdmin").apw("134").build();
		
		Admin result = dao.getAdmin(admin);
		
		log.info(result);
		
		
	}
	
	@Test
	public void testGetList() throws Exception{
		
		PageInfo pageInfo = new PageInfo();
		
		List<Admin> memberList = dao.getList(pageInfo);
		
		memberList.forEach(a -> log.info(a));

	}
	
	@Test
	public void testGetOne() throws Exception{
		
		Admin selectOne = dao.getOne("mw");
		
		log.info(selectOne);

	}
	
	@Test
	public void testUpdate() {
		
		Admin selectOne = dao.getOne("mw");
		
		selectOne.setApw("mw");
		
		dao.update(selectOne);
		
		log.info(selectOne);
		
	}
	
}
