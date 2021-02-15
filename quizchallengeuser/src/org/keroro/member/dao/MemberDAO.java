package org.keroro.member.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.keroro.common.dao.BaseDAO;
import org.keroro.common.dao.MyBatisMaker;
import org.keroro.common.util.PageInfo;
import org.keroro.member.domain.Member;
import org.keroro.member.dto.MemberDTO;
import org.keroro.member.dto.ScoreDTO;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.domain.Question;
import org.keroro.question.dto.QhistoryDTO;

import lombok.extern.log4j.Log4j;
@Log4j
public class MemberDAO extends BaseDAO {

	final String NAMESPACE = "org.keroro.member.dao.MemberMapper";
	// 멤버 찾기 mid, mpw 필요
	public Member selectMember(String mid, String mpw) { 
		Member member = new Member();
		member.setMid(mid);
		member.setMpw(mpw);
		
		try (SqlSession session = this.getSession()) {
			member = session.selectOne(NAMESPACE + ".selectMember", member);
			log.info(member.getMid());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}

	//멤버의 등급별 푼 문제수 확인 mid,grade 필요
	public int selectMemberQhistoryCount(Member member) {
		HashMap<String, String> map = new HashMap<>();
		int count = -1;
		int grade = (int)member.getGrade();
		map.put("mid", member.getMid());
		
		for(int i=0; i<3; i++) {
			map.put("dif"+i, ""+(grade+i));
		}
		try (SqlSession session = this.getSession()) {
			
			count = session.selectOne(NAMESPACE+".selectMemberQhistoryCount", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	//멤버의 등급별 맞춘 문제수 확인 mid,grade 필요
	public int selectMemberCorrectCount(Member member) {
		HashMap<String, String> map = new HashMap<>();
		int correct = -1;
		int grade = (int)member.getGrade();
		map.put("mid", member.getMid());
		
		for(int i=0; i<3; i++) {
			map.put("dif"+i, ""+(grade+i));
		}
		try (SqlSession session = this.getSession()) {
			
			correct = session.selectOne(NAMESPACE+".selectMemberCorrectCount",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return correct;
	}
	//멤버의 등급별 푼 문제수를 날짜별로 확인 mid,grade,regDate 필요
	public int selectMemberQhistoryCountReg(Member member, int minus) {
		HashMap<String, String> map = new HashMap<>();
		int count = -1;
		int grade = (int)member.getGrade();
		map.put("mid", member.getMid());
		map.put("regDateMinus", ""+minus);
		for(int i=0; i<3; i++) {
			map.put("dif"+i, ""+(grade+i));
		}
		try (SqlSession session = this.getSession()) {
			
			count = session.selectOne(NAMESPACE+".selectMemberQhistoryCountReg", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	//멤버의 등급별 맞춘 문제수를 날짜별로 확인 mid,grade,regDate 필요
	public int selectMemberCorrectCountReg(Member member, int minus) {	
		HashMap<String, String> map = new HashMap<>();
		int correct = -1;
		int grade = (int)member.getGrade();
		map.put("mid", member.getMid());
		map.put("regDateMinus", ""+minus);
		for(int i=0; i<3; i++) {
			map.put("dif"+i, ""+(grade+i));
		}
		try (SqlSession session = this.getSession()) {
			
			correct = session.selectOne(NAMESPACE+".selectMemberCorrectCountReg",map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return correct;
	}
	
	//============================== 통계 ==================================//
	//순위 리스트
		public List<MemberDTO> getPercentPagedList(PageInfo pageInfo) throws Exception {
			
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
				
				return session.selectList(NAMESPACE + ".getPercentPagedList", pageInfo);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return null;

		}
		
		public List<MemberDTO> getPercentList() throws Exception {		
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {			
				return session.selectList(NAMESPACE + ".getPercentList");		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//순위 검색
		public MemberDTO getPercentOne(String mid) throws Exception {
			
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
				
				return session.selectOne(NAMESPACE + ".getPercentOne", mid);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return null;

		}
		
		// 난이도 별 점수 가져오기
		public List<ScoreDTO> getScoreList(String mid) throws Exception {		
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {			
				return session.selectList(NAMESPACE + ".getScoreList", mid);		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		// 총원
		public int getTotal() {
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {			
				return session.selectOne(NAMESPACE + ".getTotal");		
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		//멤버가 푼 문제들 모두 가져오는것 mid 필요
		public List<QhistoryDTO> selectMemberQhistoryAll(String mid) {
			List<QhistoryDTO> list = new ArrayList<>();

			try (SqlSession session = this.getSession()) {
				list = session.selectList(NAMESPACE + ".selectMemberQhistoryAll", mid);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public Map<String, Double[]> getChartData(String mid) {
			// 
			Map<String, Double[]> resultMap = new HashMap<>();
			
			final int ENDNUMBER=7;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			int time =Integer.parseInt(sdf.format(date.getTime()));
			List<QhistoryDTO> list = selectMemberQhistoryAll(mid);
			Iterator iterator = list.iterator();
			int[] arr1 = new int[7];
			int[] arr2 = new int[7];
			Double[] dateArr = new Double[7];
			
			for(int i = 0; i< 7; i++) {
				arr1[i]=0;
				arr2[i]=0;
				dateArr[i] = (double)(time-i);
			}
			int count =0;
	
			
			while(iterator.hasNext()) {
				QhistoryDTO temp = (QhistoryDTO) iterator.next();
				int timeTemp = Integer.parseInt(temp.getRegDate().toString().replaceAll("-", ""));
				int dif = temp.getDifficulty();
				if(time>timeTemp) {
					if(time+28<timeTemp) {
						count++;
					}else {
						count+=time-timeTemp;
					}
					time=timeTemp;
					if(count>=ENDNUMBER) {break;}
				}
				arr1[count]+=dif;
				// 날짜 넣기
				dateArr[count] = (double)timeTemp;
				
				if(temp.getCheckAnswer().toLowerCase().equals("o")) {
					arr2[count] +=dif;  
				}
				
				
			}
			// 푼 문제 점수 합
			System.out.println(Arrays.toString(arr1));
			// 풀어서 맞춘 점수의 합
			System.out.println(Arrays.toString(arr2));
			
			Double [] result = new Double[7];
			
			for( int i =0; i < 7; ++i) {
				if(0 == arr1[i]) {
					 result[i] = 0.0;
					 continue;
				}
				
				 result[i]= arr2[i] / (double)arr1[i];
			}
			resultMap.put("avg", result);
			resultMap.put("date", dateArr);
			
			
			return resultMap;
		}
		
		public void signup(Member member) {
			try (SqlSession session = this.getSession()) {
				session.insert(NAMESPACE + ".signup", member);
				session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//=====================AUTO LOGIN================''
		// 자동로그인 원할 시 세션ID & 유효시간 입력
		public void keepLogin(Map map) throws Exception {		
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
				
				session.update(NAMESPACE + ".keepLogin", map);
				
				session.commit();
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}

		}	
		
		// 자동로그인 체크 & 유효시간 체크
		public Member checkSessionKey(String sessionKey) throws Exception {		
			try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
				
				return session.selectOne(NAMESPACE + ".checkSessionKey", sessionKey);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}			
			return null;
		}
}
