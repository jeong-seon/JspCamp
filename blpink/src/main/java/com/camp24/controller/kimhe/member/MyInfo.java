package com.camp24.controller.kimhe.member;

/**
 * 
 * @author 김희승
 * @since 2022-05-25
 */

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp24.controller.*;
import com.camp24.dao.kimhe.MemberDao;
import com.camp24.vo.*;

public class MyInfo implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 검사
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");

		String view = "/member/memberInfo";
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "/camp24/member/login.cmp";
			return view;
		}
		
		// 로그인 되어있는 경우이므로 데이터베이스에서 데이터를 조회한다.
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getIdInfo(sid);
		
		// 꺼낸 데이터 요청 객체에 기억시키고
		req.setAttribute("DATA", mVO);
		
		// 뷰 부르고...
		return view;
	}

}