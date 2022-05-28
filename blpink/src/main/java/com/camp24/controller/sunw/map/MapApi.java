package com.camp24.controller.sunw.map;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp24.controller.CmpInter;
/**
 * 네이버 지도 api 페이지를 보기위한 클래스
 * @author	정선우
 *
 */
public class MapApi implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/map/mapApi";
		return view;
	}

}
