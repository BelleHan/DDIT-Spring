package com.spring.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.command.LoginCommand;

@Controller
public class CommonController {
	
	private String id;
	private String pwd;

   // 어댑터는 어지간하면 jsp를 찾고 매핑해주는데, 이때 response로 받으면 그걸 막아줌(자동 매핑X)
   @RequestMapping(value = "/common/login", method = RequestMethod.GET)
   public void loginForm() throws Exception {
//     String url = "common/login";
//     return null;
// 	  response.getWriter().println("zzzzz");

   }

   @RequestMapping(value = "/common/login", method = RequestMethod.POST)
   public String loginPost(LoginCommand logReq, String id, @RequestParam(name="pwd",defaultValue="ttt")String pwddd, HttpSession session, HttpServletResponse response) throws Exception {

      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      
      System.out.println(logReq);

//      if (logReq.getId().equals("mimi") && logReq.getPwd().equals("mimi")) {
      if (id.equals("mimi") && pwd.equals("mimi")) {
         session.setAttribute("loginUser", id);
         out.println("<script>alert('로그인성공');</script>");

      } else {

         out.println("<script>alert('로그인실패');</script>");
      }

      return null;
   }

}