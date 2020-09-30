package cn.bcsoft.easycodedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: idea-workspace
 * Created by blackchen on 2020/9/9 16:17
 */
@Controller(value = "login")
@RequestMapping(value = "login")
public class LoginController {


	@ResponseBody
	@RequestMapping(value = "l2")
	public String login(){
		return "登陆";
	}
}
