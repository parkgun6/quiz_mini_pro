package org.keroro.common.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.Getter;

@Getter
public enum MyBatisMaker {
	//싱글턴 방법
	//enum: 정해진 숫자의 객체를 만들 때 사용한다. - 외부에서 객체를 못 만든다.
	//-> 외부에서 호출하는 생성자를 못 만든다.(public) //private으로 enum의 의존성 주입 설정
	//enum에서 가장 중요한 것 - (?)
	//과거에는 static을 썼으나 Thread 세이프 문제점이 있어서 enum을 사용한다.
	INSTANCE;
	
	private SqlSessionFactory factory;
	
	MyBatisMaker(){
		try {
			
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}

}
