package com.camp24.dao.sjin;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.camp24.db.CmpDBCP;
import com.camp24.sql.sjin.QnaBoardSQL;
import com.camp24.util.PageUtil;
import com.camp24.vo.BoardVO;

/**
 * 
 * 이 클래스는 QnA 게시판 관련 데이터베이스 작업을 전담해서 처리할 기능의 클래스
 * 
 * @author	백서진
 * @since	2022/05/26
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				
 * 				2022/05/26	-	클래스 제작
 * 								QnA 게시판 클래스 제작
 * 									담당자 : 백서진
 *
 */

public class QnaBoardDao {
	private CmpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private QnaBoardSQL qSQL;
	
	public QnaBoardDao() {
		db = new CmpDBCP();
		qSQL = new QnaBoardSQL();
	}
	
	// QnA 게시판 게시글 리스트 조회 전담 처리함수
	public ArrayList<BoardVO> getQBoardList(PageUtil page){
		// 반환값 변수
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.SEL_QBRD_LIST);
		
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
				// rno, qno, qupno, mno, id, qtitle, qbody, savename, qdate, qedate, click, step
				bVO.setRno(rs.getInt("rno"));
				bVO.setQno(rs.getInt("qno"));
				bVO.setQupno(rs.getInt("qupno"));
				bVO.setMno(rs.getInt("mno"));
				bVO.setId(rs.getString("id"));
				bVO.setQtitle(rs.getString("qtitle"));
				bVO.setQbody(rs.getString("qbody"));
				bVO.setAvatar(rs.getString("savename"));
				bVO.setWdate(rs.getDate("qdate"));
				bVO.setWtime(rs.getTime("qdate"));
				bVO.setSdate();
				bVO.setStime();
				bVO.setQedate(rs.getDate("qedate"));
				bVO.setQetime(rs.getTime("qedate"));
				if(bVO.getQedate() != null) {
					bVO.setSedate();
					bVO.setSetime();
				}
				bVO.setClick(rs.getInt("click"));
				bVO.setStep(rs.getInt("step"));
				
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
	
	// 답변 작성자 정보 조회 전담 처리함수
	public BoardVO getWriterInfo(String id, int qno) {
		// 반환값 변수
		BoardVO bVO = new BoardVO();
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.SEL_WRITER_INFO);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, qno);
			pstmt.setString(2, id);
			
			// 질의명령 보내고 결과 받고
			rs = pstmt.executeQuery();
			
			// 결과에서 데이터 꺼내서 VO에 담고
			rs.next();
			bVO.setQno(rs.getInt("qno"));
			bVO.setMno(rs.getInt("mno"));
			bVO.setTitle(rs.getString("title"));
			bVO.setBody(rs.getString("body"));
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
	
	// 원글 작성자 정보 조회 전담 처리함수
	public BoardVO getMyInfo(String id) {
		// 반환값 변수
		BoardVO bVO = new BoardVO();
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.SEL_MY_INFO);
		
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
			bVO.setId(rs.getString("id"));
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
	public int addQnaBoard(BoardVO bVO) {
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.INSERT_QNABOARD);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, bVO.getMno());
			pstmt.setString(2, bVO.getQtitle());
			pstmt.setString(3, bVO.getBody());
			if(bVO.getQupno() == 0) {
				pstmt.setNull(4, java.sql.Types.NULL);
			} else {
				pstmt.setInt(4, bVO.getQupno());
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
	
	// 게시글 수정 데이터베이스 작업 전담 처리함수
	public int editQnaBoard(int qno, String psql) {
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.EDIT_QNABOARD);
		
		// 질의명령 수정하고
		sql = sql.replaceAll("###", psql);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, qno);
			
			// 질의명령 보내고 결과 받고
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
	public int delQnaBoard(int qno) {
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.DEL_QNABOARD);
		
		// 명령전달도구
		pstmt = db.getPSTMT(con, sql);
		
		try {
			// 질의명령 완성하고
			pstmt.setInt(1, qno);
			
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
		// 반환값 변수
		int cnt = 0;
		
		// 커넥션
		con = db.getCon();
		
		// 질의명령
		String sql = qSQL.getSQL(qSQL.SEL_TOTAL_CNT);
		
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
