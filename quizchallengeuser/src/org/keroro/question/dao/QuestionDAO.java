package org.keroro.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;
import org.keroro.common.util.PageInfo;
import org.keroro.member.domain.Member;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QuestionDTO;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAO extends BaseDAO {

	private static final String NAMESPACE = "org.keroro.question.dao.QuestionMapper";

	// random한 문제를 하나 가져온다. DTO에서 mid를 보고 중복되지 않게 가져온다.
	public Question getRandomQuestion(QuestionDTO dto) {
		try (SqlSession session = getSession()){
			return session.selectOne(NAMESPACE + ".getRandomQuestion", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	public Question getOneQuestion(Long qno) {		
		try (SqlSession session = getSession()) {
			return session.selectOne(NAMESPACE + ".getOneQuestion", qno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public int getTotalForDTO(QuestionDTO dto) {
		
		log.debug("question get total");		
		
		try (	SqlSession session = getSession()){
			return session.selectOne(NAMESPACE + ".getTotalForDTO", dto);	
		} catch(Exception e) {		
			e.printStackTrace();		
		} 
		
		return 0;
	}
	public void insertQhistory(Qhistory qhis) {
		try(SqlSession session = getSession()){
			session.insert(NAMESPACE+".insertQhistory",qhis);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
