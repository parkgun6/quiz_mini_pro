package org.keroro.qnaboard.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.MyBatisMaker;
import org.keroro.common.util.PageInfo;
import org.keroro.qnaboard.domain.QnaBoard;

import lombok.extern.log4j.Log4j;

@Log4j
public class QnaBoardDAO {
	private static final String NAMESPACE = "org.keroro.qnaboard.dao.QnABoardMapper";

	QnaBoard board = new QnaBoard();

	public int getTotal(int state,int category) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			//2021 02 09 박건 추가
			Map<String, Integer> map = new HashMap<>();
			map.put("state", state);
			map.put("category", category);
			
			return session.selectOne(NAMESPACE + ".getTotal", map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<QnaBoard> getList(PageInfo pageInfo) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getList", pageInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public QnaBoard getOne(Long bno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectOne(NAMESPACE + ".getOne", bno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertBoard(QnaBoard board) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insert", board);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBoard(Long bno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".delete", bno);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBoard(QnaBoard board) throws Exception {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			session.update(NAMESPACE + ".update", board);

			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void acceptAnswer(QnaBoard board) throws Exception {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			session.update(NAMESPACE + ".acceptAnswer", board);

			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
