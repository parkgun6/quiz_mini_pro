package org.keroro.question.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;
import org.keroro.common.util.PageInfo;
import org.keroro.common.util.PageMaker;
import org.keroro.question.dto.PageInfoDTO;
import org.keroro.question.dto.QhistoryDTO;

public class QhistoryDAO extends BaseDAO {

	private static final String NAMESPACE = "org.keroro.question.dao.QuestionMapper";

	// PageMaker pageMaker = new PageMaker(info, dao.getTotalOfMyHistory(mid));
	
	// List<QhistoryDTO> list = dao.getPageListOfMyHistory(mid, info);
	
	public List<QhistoryDTO> getPageListOfMyHistory(String mid, PageInfo info){
		PageInfoDTO dto = PageInfoDTO.builder().mid(mid).page(info.getPage()).perSheet(info.getPerSheet()).build(); 
		
		try (SqlSession session = getSession()){
			return session.selectList(NAMESPACE + ".getPageListOfMyHistory", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public int getTotalOfMyHistory(String mid) {
		try (SqlSession session = getSession()){
			return session.selectOne(NAMESPACE + ".getTotalOfMyHistory", mid);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	public QhistoryDTO getMyHistory(String mid, Long qno){
		QhistoryDTO dto =QhistoryDTO.builder().mid(mid).qno(qno).build();
		try (SqlSession session = getSession()){
			return session.selectOne(NAMESPACE + ".getMyHistory", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	
}
