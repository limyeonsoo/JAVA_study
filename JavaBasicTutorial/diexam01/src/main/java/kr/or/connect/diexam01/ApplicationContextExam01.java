package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("초기화 완료!!");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		if(userBean == userBean2)     // 싱글턴 패턴이기 때문에 하나 만든 bean을 이용한다.
			System.out.println("같은 인스턴스입니다.");
	}
}
