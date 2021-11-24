package com.spring.fileUpload.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring.fileUpload.command.FileUploadCommand;

@Controller
public class FileUploadController {

	@RequestMapping("/fileUploadForm")
	public void fileUploadForm() {}
	
	@RequestMapping(value = "/multipartFile", method = RequestMethod.POST,	
				    produces = "text/plain;charset=utf-8")
	public String uploadByMultipartFile(@RequestParam(value = "title", defaultValue = "제목없음") String title,
										@RequestParam("file") MultipartFile multi, 
										HttpServletRequest request, HttpServletResponse response,
										Model model) throws Exception {
		
		String url="fileUploaded";
		
		/* 파일유무확인 */
		if (multi.isEmpty()) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('파일이 없습니다.!');</script>");
			out.println("<script>history.go(-1);</script>");
			return null;
		}
		/* 용량제한 5MB */
		if (multi.getSize() > 1024 * 1024 * 5) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('용량초과 입니다!');</script>");
			out.println("<script>history.go(-1);</script>");
			return null;
		}
		
		/* 파일저장폴더설정 */
		String uploadPath = request.getSession().getServletContext().
				getRealPath("resources/upload");

		/* 파일명 중복방지 */
		String fileName = UUID.randomUUID().toString().replace("-", "") + "$$" 
				+ multi.getOriginalFilename();

		/* 파일 경로확인 및 생성 */
		File file = new File(uploadPath, fileName);

		if (!file.exists()) {
			file.mkdirs();
		}

		/* 파일저장 */
		multi.transferTo(file);
		

		model.addAttribute("title", title);
		model.addAttribute("originalFileName", multi.getOriginalFilename());
		model.addAttribute("uploadedFileName", file.getName());
		model.addAttribute("uploadPath", file.getAbsolutePath());
		
		
		return url;
	}
	
	@RequestMapping(value = "/multipartHttpServletRequest", method = RequestMethod.POST,
				     produces = "text/plain;charset=utf-8")
	public String uploadByMultipartHttpServletRequest(MultipartHttpServletRequest request, 
													  HttpServletResponse response,
													  Model model) throws Exception {
		String title = request.getParameter("title");
		MultipartFile multi = request.getFile("file");	
		
		return uploadByMultipartFile(title,multi,request,response,model);		
	}
	
	@RequestMapping(value = "/commandObject", method = RequestMethod.POST)
	public String uploadByCommandObject(FileUploadCommand command, 
										HttpServletRequest request, 
										HttpServletResponse response,
										Model model) throws Exception {
		
		MultipartFile multi = command.getFile();
		String title = command.getTitle();
		
		return uploadByMultipartFile(title,multi,request,response,model);	
	}
}








