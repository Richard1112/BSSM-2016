package com.org.bssm.schedue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.org.bssm.controller.BaseController;

@Controller
@RequestMapping("/CycleTest")
public class CycleTestController extends BaseController {

	
	@RequestMapping(value = "/Test")
	public String test() {
		return "/showPerson";
	}
	
}
