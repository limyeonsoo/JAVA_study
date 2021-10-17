package kr.or.connect.mvcExam.dto;

public class User {       //property가 모두 private이므로 Spring이 사용할 수 있게 getter setter 필요
	private String name;
	private String email;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {     //dto 에 있는 내용을 보기 위한 메소드
		return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
	}
}
