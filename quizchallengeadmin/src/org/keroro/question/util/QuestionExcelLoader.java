package org.keroro.question.util;

import java.util.ArrayList;
import java.util.List;

import org.keroro.common.util.ExcelReader;
import org.keroro.question.domain.Question;

public class QuestionExcelLoader {
	private ExcelReader reader;
	
	public QuestionExcelLoader(ExcelReader reader) {
		this.reader = reader;
	}
	
	public QuestionExcelLoader(String fileName) {
		this.reader = new ExcelReader(fileName);
	}
	
	public List<Question> load(){
		int totalCount = reader.getLastRowNum();		
		List<Question> result = new ArrayList<Question>();
		// 0번째 줄은 설명
		for(int i = 1; i < totalCount; ++i) {
			int j = 0;

			String aid = reader.getCellString(i, j++);
			String quiz = reader.getCellString(i, j++);
			String answer = reader.getCellString(i, j++);			
			int diffy = reader.getCellInt(i, j++);
			
			Question q = Question.builder()
					.aid(aid).quiz(quiz).answer(answer).difficulty(diffy)
					.build();
			
			result.add(q);
		}
		
		return result;
	}
}
