package com.example.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@RequestMapping("/index")
	public String indexMain(){
		return "redirect:/login";
	}

	@RequestMapping("/login")
	public String loginMain() {
		return "login";
	}

	@RequestMapping("/admin")
	@ResponseBody
	public String admin() {
		return "admin page";
	}

	@RequestMapping("/client")
	@ResponseBody
	public String client() {
		return "client page";
	}
}
