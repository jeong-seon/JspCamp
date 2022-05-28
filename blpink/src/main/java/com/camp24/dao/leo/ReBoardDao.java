package com.camp24.dao.leo;

import java.sql.*;
import java.util.*;
import java.util.Date;

import com.camp24.db.*;
import com.camp24.sql.leo.RBoardSQL;
import com.camp24.util.PageUtil;
import com.camp24.vo.*;
import com.camp24.vo.BoardVO;
import com.camp24.vo.FileVO;

/**
 * @author	leo
 * @since	2022/05/26
 * @version	v.1.0
 * @see
 * 
 * 			작업이력 ]
 * 				2022.05.26	-	클래스제작
 * 								담당자 : leo
 *
 */

public class ReBoardDao {
	private CmpDBCP db;
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private RBoardSQL rSQL;
	
	public ReBoardDao() {
		db = new CmpDBCP();
		rSQL = new RBoardSQL();
	}
	
	// 리뷰글 입력 데이터베이스 작업 처리 함수
	public int WriteRe(BoardVO bVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.INSERT_RBOARD);
		//명령전달도구
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, bVO.getBody());
			pstmt.setString(2, bVO.getId());
			pstmt.setString(3, bVO.getTitle());
			
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	//리뷰글 데이터베이스 등록 전담 처리함수
	public int insertReData(BoardVO bVO) {
		int cnt = 0;
		cnt = WriteRe(bVO);
		if(cnt != 1) {
			return cnt;
		}
		cnt = addFileList(bVO.getList());
		if(cnt != bVO.getList().size()) {
			return -1;
		}
		return cnt;
	}
	
	//단일 파일 정보 데이터 베이스 입력 전담 처리함수
	public int addFileInfo(FileVO fVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.INSERT_FILEINFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, fVO.getId());
			pstmt.setString(2, fVO.getOriname());
			pstmt.setString(3, fVO.getSavename());
			pstmt.setString(4, fVO.getDir());
			pstmt.setLong(5, fVO.getLen());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
		
	}
	
	
	// 다중파일 데이터베이스 입력 전담 처리함수
	public int addFileList(ArrayList<FileVO> list) {
		int cnt = 0;
		for(FileVO fVO: list) {
			cnt += addFileInfo(fVO);
		}
		
		return cnt;
	}
	
	public int getTotalCount() {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_TOTAL_COUNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 후기 삭제 처리 함수
	public int DelReview(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.DEL_REVIEW);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
			
		}
		return cnt;
	}
	
	// 게시글 상세보기 데이터조회 전담 처리함수
		public BoardVO getBoardDetail(int rno) {
			BoardVO bVO = new BoardVO();
			ArrayList<FileVO> list = new ArrayList<FileVO>();
			bVO.setList(list);
			con = db.getCon();
			String sql = rSQL.getSQL(rSQL.SEL_REVIEW_DETAIL);
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setInt(1, rno);
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					if(rs.isFirst()) {
						bVO.setBno(rs.getInt("rno"));
						bVO.setId(rs.getString("id"));
						bVO.setTitle(rs.getString("rtitle"));
						bVO.setBody(rs.getString("rbody").replaceAll("\r\n", "<br>"));
						bVO.setWdate(rs.getDate("rdate"));
						bVO.setWtime(rs.getTime("rdate"));
						bVO.setClick(rs.getInt("click"));
					}
					
					FileVO fVO = new FileVO();
					fVO.setFno(rs.getInt("ino"));
					fVO.setOriname(rs.getString("ioriname"));
					fVO.setSavename(rs.getString("isavename"));
					fVO.setDir(rs.getString("idir"));
					list.add(fVO);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			return bVO;
		}
	
		 //list 보여주는 함수
		public ArrayList<BoardVO> getReBoardList(PageUtil page){
			ArrayList<BoardVO> list = new ArrayList<BoardVO>();
			con = db.getCon();
			String sql = rSQL.getSQL(rSQL.SEL_REBOARD_LIST);
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setInt(1, page.getStartCont());
				pstmt.setInt(2, page.getEndCont());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BoardVO bVO = new BoardVO();
					bVO.setRno(rs.getInt("rno"));
					bVO.setId(rs.getString("id"));
					bVO.setTitle(rs.getString("rtitle"));
					bVO.setBody(rs.getString("rbody"));
					
					list.add(bVO);
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			return list;
		}
		
		//리뷰쓰기 사용데이터 조회전담 처리함수
		public BoardVO getEditData(int rno, String id) {
			BoardVO bVO = new BoardVO();
			// con
			con = db.getCon();
			//sql
			String sql = rSQL.getSQL(rSQL.SEL_REBOARD_INFO);
			//명령전달도구
			pstmt = db.getPSTMT(con, sql);
			
			try {
				//질의명령완성
				pstmt.setInt(1, rno);
				pstmt.setString(2, id);
				//보내고 결과받고
				rs = pstmt.executeQuery();
				//vo에 담고
				rs.next();
				bVO.setBno(rs.getInt("rno"));
				bVO.setBody(rs.getString("rbody"));
				bVO.setMno(rs.getInt("mno"));
				bVO.setId(rs.getString("id"));
				bVO.setAvatar(rs.getString("savename"));
				bVO.setWdate(rs.getDate("wdate"));
				bVO.setWtime(rs.getTime("wdate"));
				bVO.setSdate();
		
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(rs);
				db.close(pstmt);
				db.close(con);
			}
			
			//vo반환
			return bVO;
		}
		
		// 게시글 수정 데이터베이스 작업 전담 처리함수
		public int editReboard(int rno, String body) {
			int cnt = 0;
			con = db.getCon();
			String sql = rSQL.getSQL(rSQL.UPDATE_REBOARD);
			pstmt = db.getPSTMT(con, sql);
			try {
				pstmt.setString(1, body);
				pstmt.setInt(2, rno);
				cnt = pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				db.close(pstmt);
				db.close(con);
			}
			return cnt;
			
		}
}
