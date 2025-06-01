package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.CustomUserDetails;

@Controller
@RequestMapping("/members")
public class UserController {

	@PreAuthorize("hasRole('MEMBER')")
	@GetMapping("/mypage")
	public String memberMain(@AuthenticationPrincipal CustomUserDetails customUserDetails, 
							Model model) {
		System.out.println("mypage........");
		
		//@AuthenticationPrincipal 사용
		model.addAttribute("user", customUserDetails);
		//model.addAttribute("username3", customUserDetails.getUsername());
		//model.addAttribute("name3", customUserDetails.getName());
		//model.addAttribute("role", customUserDetails.getRole());
		
		return "/members/mypage";
	}
}
