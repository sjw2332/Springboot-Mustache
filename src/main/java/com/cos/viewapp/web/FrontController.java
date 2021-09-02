package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//RestController (데이터를 리턴한다)
//Controller (파일을 리턴한다) -- 여기선 mustache를 리턴할 것이므로 controller 사용

@Controller
public class FrontController {
	//여러명이 동시 접속할 시 전역변수가 있으면 충돌할 수 있으므로 여긴 쓰지 말것.
	
	
	// http://localhost:8080/home
	// Dispatcher servlet  이 /home 파싱
	// IoC 컨테이너에 @Controller 와 @RestController 만 찾음 
	// 메서드를 호출한다
	
	@GetMapping("/home")
	public String home(Model model){  //request == model
		// ViewResolver 클래스
		// src/main/resources/templates (prefix) 로 경로 설정
		// .mustache(suffix)
		
		String name = "Eshley";
		model.addAttribute("name", name);
		
		List<Board> boards = new ArrayList<>();
		boards.add(new Board(1,"제목1"));
		boards.add(new Board(2,"제목2"));
		
		model.addAttribute("boards",boards);
		
		
		return "home";  //RequestDispatcher가 자동 작동
	}
}
