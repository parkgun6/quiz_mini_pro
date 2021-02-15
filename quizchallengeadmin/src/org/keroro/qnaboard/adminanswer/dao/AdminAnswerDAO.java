package org.keroro.qnaboard.adminanswer.dao;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.MyBatisMaker;
import org.keroro.qnaboard.adminanswer.domain.AdminAnswer;
import org.keroro.qnaboard.domain.QnaBoard;

import lombok.extern.log4j.Log4j;

@Log4j
public class AdminAnswerDAO {

	private static final String NAMESPACE = "org.keroro.qnaboard.adminanswer.dao.AdminAnswerMapper";

	AdminAnswer adminAnswer = new AdminAnswer();

	public AdminAnswer getAnswer(Long ano) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getAnswer", ano);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertAnswerThenUpdate(AdminAnswer answer) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession(false)) {

			session.insert(NAMESPACE + ".insertAnswer", answer);

			session.update(NAMESPACE + ".updateState", answer.getBno());

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//
//	public void updateState(QnaBoard board) throws Exception {
//
//		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
//
//			session.update(NAMESPACE + ".updateState", board);
//
//			session.commit();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
