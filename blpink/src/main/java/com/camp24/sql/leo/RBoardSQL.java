package com.camp24.sql.leo;


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

public class RBoardSQL {
	
	public final int SEL_REVIEW_DETAIL		=	1001;
	public final int SEL_TOTAL_COUNT		=	1002;
	public final int SEL_REBOARD_LIST		=	1003;
	public final int SEL_REBOARD_INFO		=	1004;


	public final int UPDATE_REBOARD = 2001;
	public final int DEL_REVIEW = 2002;
	
	public final int INSERT_RBOARD = 3001;
	public final int INSERT_FILEINFO = 3002;
		
	public String getSQL(int code) {
			
			StringBuffer buff = new StringBuffer();
			
			switch(code) {
			
			case INSERT_RBOARD: 
				buff.append("INSERT INTO ");
				 buff.append("   REVIEW(RNO, RBODY, RMNO, RTITLE, CLICK )  ");
				 buff.append(" VALUES( ");
				 buff.append(" (SELECT NVL(MAX(RNO) +1, 1001) FROM REVIEW), ");
			     buff.append(" ?, (SELECT MNO FROM MEMBER WHERE ID = ?), ?, 0  ");
			     buff.append(" ) ");
				
				break;
				
			case INSERT_FILEINFO: 
				buff.append("INSERT INTO ");
				buff.append("   IMAGE(INO, IMAGENO, IORINAME, ISAVENAME, IDIR, ILEN ) ");
				buff.append(" VALUES( ");
				buff.append(" (SELECT NVL(MAX(INO) +1, 1001) FROM IMAGE), ");
				buff.append("  (SELECT MAX(rno) FROM REVIEW WHERE rmno = (SELECT mno FROM member WHERE id = ? ))  ");
				buff.append("  ?, ?, ?, ?  ");
				buff.append(" ) ");
				
				break;
				
			case SEL_TOTAL_COUNT:
				buff.append("SELECT ");
				buff.append("	COUNT(*) cnt ");
				buff.append("FROM ");
				buff.append("	review ");
				buff.append("WHERE ");
				buff.append("	isshow = 'Y' ");
				break;
				
			case DEL_REVIEW:
				buff.append("UPDATE ");
				buff.append("	REVIEW ");
				buff.append("SET  ");
				buff.append("	 ISSHOW = 'N'  ");
				buff.append("WHERE ");
				buff.append("	RNO = ? ");
				break;
				 
			case SEL_REVIEW_DETAIL:
				buff.append("SELECT ");
				buff.append("    rno, id, rtitle, rbody, rdate, click, ino, ioriname, isavename, idir ");
				buff.append("FROM ");
				buff.append("    REVIEW R, member m, IMAGE I ");
				buff.append("WHERE ");
				buff.append("    rno = IMAGENO(+) ");
				buff.append("    AND Rmno = mno ");
				buff.append("    AND R.isshow = 'Y' ");
				buff.append("    AND rno = ? ");
				break;
				
			case SEL_REBOARD_LIST :
			buff.append("	        SELECT  ");
			buff.append("	            ROWN, rno, id, rtitle, rbody  ");
			buff.append("	      FROM (select ROWNUM ROWN, rno, id, rtitle, rbody ");
			buff.append("	        from review, member  ");
			buff.append("	        where REVIEW.ISSHOW = 'Y')  ");
			buff.append("	     WHERE ROWN between ? and ?  ");
				
				
				break;/*
			case SEL_REBOARD_LIST :
				buff.append("	SELECT  ROWN, RNO, ID, RTITLE, RDATE, CLICK, NVL(CNT,0) CNT  ");
				buff.append("	   FROM  ");
				buff.append("	        (  ");
				buff.append("	        SELECT  ");
				buff.append("	            ROWNUM ROWN, RNO, ID, RTITLE, RDATE, CLICK, NVL(CNT,0) CNT  ");
				buff.append("	        FROM  ");
				buff.append("	                (  ");
				buff.append("	                SELECT  ");
				buff.append("	                    RNO, ID, RTITLE, RDATE, CLICK, NVL(CNT,0) CNT  ");
				buff.append("	                FROM  ");
				buff.append("	                    REVIEW R, MEMBER M,   ");
				buff.append("	                    (  ");
				buff.append("	                        SELECT  ");
				buff.append("	                         IMAGENO, COUNT(*) CNT  ");
				buff.append("	                    FROM  ");
				buff.append("	                         IMAGE  ");
				buff.append("	                    WHERE  ");
				buff.append("	                        ISSHOW = 'Y'  ");
				buff.append("	                    GROUP BY  ");
				buff.append("	                       IMAGENO  ");
				buff.append("	                    )  ");
				buff.append("	                WHERE  ");
				buff.append("	                    RMNO = MNO  ");
				buff.append("	                    AND RNO = IMAGENO  ");
				buff.append("	                    AND R.ISSHOW = 'Y'  ");
				buff.append("	                    AND M.ISSHOW = 'Y'  ");
				buff.append("	                ORDER BY  ");
				buff.append("	                    RDATE DESC  ");
				buff.append("	                    )  ");
				buff.append("	       )  ");
				buff.append("	  WHERE  ");
				buff.append("	        ROWN BETWEEN 100000+? AND 100000?   ");
				
				
				break;
				*/
			case SEL_REBOARD_INFO:
				
				buff.append("SELECT ");
				buff.append(" RNO, RBODY, wdate, mno, ID , SAVENAME ");
				buff.append("FROM ");
				buff.append(" MEMBER M , AVATAR A, REVIEW R ");
				buff.append("WHERE  ");
				buff.append("	R.ISSHOW = 'Y' ");
				buff.append("AND RNO = ? ");
				buff.append("AND AVT = ANO ");
				buff.append("AND ID = ? ");
				
				break;
				
			case UPDATE_REBOARD:
				
				buff.append(" UPDATE  ");
				buff.append(" REVIEW  ");
				buff.append(" SET  ");
				buff.append("    BODY = ?  ");
				buff.append(" WHERE RNO = ?  ");
				
				break;
				
			}
			
			return buff.toString();
		}
}
