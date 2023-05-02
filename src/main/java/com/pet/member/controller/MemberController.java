package com.pet.member.controller;

import java.util.HashMap;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pet.member.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired MemberService service;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/join.go")
	   public String joinForm() {
		logger.info("시발 회원가입");
	      return "joinForm";      
	   }
	   
	   @RequestMapping(value="/overlay.ajax")
	   @ResponseBody
	   public HashMap<String, Object> overlay(@RequestParam String userID){
		   logger.info("overlay : "+userID);
	      return service.overlay(userID);      
	   }
	   
	   @RequestMapping(value="/join.ajax")
	   @ResponseBody
	   public HashMap<String, Object> join(@RequestParam HashMap<String, String> params){
		   logger.info("params: {}"+params);
		return service.join(params);		   
	   }
	   
	   @RequestMapping(value="/login.go")
	   public String loginForm() {
		logger.info("시발 로그인");
	      return "loginForm";      
	   }
	   
	   @RequestMapping(value="/login.ajax")
	   @ResponseBody 
	   public HashMap<String, Object> login(@RequestParam String userID, 
			   @RequestParam String userPW, HttpSession session){
		   
		   logger.info(userID+"/"+userPW);
		   int success = service.login(userID,userPW);
		   logger.info("login success : "+success);
		   
		   if(success == 1) {
			   session.setAttribute("loginId", userID);
		   }
		   
		   HashMap<String, Object> map = new HashMap<String, Object>();
		   map.put("success", success);
		   
		   return map;
	   }
	
}