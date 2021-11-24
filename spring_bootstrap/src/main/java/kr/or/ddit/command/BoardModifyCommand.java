package kr.or.ddit.command;

import kr.or.ddit.dto.BoardVO;

public class BoardModifyCommand extends BoardRegistCommand{
	
	private int bno;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	@Override
	public BoardVO toBoardVO() {
		BoardVO board = super.toBoardVO();
		board.setBno(bno);
		
		return board;
	}

	
	
}
