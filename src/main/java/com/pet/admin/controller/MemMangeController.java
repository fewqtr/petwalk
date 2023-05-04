package com.pet.admin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemMangeController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/memManage")
	public String home(Locale locale, Model model) {
		model.addAttribute("msg", "memManage");
		return "home";
	}
	
}