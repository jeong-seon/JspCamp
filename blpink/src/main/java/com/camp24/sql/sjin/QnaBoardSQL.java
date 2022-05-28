package com.camp24.sql.sjin;

public class QnaBoardSQL {
	
	public final int SEL_TOTAL_CNT		=	1001;
	public final int SEL_QBRD_LIST		=	1002;
	public final int SEL_WRITER_INFO	=	1003;
	public final int SEL_MY_INFO		=	1004;
	
	public final int DEL_QNABOARD		=	2001;
	public final int EDIT_QNABOARD		=	2002;
	
	public final int INSERT_QNABOARD	=	3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	qna ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_QBRD_LIST:
			buff.append("SELECT ");
			buff.append("   rno, qno, qupno, mno, id, qtitle, qbody, savename, qdate, qedate, click, step ");
			buff.append("FROM ");
			buff.append("   ( ");
			buff.append("   SELECT ");
			buff.append("       ROWNUM rno, qno, qupno, mno, id, qtitle, qbody, savename, qdate, qedate, click, step ");
			buff.append("   FROM ");
			buff.append("       ( ");
			buff.append("           SELECT ");
			buff.append("               qno, NVL(qupno, 0) qupno, mno, id, qtitle, qbody, savename, qdate, qedate, click, (level - 1) step ");
			buff.append("           FROM ");
			buff.append("               qna q, member m, avatar a ");
			buff.append("           WHERE ");
			buff.append("               q.isshow = 'Y' ");
			buff.append("               AND qmno = mno ");
			buff.append("               AND avt = ano ");
			buff.append("           START WITH ");
			buff.append("               qupno IS NULL ");
			buff.append("           CONNECT BY ");
			buff.append("               PRIOR qno = qupno ");
			buff.append("           ORDER SIBLINGS BY ");
			buff.append("               qdate DESC ");
			buff.append("           ) ");
			buff.append("       ) ");
			buff.append("WHERE ");
			buff.append("   rno BETWEEN ? AND ? ");
			break;
		case SEL_MY_INFO:
			buff.append("SELECT ");
			buff.append("   mno, id, savename ");
			buff.append("FROM ");
			buff.append("   member m, avatar a ");
			buff.append("WHERE ");
			buff.append("   avt = ano ");
			buff.append("   AND id = ? ");
			break;
		case SEL_WRITER_INFO:
			buff.append("SELECT ");
			buff.append("   qno, mno, savename, title, body ");
			buff.append("FROM ");
			buff.append("   member m, avatar a, ");
			buff.append("   ( ");
			buff.append("       SELECT ");
			buff.append("           qno, qtitle title, qbody body ");
			buff.append("       FROM ");
			buff.append("           qna ");
			buff.append("       WHERE ");
			buff.append("           qno = ? ");
			buff.append("   ) ");
			buff.append("WHERE ");
			buff.append("   avt = ano ");
			buff.append("   AND m.isshow = 'Y' ");
			buff.append("AND id = ? ");
			break;
		case INSERT_QNABOARD:
			buff.append("INSERT INTO ");
			buff.append("	qna(qno, qmno, qtitle, qbody, qupno) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(qno) + 1, 100001) FROM qna), ");
			buff.append("		?, ?, ?, ? ");
			buff.append("	) ");
			break;
		case DEL_QNABOARD:
			buff.append("UPDATE ");
			buff.append("	qna ");
			buff.append("SET ");
			buff.append("   isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("   qno = ? ");
			break;
		case EDIT_QNABOARD:
			buff.append("UPDATE ");
			buff.append("   qna ");
			buff.append("SET ");
			buff.append("   ### ");
			buff.append("WHERE ");
			buff.append("   isshow = 'Y' ");
			buff.append("   AND qno = ? ");
			break;
		}
		
		return buff.toString();
	}
}
