package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Pagination;
import dao.BoardDao;
import dto.BoardDto;

public class BoarServiceList implements BoardService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		
		// 페이징처리
		String curPage = request.getParameter("curPage"); //현재페이지
		if(curPage == null) curPage = "1"; 

		Pagination pn =new Pagination(Integer.parseInt(curPage), dao.totalCount()); 
				  
		List<BoardDto> boardList = dao.boardList(curPage);
		request.setAttribute("startPage",pn.getStartPage());
		request.setAttribute("endPage", pn.getEndPage());
		request.setAttribute("pageCnt", pn.getPageCnt());

		request.setAttribute("boardList", boardList);
	}
}
