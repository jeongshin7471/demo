package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String loginForm(@RequestParam(value = "logout", required = false)String logout, 
							@RequestParam(value = "needLogin", required = false)String needLogin, 
							Model model) {
		
		if(logout != null) {
			model.addAttribute("msg", "로그아웃 되었어요...");
		}
		if(needLogin != null) {
			model.addAttribute("msg", "Member 전용 페이지 입니다.");
		}
		
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
