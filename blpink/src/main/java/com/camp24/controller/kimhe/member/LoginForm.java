package com.camp24.controller.kimhe.member;
/**
 * 
 * @author 김희승
 * @since 2022-05-25
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.*;

public class LoginForm implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/login";
		if(req.getSession().getAttribute("SID") != null) {
			// 이미 로그인 한 경우
			req.setAttribute("isRedirect", true);
			view = "/camp24/main.cmp";
		}
		
		return view;
	}

}