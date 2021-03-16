package com.example.demo.servlet;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin
public class control {
@GetMapping(value = "/" )
	public String page() {
		return "home";
	}
}
