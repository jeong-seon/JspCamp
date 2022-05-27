//package com.camp24.controller.sunw.board;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.camp24.controller.CmpInter;
//import com.camp24.dao.sunw.CampDao;
//import com.camp24.vo.CampVO;
//
///**
// * 캠핑장 정보 검색을 위한 클래스 제작
// * @author	정선우
// * @since	2022.05.26
// *
// */
//public class SearchBoardList implements CmpInter {
//
//	@Override
//	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String view = "/board/searchBoardList";
//		
//		String name = req.getParameter("name");
//		CampDao cDao = new CampDao();
//		ArrayList<CampVO> list = cDao.getCampList(name);
//		
//		req.setAttribute("LIST", list);
//		
//		return view;
//	}
//
//}
package com.camp24.controller.sunw.board;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.camp24.controller.CmpInter;
import com.camp24.vo.ApiVO;
/**
 * 이 클래스는 캠핑장정보 Api를 사용하여 캠핑장정보를 검색하는 클래스
 * @author	정선우
 * @since	2022.05.24
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	담당자 : 정선우
 * 								내	용 : 클래스 제작
 * 
 * 				2022.05.27	-	수정 및 검색기능 작업 완료
 *
 */
public class SearchBoardList implements CmpInter {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/board/searchBoardList";
        // parserw 를 만들어주는 Factory 객체 생성
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        String ServiceKey = "6pAoN9O3ycxlmS7o5f7MvnwrkdKT8wZaKFSsUoVgnrgvUk8%2FqN3dGhpsRYTTGJ63LFtj%2F0kBFwzjL%2Fy5pFa6xA%3D%3D";
        String numOfRows = "10";
        String pageNo = "1";
        String MobileOS = "ETC";
        String MobileApp = "appName";
        try {
        	// xml 문서를 파싱할 수 있는 dom parser 를 생성
        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        	// inputstream 객체의 형태로 파싱할 정보를 넘겨줌
        	// 파싱할 InputStream 생성
        	// 1. 웹서버를 제공하는 url 에 연결해서 데이터 가져오기
        	// 1) 접속할 url 정보 정의
        	StringBuffer pharm_url = new StringBuffer();
        	pharm_url.append("http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?ServiceKey=");
        	pharm_url.append(ServiceKey);
        	pharm_url.append("&numOfRows=" + numOfRows);
        	pharm_url.append("&pageNo=" + pageNo);
        	pharm_url.append("&MobileOS=" + MobileOS);
        	pharm_url.append("&MobileApp=" + MobileApp);
        	
        	
        	
        	// 2) 웹서버 접속
        	URL url = new URL(pharm_url.toString());
        	
        	// 3) 접속해서 response 되는 데이터를 읽어오기
        	// 읽어온 데이터를 저장
        	BufferedInputStream xmldata = new BufferedInputStream(url.openStream());
        	
        	// InputStream 객체의 형태로 파싱할 정보를 넘겨줌
        	Document document = dBuilder.parse(xmldata);
        	Element root = document.getDocumentElement();
        	NodeList list = root.getElementsByTagName("item");
        	
        	String input = req.getParameter("input");
        	
        	ArrayList<ApiVO> jlist = new ArrayList<ApiVO>();
        	
        	for(int i = 0; i < list.getLength(); i++) {
        		Node node = list.item(i);
        		
        		NodeList item_childlist = node.getChildNodes();
        		
        		ApiVO aVO = new ApiVO();
        		for (int j = 0; j < item_childlist.getLength(); j++) {
        			Node item_child = item_childlist.item(j);
        			String txt = item_child.getNodeName();
        			switch(txt) {
        			case "facltNm":
        				if(item_child.getTextContent().indexOf(input) == -1) {
        					aVO.setFacltNm("검색결과없음");
        				} else {
        					aVO.setFacltNm(item_child.getTextContent());
        				}
        				break;
        			case "addr1":
        				aVO.setAddr1(item_child.getTextContent());
        				break;
        			case "lctCl":
        				aVO.setLctCl(item_child.getTextContent());
        				break;
        			case "eqpmnLendCl":
        				aVO.setEqpmnLendCl(item_child.getTextContent());
        				break;
        			case "firstImageUrl":
        				aVO.setFirstImageUrl(item_child.getTextContent());
        				break;
        			case "tel":
        				aVO.setTel(item_child.getTextContent());
        				break;
        			case "mapX":
        				aVO.setMapX(item_child.getTextContent());
        				break;
        			case "mapY":
        				aVO.setMapY(item_child.getTextContent());
        				break;
        			case "animalCmgCl":
        				aVO.setAnimalCmgCl(item_child.getTextContent());
        				break;
        			case "homepage":
        				aVO.setHomepage(item_child.getTextContent());
        				break;
        			case "induty":
        				aVO.setInduty(item_child.getTextContent());
        				break;
        			}
        		}
        		
        		jlist.add(aVO);
        		
        		req.setAttribute("LIST", jlist);
        		
        	}
        	
        } catch (Exception e) {}
        
		return view;
	}

}
