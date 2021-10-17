package kr.or.connect.mvcExam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.mvcExam.dto.User;

@Controller
public class UserController {
	@RequestMapping(path="/userForm", method=RequestMethod.GET)  // /userform으로 부터 GET방식으로 얻어옴.
	public String userForm() {
		return "userForm";
	}
	
	@RequestMapping(path="/regist", method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) {           //User DTO 사용  @ModelAttribute 를 이용하면 원하는  DTO에 정보 저장 가능.

		System.out.println("사용자가 입력한 user 정보입니다. 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		return "regist";
	}
}