package org.keroro.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;
import org.keroro.common.util.PageInfo;
import org.keroro.usermember.domain.Member;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;
import org.keroro.question.dto.QuestionDTO;
import org.keroro.question.util.QuestionExcelLoader;

import lombok.extern.log4j.Log4j;

@Log4j
public class QuestionDAO extends BaseDAO {

	private static final String NAMESPACE = "org.keroro.question.dao.QuestionMapper";

	
	public void modifyQuestion(Question q) {
		try (	SqlSession session = getSession()){
			 session.update(NAMESPACE + ".modifyQuestion", q);	
			 session.commit();
		} catch(Exception e) {		
			e.printStackTrace();		
		} 
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
	
	// page별 한쪽의 Question 리스트를 반환한다.
	public List<Question> getPagedListOfQuestion(PageInfo pageInfo) {
		List<Question> result = null;

		try (SqlSession session = getSession()) {
			result = session.selectList(NAMESPACE + ".getPagedListOfQuestion", pageInfo);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// dto를 넣으면 difficulty를 기반으로, mid가 푼 문제들을 qhistory에서 찾는다.
	// 그 문제들을 안푼 문제들의 개수를 반환한다.
	public int getTotalOfQuestion(QuestionDTO dto) {

		try (SqlSession session = getSession()) {
			return session.selectOne(NAMESPACE + ".getTotalOfQuestion", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 모든 토탈 수를 가져온다.
	public int getTotalOfQuestion() {

		try (SqlSession session = getSession()) {
			return session.selectOne(NAMESPACE + ".getTotalOfQuestionAll");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// question insert
	public void insertQuestion(Question question) {
		try (SqlSession session = getSession()) {
			session.insert(NAMESPACE + ".insertQuestion", question);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// question insert by Excel
	public void insertQuestionByExcel(String fileName) {
		QuestionExcelLoader loader = new QuestionExcelLoader(fileName);

		List<Question> list = loader.load();

		for (Question q : list) {
			insertQuestion(q);
		}
	}

	// =============================QHISTORY=========================//
	// =============================QHISTORY=========================//
	// =============================QHISTORY=========================//

	// qhistory 페이징 조회
	public List<Qhistory> getPagedListOfQhistory(PageInfo pageInfo) {
		List<Qhistory> result = null;

		try (SqlSession session = getSession()) {
			result = session.selectList(NAMESPACE + ".getPagedListOfQhistory", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 모든 토탈 수를 가져온다.
	public int getTotalOfQhistory() {
		try (SqlSession session = getSession()) {
			return session.selectOne(NAMESPACE + ".getTotalOfQhistoryAll");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// question insert
	public void insertQhistory(Qhistory history) {
		try (SqlSession session = getSession()) {
			session.insert(NAMESPACE + ".insertQhistory", history);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// =============================QHISTORY DTO=========================//
	// =============================QHISTORY DTO=========================//
	// =============================QHISTORY DTO=========================//
	public List<QhistoryDTO> getAllListOfQhistoryDTO() {
		List<QhistoryDTO> result = null;
		
		try (SqlSession session = getSession()) {
			result = session.selectList(NAMESPACE + ".getAllListOfQhistoryDTO");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	// qhistory 페이징 조회
	public List<QhistoryDTO> getPagedListOfQhistoryDTO(PageInfo pageInfo) {
		List<QhistoryDTO> result = null;

		try (SqlSession session = getSession()) {
			result = session.selectList(NAMESPACE + ".getPagedListOfQhistoryDTO", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
