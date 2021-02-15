package org.keroro.common.dao;

import org.apache.ibatis.session.SqlSession;

public abstract class BaseDAO {
	   
	   protected SqlSession getSession() {
	      return MyBatisMaker.INSTANCE.getFactory().openSession();
	   }
	   
	   protected void close(SqlSession session) throws Exception {
	      if (session != null) {
	         try {
	            session.close();
	         } catch (Exception e) {
	            throw e;
	         }
	      }
	   }
	   
	   
	}