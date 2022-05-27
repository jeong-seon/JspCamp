package com.camp24.controller.kimhe.board;
/**
 * 
 * @author	김희승
 * @since	2022.05.26
 * 
 * 
 */

import java.util.*;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.*;

public class FaqList implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/faqList";	
		return view;
	}

}