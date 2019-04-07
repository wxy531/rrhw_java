package com.example.demo;

import org.springframework.web.bind.annotation.*;
@RestController
public class hello {
	@RequestMapping("/hello")
	public String doReq() {
		return "helloworld";
	}
}
