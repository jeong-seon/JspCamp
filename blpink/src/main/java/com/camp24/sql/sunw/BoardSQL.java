package com.camp24.sql.sunw;

public class BoardSQL {
	public final int SEL_BOARD_LIST			=	1001;
	public final int SEL_TOTAL_COUNT		=	1002;
	public final int SEL_BOARD_DETAIL		=	1003;
	public final int SEL_CAMP_LIST			=	1004;
	
	public final int INSERT_BOARD			= 	3001;
	public final int INSERT_FILEINFO		= 	3002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case INSERT_BOARD:
			buff.append("INSERT INTO ");
			buff.append("	review(rno, rmno, rtitle, rbody) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(rno) + 1, 100001) FROM review), ");
			buff.append("	(SELECT mno FROM member WHERE id = ? ), ");
			buff.append("	?, ? ");
			buff.append(") ");
			break;
		case INSERT_FILEINFO:
			buff.append("INSERT INTO ");
			buff.append("	fileinfo(fno, fbno, oriname, savename, dir, len) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(fno) + 1, 10000001) FROM fileinfo), ");
			buff.append("	(SELECT MAX(bno) FROM board WHERE bmno = (SELECT mno FROM member WHERE id = ? )), ");
			buff.append("	?, ?, ?, ? ");
			buff.append(") ");
			break;
		case SEL_TOTAL_COUNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	review ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			break;
		case SEL_BOARD_LIST:
			buff.append("SELECT ");
			buff.append("    r.rno, id, rtitle, rdate, click, cnt ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rno, bno, id, title, wdate, click, cnt ");
			buff.append("        FROM ");
			buff.append("            ( ");
			buff.append("                SELECT ");
			buff.append("                    bno, id, title, wdate, click, NVL(cnt, 0) cnt ");
			buff.append("                FROM ");
			buff.append("                    board b, member m, ");
			buff.append("                    ( ");
			buff.append("                        SELECT ");
			buff.append("                            fbno, COUNT(*) cnt ");
			buff.append("                        FROM ");
			buff.append("                            fileinfo ");
			buff.append("                        WHERE ");
			buff.append("                            isshow = 'Y' ");
			buff.append("                        GROUP BY ");
			buff.append("                            fbno ");
			buff.append("                    ) ");
			buff.append("                WHERE ");
			buff.append("                    bmno = mno ");
			buff.append("                    AND fbno(+) = bno ");
			buff.append("                    AND b.isshow = 'Y' ");
			buff.append("                    AND m.isshow = 'Y' ");
			buff.append("                ORDER BY ");
			buff.append("                    wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_BOARD_DETAIL:
			buff.append("SELECT ");
			buff.append("    bno, id, title, body, wdate, click, fno, oriname, savename, dir ");
			buff.append("FROM ");
			buff.append("    board b, member m, fileinfo f ");
			buff.append("WHERE ");
			buff.append("    bno = fbno(+) ");
			buff.append("    AND bmno = mno ");
			buff.append("    AND b.isshow = 'Y' ");
			buff.append("    AND bno = ? ");
			break;
		case SEL_CAMP_LIST:
			buff.append("SELECT ");
			buff.append("	cno, cname ");
			buff.append("FROM ");
			buff.append("	camp ");
			break;
		}
		return buff.toString();
	}
}
