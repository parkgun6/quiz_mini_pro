package org.keroro.member.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.keroro.member.domain.Member;
import org.keroro.member.dto.MemberDTO;
import org.keroro.member.dto.ScoreDTO;
import org.keroro.question.domain.Qhistory;
import org.keroro.question.dto.QhistoryDTO;

import lombok.extern.log4j.Log4j;

@Log4j
public class MemberDAOTests {

	MemberDAO dao = new MemberDAO();

	@Test
	public void selectMemberTests() {// mid, mpw 필요
		String mid = "hj";
		String mpw = "hj";
		Member member = dao.selectMember(mid, mpw);
		System.out.println(member);
	}


	@Test
	public void selectMemberQhistoryCountTests() {// grade, mid 필요
		int count = 0;
		Member member = new Member();
		member.setGrade(1);
		member.setMid("hj");
		count = dao.selectMemberQhistoryCount(member);
		System.out.println(count);
	}

	@Test
	public void selectMemberQhistoryCountRegTests() {// grade,mid,regdate 필요
		Member member = new Member();
		member.setGrade(3);
		member.setMid("hj");
		int count = dao.selectMemberQhistoryCountReg(member, -1);
		System.out.println("지정한 시간 이전의 횟수: " + count);
	}

	@Test
	public void selectMemberCorrectCountTests() {// grade, mid 필요
		int correct = 0;
		Member member = new Member();
		member.setGrade(1);
		member.setMid("hj");
		correct = dao.selectMemberQhistoryCount(member);
		System.out.println(correct);
	}

	@Test
	public void selectMemberCorrectCountRegTests() {// grade,mid,regdate 필요
		Member member = new Member();
		member.setGrade(3);
		member.setMid("hj");
		int count = dao.selectMemberCorrectCountReg(member, 0);
		System.out.println("지정한 시간 이전의 횟수: " + count);
	}

	@Test
	public void timeTests() {

		Map<String, String> map = new HashMap<>();
		Member member = new Member();
		member.setGrade(3);
		member.setMid("hj");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 7; j++) {
				map.put("CountGrade" + (i + 1) + "day-" + j, "" + dao.selectMemberQhistoryCountReg(member, +j - 1));
				map.put("CorrectGrade" + (i + 1) + "day-" + j, "" + dao.selectMemberCorrectCountReg(member, +j - 1));
			}
		}
		System.out.println(map.toString());
		System.out.println(map.get("CountGrade3day-1"));
	}
	
	@Test
	public void testGetScoreList() {
		try {
			List<ScoreDTO> list = dao.getScoreList("mingyu");
			list.forEach(s->log.info(s.getCorrect()) );
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPercentRank() {
		try {
			MemberDTO dto = dao.getPercentOne("mingyu");
			log.info( dto.getPerRank() );
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		try {
			List<ScoreDTO> list = dao.getScoreList("mingyu");
			
			for(int i =0; i < list.size(); ++i) {
				log.info(list.get(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Test
	public void selectMemberRegCount() {
		final int ENDNUMBER=7;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		int time =Integer.parseInt(sdf.format(date.getTime()));
		List<QhistoryDTO> list = dao.selectMemberQhistoryAll("hj");
		Iterator iterator = list.iterator();
		int[] arr1 = new int[7];
		int[] arr2 = new int[7];
		for(int i = 0; i< 7; i++) {
			arr1[i]=0;
			arr2[i]=0;
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
			if(temp.getCheckAnswer().toLowerCase().equals("o")) {
				arr2[count] +=dif;  
			}
		}
		// 푼 문제 점수 합
		System.out.println(Arrays.toString(arr1));
		// 풀어서 맞춘 점수의 합
		System.out.println(Arrays.toString(arr2));
		
		
	}

	
	@Test
	public void testGetChartData() {
		Map<String, Double[]> resultMap = dao.getChartData("hj");
		
		Double[] date = resultMap.get("date");
		Double[] avg = resultMap.get("avg");

		for(int i = 0; i < 7; ++i) {
			log.info("DATE : " + date[i] + ", AVG : " + avg[i]); 
		}

	}
	
	@Test
	public void testInsert() {
		Member member = Member.builder().mid("testID").mpw("1234").mname("testName").build();
		dao.signup(member);
		
		
	}
}
