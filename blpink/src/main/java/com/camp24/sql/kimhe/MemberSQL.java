package com.camp24.sql.kimhe;
/**
 * 
 * @author 김희승
 * @since 2022-05-25
 */



public class MemberSQL {
	public final int SEL_LOGIN_CNT 		= 1001;
	public final int SEL_MEMBER_INFO 	= 1002;
	public final int SEL_MNO_INFO		= 1007;
	public final int DEL_MEMBER 		= 2001;

	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_LOGIN_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ? ");
			break;
		case SEL_MEMBER_INFO:
			buff.append("SELECT ");
			buff.append("	mno, mname, id, email, tel, m.gen, joindate, ano, savename ");
			buff.append("FROM ");
			buff.append("	member m, avatar ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND avt = ano ");
			buff.append("	AND id = ? ");
			break;
		case SEL_MNO_INFO:
			buff.append("SELECT ");
			buff.append("	mno, mname, id, email, tel, m.gen, joindate, ano, savename ");
			buff.append("FROM ");
			buff.append("	member m, avatar ");
			buff.append("WHERE ");
			buff.append("	m.isshow = 'Y' ");
			buff.append("	AND avt = ano ");
			buff.append("	AND mno = ? ");
			break;
		case DEL_MEMBER:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	isshow = 'N' ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND mno = ? ");
			break;

		}
		return buff.toString();
	}
}