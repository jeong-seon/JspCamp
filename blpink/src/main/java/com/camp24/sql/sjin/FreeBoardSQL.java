package com.camp24.sql.sjin;

public class FreeBoardSQL {
	public final int SEL_TOTAL_CNT		=	1001;
	public final int SEL_FRBRD_LIST		=	1002;
	public final int SEL_WRITER_INFO	=	1003;
	public final int SEL_MY_INFO		=	1004;
	
	public final int DEL_FREEBOARD		=	2001;
	public final int EDIT_FREEBOARD		=	2002;
	
	public final int INSERT_FREEBOARD	=	3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch(code) {
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	freeboard ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_FRBRD_LIST:
			buff.append("SELECT ");
			buff.append("   rno, fbno, fupno, mno, id, fbody, ftitle, savename, fdate, fedate, click, step ");
			buff.append("FROM ");
			buff.append("   ( ");
			buff.append("   SELECT ");
			buff.append("       ROWNUM rno, fbno, fupno, mno, id, fbody, ftitle, savename, fdate, fedate, click, step ");
			buff.append("   FROM ");
			buff.append("       ( ");
			buff.append("           SELECT ");
			buff.append("               fbno, NVL(fupno, 0) fupno, mno, id, fbody, ftitle, savename, fdate, fedate, click, (level - 1) step ");
			buff.append("           FROM ");
			buff.append("               freeboard f, member m, avatar a ");
			buff.append("           WHERE ");
			buff.append("               f.isshow = 'Y' ");
			buff.append("               AND fmno = mno ");
			buff.append("               AND avt = ano ");
			buff.append("           START WITH ");
			buff.append("               fupno IS NULL ");
			buff.append("           CONNECT BY ");
			buff.append("               PRIOR fbno = fupno ");
			buff.append("           ORDER SIBLINGS BY ");
			buff.append("               fdate DESC ");
			buff.append("           ) ");
			buff.append("       ) ");
			buff.append("WHERE ");
			buff.append("   rno BETWEEN ? AND ? ");
			break;
		case SEL_MY_INFO:
			buff.append("SELECT ");
			buff.append("   mno, savename ");
			buff.append("FROM ");
			buff.append("   member m, avatar a ");
			buff.append("WHERE ");
			buff.append("   avt = ano ");
			buff.append("   AND m.isshow = 'Y' ");
			buff.append("	AND id = ? ");
			break;
		case SEL_WRITER_INFO:
			buff.append("SELECT ");
			buff.append("   fbno, mno, savename, title, body ");
			buff.append("FROM ");
			buff.append("   member m, avatar a, ");
			buff.append("   ( ");
			buff.append("       SELECT ");
			buff.append("           fbno, ftitle title, fbody body ");
			buff.append("       FROM ");
			buff.append("           freeboard ");
			buff.append("       WHERE ");
			buff.append("           fbno = ? ");
			buff.append("   ) ");
			buff.append("WHERE ");
			buff.append("   avt = ano ");
			buff.append("   AND m.isshow = 'Y' ");
			buff.append("AND id = ? ");
			break;
		case INSERT_FREEBOARD:
			buff.append("INSERT INTO ");
			buff.append("   freeboard(fbno, fbody, fmno, ftitle, fupno) ");
			buff.append("VALUES( ");
			buff.append("   (SELECT NVL(MAX(fbno) + 1, 100001) FROM freeboard), ");
			buff.append("   ?, ?, ?, ? ");
			buff.append(") ");
			break;
		case DEL_FREEBOARD:
			buff.append("UPDATE ");
			buff.append("   freeboard ");
			buff.append("SET ");
			buff.append("   isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("   fbno = ? ");
			break;
		case EDIT_FREEBOARD:
			buff.append("UPDATE ");
			buff.append("   freeboard ");
			buff.append("SET ");
			buff.append("   ### ");
			buff.append("WHERE ");
			buff.append("   isshow = 'Y' ");
			buff.append("   AND fbno = ? ");
			break;
		}
		
		return buff.toString();
	}
}
