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
import com.camp24.dao.kimhe.*;

public class LoginProc implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("isRedirect", true);
		String view = "/camp24/main.cmp";
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 상태...
			return view;
		}
		
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");

		MemberDao mDao = new MemberDao();
		int cnt = mDao.getLogin(id, pw);

		if(cnt == 1) {

			req.getSession().setAttribute("SID", id);
		} else {

			view = "/camp24/member/login.cmp";
		}
		
		return view;
	}

}