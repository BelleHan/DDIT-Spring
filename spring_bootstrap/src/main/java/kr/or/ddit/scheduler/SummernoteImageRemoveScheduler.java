package kr.or.ddit.scheduler;

import java.io.File;
import java.util.List;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.BoardVO;
import kr.or.ddit.dto.NoticeVO;
import kr.or.ddit.dto.PdsVO;
import kr.or.ddit.service.BoardService;
import kr.or.ddit.service.NoticeService;
import kr.or.ddit.service.PdsService;

public class SummernoteImageRemoveScheduler {
	
	private NoticeService noticeService;
	private BoardService boardService;
	private PdsService pdsService;
	private String filePath;
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	public void setPdsService(PdsService pdsService) {
		this.pdsService = pdsService;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void fileRemove()throws Exception {	
		
		boolean existFile = false;
		
		File dir = new File(filePath);
		File[] files = dir.listFiles();
		
		for(File file : files) {
			//System.out.println(file.getName());
			
			SearchCriteria cri  = new SearchCriteria();
			cri.setSearchType("c");  // content
			cri.setKeyword(file.getName());
			
			List<NoticeVO> noticeList 
			= (List<NoticeVO>)noticeService.getNoticeList(cri).get("noticeList");
			List<BoardVO> boardList 
			= (List<BoardVO>)boardService.getBoardList(cri).get("boardList");
			List<PdsVO> pdsList
			=(List<PdsVO>)pdsService.getList(cri).get("pdsList");
			
			existFile = noticeList.size()>0 || boardList.size()>0 || pdsList.size()>0;
			           
			if(existFile) {
				System.out.println(file.getName()+" 은 사용하는 파일입니다.");
				continue;
			}else {
				System.out.println(file.getName()+" 은 사용하지 않습니다.");
				if(file.exists()) file.delete();
			}
		}
	}
}







