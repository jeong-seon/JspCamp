package com.camp24.controller.sunw.reviewboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
import com.camp24.dao.sunw.BoardDao;
import com.camp24.vo.BoardVO;
/**
 * 이 클래스는 게시글 상세보기 요청을 처리하는 클래스
 * @author	전은석
 * @since	2022.05.24
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	담당자 : 전은석
 * 								내  용 :
 * 										클래스제작
 *
 */
public class BoardDetail implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/boardDetail";
		
		String spage = req.getParameter("nowPage");
		String sno = req.getParameter("bno");
		int bno = 0;
		if(sno != null) {
			bno = Integer.parseInt(sno);
		}
		
		BoardDao bDao = new BoardDao();
		BoardVO bVO = bDao.getBoardDetail(bno);
		
		System.out.println("********** cont list.size() : " + bVO.getList().size());
		
		req.setAttribute("DATA", bVO);
		req.setAttribute("LIST", bVO.getList());
		
		return view;
	}

}
