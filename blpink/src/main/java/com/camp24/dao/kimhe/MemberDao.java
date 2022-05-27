package com.camp24.dao.kimhe;
/**
 * 
 * @author 김희승
 * @since 2022-05-25
 */


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.camp24.db.CmpDBCP;
import com.camp24.sql.kimhe.*;
import com.camp24.vo.MemberVO;

public class MemberDao {

	private CmpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private MemberSQL mSQL;
	
	public MemberDao() {
		db = new CmpDBCP();
		mSQL = new MemberSQL();
	}
	
	// 로그인 데이터베이스작업 전담 처리함수
	public int getLogin(String id, String pw) {
		int cnt = 0;
		// 커넥션
		con = db.getCon();
		// 질의명령
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN_CNT);
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 결과에서 데이터꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
			System.out.println("cnt : " + cnt);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		// 데이터 내보내고
		return cnt;
	}
	
	// 회원번호로 회원 정보 조회 전담 처리함수
		public MemberVO getMnoInfo(int mno) {
			/*
				이함수가 데이터베이스에서 꺼내올 데이터는
				회원 한명의 데이터이기 때문에
				VO를 만들고 채워서 반환해주면 작업이 끝난다.
			 */
			MemberVO mVO = new MemberVO();
			// con
			con = db.getCon();
			// sql
			String sql = mSQL.getSQL(mSQL.SEL_MNO_INFO);
			// pstmt
			pstmt = db.getPSTMT(con, sql);
			try {
				// setting variable
				pstmt.setInt(1, mno);
				// send and receive
				rs = pstmt.executeQuery();
				// get Data
				rs.next();
				// vo setting
				mVO.setMno(rs.getInt("mno"));
				mVO.setName(rs.getString("name"));
				mVO.setId(rs.getString("id"));
				mVO.setMail(rs.getString("mail"));
				mVO.setTel(rs.getString("tel"));
				mVO.setGen(rs.getString("gen"));
				mVO.setAno(rs.getInt("ano"));
				mVO.setSavename(rs.getString("savename"));
				mVO.setJdate(rs.getDate("joindate"));
				mVO.setJtime(rs.getTime("joindate"));
				mVO.setSdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			// return
			return mVO;
		}
		
		// 아이디로 회원 정보조회 전담 처리함수
		public MemberVO getIdInfo(String id) {
			// 반환값 변수
			MemberVO mVO = new MemberVO();
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = mSQL.getSQL(mSQL.SEL_MEMBER_INFO);
			// 명령전달도구
			pstmt = db.getPSTMT(con, sql);
			try {
				// 질의명령 완성
				pstmt.setString(1, id);
				// 질의명령 보내고 결과받고
				rs = pstmt.executeQuery();
				// 꺼내서 VO에 담고
				rs.next();
				// vo setting
				mVO.setMno(rs.getInt("mno"));
				mVO.setName(rs.getString("name"));
				mVO.setId(rs.getString("id"));
				mVO.setMail(rs.getString("mail"));
				mVO.setTel(rs.getString("tel"));
				mVO.setGen(rs.getString("gen"));
				mVO.setAno(rs.getInt("ano"));
				mVO.setSavename(rs.getString("savename"));
				mVO.setJdate(rs.getDate("joindate"));
				mVO.setJtime(rs.getTime("joindate"));
				mVO.setSdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			// 데이터 반환해주고
			return mVO;
		}
		
		// 회원탈퇴 데이터베이스작업 전담 처리함수
		public int delMember(int mno) {
			// 할일
			// 반환값 변수
			int cnt = 0;
			// 커넥션
			con = db.getCon();
			// 질의명령
			String sql = mSQL.getSQL(mSQL.DEL_MEMBER);
			// 명령전달도구
			pstmt = db.getPSTMT(con, sql);
			try{
				// 질의명령 완성
				pstmt.setInt(1, mno);
				// 질의명령 보내고 결과받고..
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(pstmt);
				db.close(con);
			}
			// 결과 반환하고
			return cnt;
		}
}
