package org.keroro.time.dao;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;

public class TimeDAO extends BaseDAO {

	private static final String NAMESPACE = "org.keroro.time.dao.TimeMapper";
	
	public String getTime() {
		try(SqlSession session = getSession()){
			return session.selectOne(NAMESPACE + ".getTime");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
