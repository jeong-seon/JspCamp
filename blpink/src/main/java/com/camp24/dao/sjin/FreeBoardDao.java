package com.camp24.dao.sjin;

import java.util.*;
import java.sql.*;
import java.util.Date;

import com.camp24.db.*;
import com.camp24.sql.*;
import com.camp24.sql.sjin.FreeBoardSQL;
import com.camp24.util.*;
import com.camp24.vo.*;

/**
 * 
 * 이 클래스는 자유게시판 관련 데이터베이스 작업을 전담해서 처리할 기능의 클래스
 * 
 * @author	백서진
 * @since	2022/05/24
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022/05/24	-	클래스 제작
 * 								자유게시판 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class FreeBoardDao {
	private CmpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private FreeBoardSQL fSQL;
	
	public FreeBoardDao() {
		db = new CmpDBCP();
		fSQL = new FreeBoardSQL();
	}
	
	// 자유게시판 게시글 리스트 조회 전담 처리함수
	public ArrayList<BoardVO> getFBoardList(PageUtil page){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = fSQL.getSQL(fSQL.SEL_FRBRD_LIST);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고 (페이징 처리)
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 결과에서 꺼내서 VO에 담고
				BoardVO bVO = new BoardVO();
				// rno, fbno, fupno, mno, id, fbody, ftitle, savename, fdate, fedate, click, step
				bVO.setRno(rs.getInt("rno"));
				bVO.setFbno(rs.getInt("fbno"));
				bVO.setFupno(rs.getInt("fupno"));
				bVO.setMno(rs.getInt("mno"));
				bVO.setId(rs.getString("id"));
				bVO.setFbody(rs.getString("fbody"));
				bVO.setFtitle(rs.getString("ftitle"));
				bVO.setAvatar(rs.getString("savename"));
				bVO.setWdate(rs.getDate("fdate"));
				bVO.setWtime(rs.getTime("fdate"));
				bVO.setSdate();
				bVO.setStime();
				bVO.setFedate(rs.getDate("fedate"));
				bVO.setFetime(rs.getTime("fedate"));
				if(bVO.getFedate() != null) {
					bVO.setSedate();
					bVO.setSetime();
				}
				bVO.setClick(rs.getInt("click"));
				bVO.setStep(rs.getInt("step"));
				
				/*
					bVO.setFedate(rs.getDate("fedate"));
					bVO.setFedate(rs.getTime("fedate"));
					bVO.setSdate();
				*/
				// 리스트에 담고
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		// 리스트 반환하고
		return list;
	}
	
	// 작성자 정보 조회 전담 처리함수
	public BoardVO getWriterInfo(String id) {
		BoardVO bVO = new BoardVO();
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = fSQL.getSQL(fSQL.SEL_WRITER_INFO);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setString(1, id);
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			// 결과에서 데이터 꺼내서 VO에 담고
			rs.next();
			bVO.setMno(rs.getInt("mno"));
			bVO.setAvatar(rs.getString("savename"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		// VO 반환하고
		return bVO;
	}
	
	// 글 등록 데이터베이스 작업 전담 처리함수
	public int addFreeBoard(BoardVO bVO) {
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = fSQL.getSQL(fSQL.INSERT_FREEBOARD);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setString(1, bVO.getBody());
			pstmt.setInt(2, bVO.getMno());
			pstmt.setString(3, bVO.getTitle());
			if(bVO.getFupno() == 0) {
				pstmt.setNull(4, java.sql.Types.NULL);
			}
			// 보내고 결과 받고
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
	
	// 게시글 삭제 데이터베이스 작업 전담 처리함수
	public int delFreeBoard(int fbno) {
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = fSQL.getSQL(fSQL.DEL_FREEBOARD);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, fbno);
			
			// 질의명령 보내고 결과 받고
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 결과 내보내고
		return cnt;
	}
	// 총 게시글 수 조회 전담 처리함수
		public int getTotal() {
			int cnt = 0;
			// 커넥션
			con = db.getCon();
			
			// 질의명령
			String sql = fSQL.getSQL(fSQL.SEL_TOTAL_CNT);
			
			// 명령전달도구
			stmt = db.getSTMT(con);
			
			try {
				// 질의명령 보내고 결과 받고
				rs = stmt.executeQuery(sql);
				
				// 결과 꺼내서 변수에 기억시키고
				rs.next();
				cnt = rs.getInt("cnt");
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(stmt);
				db.close(con);
			}
			
			// 결과 반환하고
			return cnt;
		}
}
