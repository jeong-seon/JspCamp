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
import com.camp24.dao.*;
import com.camp24.dao.kimhe.MemberDao;
import com.camp24.vo.*;

public class MemberInfo implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/memberInfo";
		String sno = req.getParameter("mno");
		int mno = Integer.parseInt(sno);
		
		// 데이터 조회
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getMnoInfo(mno);
		
		// 데이터 심고
		req.setAttribute("DATA", mVO);
		
		return view;
	}

}