package kr.or.ddit.command;

import kr.or.ddit.dto.NoticeVO;

public class NoticeModifyCommand extends NoticeRegistCommand{
	
	String nno;

	public String getNno() {
		return nno;
	}
	
	public void setNno(String nno) {
		this.nno = nno;
	}
	
	@Override
	public NoticeVO toNoticeVO() {
		NoticeVO notice = super.toNoticeVO();;
		notice.setNno(Integer.parseInt(nno));
		
		return notice;
	}
	
}
