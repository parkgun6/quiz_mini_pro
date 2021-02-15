package org.keroro.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.keroro.admin.domain.Admin;
import org.keroro.common.dao.MyBatisMaker;
import org.keroro.common.util.PageInfo;

public class AdminDAO {
	
	private static final String NAMESPACE="org.keroro.admin.dao.AdminMapper";

	// 로그인 하기 위해서 DB 확인
	public Admin getAdmin(Admin admin) {
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectOne(NAMESPACE+".getAdmin", admin);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return null;
	}
	
	//관리자목록 조회
	public List<Admin> getList(PageInfo pageInfo) throws Exception {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectList(NAMESPACE+".getList", pageInfo);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		
		return null;

	}	
	
	//관리자정보 조회
	public Admin getOne(String aid) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectOne(NAMESPACE+".getOne", aid);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	//관리자정보 수정
	public void update(Admin admin) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			session.update(NAMESPACE+".update", admin);
			
			session.commit();
			
		}catch(Exception e) {
			//좋다라고 말할 수 없는 방법
			//원래는 던져야 하지만 초기에 어디에서 에러가 났는지 확인할 때
			//개발자들이 종종 사용한다.
			e.printStackTrace();
			
		}
	}

	//관리자 삭제
	public void delete(String aid) throws Exception {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			session.delete(NAMESPACE + ".delete", aid);
			
			session.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}	

	//페이지 total
	public int getTotal() {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectOne(NAMESPACE+".getTotal");
			
		}catch(Exception e) {
			//좋다라고 말할 수 없는 방법
			//원래는 던져야 하지만 초기에 어디에서 에러가 났는지 확인할 때
			//개발자들이 종종 사용한다.
			e.printStackTrace();
			
		}
		
		return 0;
		
	}
	
}
