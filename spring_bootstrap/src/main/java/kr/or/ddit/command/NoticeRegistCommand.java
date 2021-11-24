package kr.or.ddit.command;

import java.util.Date;

import kr.or.ddit.dto.NoticeVO;

public class NoticeRegistCommand {
	private String title;
	private String writer;
	private String content;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public NoticeVO toNoticeVO() {
		NoticeVO notice = new NoticeVO();
		notice.setContent(this.content);
		notice.setTitle(this.title);
		notice.setWriter(this.writer);
		notice.setRegDate(new Date());
		
		return notice;
	}
}
