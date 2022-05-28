package com.camp24.controller.leo.board;
/**
 * 
 * @author	leo
 * @since	2022/05/24
 * @version	v.1.0
 * @see
 * 			com.camp24.controller.leo.Weather
 * 			
 * 
 * 			작업이력 ]
 * 				2022.05.24	-	클래스제작
 * 								담당자 : leo
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/*import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;*/

public class Weather {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=bLyvjKvN%2BtNLngQDTc%2BZQpBhcThBhEhNOdGZQHmBg7J%2BAbw8FP%2BNK2BCrNGlNRpGm23FRzgIm1BwvavyKr9lBA%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*요청자료형식(XML/JSON) Default: XML*/
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode("20220524", "UTF-8")); /*‘21년 6월 28일발표*/
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode("2300", "UTF-8")); /*05시 발표*/
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode("55", "UTF-8")); /*예보지점의 X 좌표값*/
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode("127", "UTF-8")); /*예보지점의 Y 좌표값*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        
        System.out.println(sb.toString());
        
//        System.out.println(sb.substring(225, 227));
//        System.out.println(sb.substring(358, 361));
//        String lett = (String) sb.substring(0, 227);

        
        String result = sb.toString();

		/*
		 * try { JSONParser jsonParser = new JSONParser(); JSONObject jsonObj; jsonObj =
		 * (JSONObject) jsonParser.parse(result); JSONObject parse_response =
		 * (JSONObject) jsonObj.get("response"); JSONObject parse_body = (JSONObject)
		 * parse_response.get("body");// response 로 부터 body 찾아오기 JSONObject parse_items
		 * = (JSONObject) parse_body.get("items");// body 로 부터 items 받아오기 JSONArray
		 * parse_item = (JSONArray) parse_items.get("item"); // items로 부터 itemlist 를
		 * 받아오기 itemlist : 뒤에 [ 로 시작하므로 jsonarray이다. } catch (ParseException e) {
		 * e.printStackTrace(); }
		 */
        

        
//      req.setAttribute("Sjson", result);
      
      //응답문서
      PrintWriter pw = null;
		try {
//			pw = resp.getWriter(); 

			pw.println(result);
			
		} catch(Exception e) {}	
      
      		
        
        
        
        		
        
        
    }
}