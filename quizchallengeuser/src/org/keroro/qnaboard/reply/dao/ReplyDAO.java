package org.keroro.qnaboard.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.MyBatisMaker;
import org.keroro.qnaboard.domain.QnaBoard;
import org.keroro.qnaboard.reply.domain.Reply;


public class ReplyDAO {
	
	private static final String NAMESPACE = "org.keroro.qnaboard.reply.dao.ReplyMapper";

	Reply reply = new Reply();
	
	public List<Reply> getAll(Long bno)throws Exception {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getAll", bno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insertReply(Reply reply) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insert", reply);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteReply(Long rno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".delete", rno);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
