package kr.or.ddit.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.or.ddit.dto.MemberVO;

@ControllerAdvice
public class ExceptionControllerAdvicer {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ExceptionControllerAdvicer.class);
	
	@ExceptionHandler(SQLException.class)
	public String sqlExceptionPage(Exception e,Model model,HttpSession session){
		String url="error/sqlException";
		
		logger.info(e.toString());
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		model.addAttribute("exception",e);
		model.addAttribute("user",loginUser!=null ? loginUser.getName()+"님":"");
		
		
		return url;		
	}
}






