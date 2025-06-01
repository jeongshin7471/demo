package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	/*
	@PostMapping("/login")
	public String login(@RequestParam("username")String username,
						@RequestParam("password")String password,
						RedirectAttributes rttr, HttpSession session) {
		
		long result = loginService.login(username, password);
		if(result == 1) {
			session.setAttribute("username", username);
			rttr.addFlashAttribute("msg", "로그인 성공");
			return "success";
		}else {
			rttr.addFlashAttribute("msg", "로그인 실패");
			return "fail";
		}
	}
	*/
}
