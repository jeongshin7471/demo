package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.config.CustomUserDetails;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class MyController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	
	@GetMapping("/regist")
	public String registForm() {
		return "registForm";
	}
	
	@PostMapping("/registProc")
	public String regist(UserDto userDto, RedirectAttributes rttr) {
		System.out.println(userDto);
		User result = userService.registUser(userDto);
		
		if(result == null) {
			rttr.addFlashAttribute("msg", "등록실패");
			return "redirect:/fail";
		}
		
		rttr.addFlashAttribute("msg", "회원가입 성공...");
		return "redirect:/login";
	}
	
	@GetMapping("/success")
	public String success(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CustomUserDetails userDetails = (CustomUserDetails)authentication.getPrincipal();
		model.addAttribute("user", userDetails);
		model.addAttribute("msg", "성공");
		return "success";
	}
}
