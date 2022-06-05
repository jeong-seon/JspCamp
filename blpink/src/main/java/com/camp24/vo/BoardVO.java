package com.camp24.vo;

import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.*;

public class BoardVO {
	private int mno, qmno, rmno, bno, fbno, qno,  upno, qupno, fupno, rno, rcno, cno, ano, pno, pcno, click, cnt, step, lat, plong, imageno;
	private String id, title, ftitle, qtitle, rtitle, body, qbody, fbody, rbody, sdate, stime, sedate, setime, avatar, score, cname, gname, jname, isavename;
	private Date wdate, qdate, qedate, fdate, fedate, rdate, redate ;
	private Time wtime, qtime, qetime, ftime, fetime, rtime, retime ;
	ArrayList<FileVO> list;
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getUpno() {
		return upno;
	}
	public void setUpno(int upno) {
		this.upno = upno;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		sdate = form.format(wdate);
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getStime() {
		return stime;
	}
	public void setStime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		stime = form.format(wtime);
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getSedate() {
		return sedate;
	}
	public void setSedate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy/MM/dd");
		sedate = form.format(fedate);
	}
	public void setSedate(String sedate) {
		this.sedate = sedate;
	}
	public String getSetime() {
		return setime;
	}
	public void setSetime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		setime = form.format(fetime);
	}
	public void setSetime(String setime) {
		this.setime = setime;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
		setSdate();
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setStime();
	}
	public ArrayList<FileVO> getList() {
		return list;
	}
	public void setList(ArrayList<FileVO> list) {
		this.list = list;
	}
	public int getQmno() {
		return qmno;
	}
	public void setQmno(int qmno) {
		this.qmno = qmno;
	}
	public int getRmno() {
		return rmno;
	}
	public void setRmno(int rmno) {
		this.rmno = rmno;
	}
	public int getFbno() {
		return fbno;
	}
	public void setFbno(int fbno) {
		this.fbno = fbno;
	}
	public int getQno() {
		return qno;
	}
	public void setQno(int qno) {
		this.qno = qno;
	}
	public int getQupno() {
		return qupno;
	}
	public void setQupno(int qupno) {
		this.qupno = qupno;
	}
	public int getFupno() {
		return fupno;
	}
	public void setFupno(int fupno) {
		this.fupno = fupno;
	}
	public int getRcno() {
		return rcno;
	}
	public void setRcno(int rcno) {
		this.rcno = rcno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPcno() {
		return pcno;
	}
	public void setPcno(int pcno) {
		this.pcno = pcno;
	}
	public int getLat() {
		return lat;
	}
	public void setLat(int lat) {
		this.lat = lat;
	}
	public int getPlong() {
		return plong;
	}
	public void setPlong(int plong) {
		this.plong = plong;
	}
	public String getFtitle() {
		return ftitle;
	}
	public void setFtitle(String ftitle) {
		this.ftitle = ftitle;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	public String getQbody() {
		return qbody;
	}
	public void setQbody(String qbody) {
		this.qbody = qbody;
	}
	public String getFbody() {
		return fbody;
	}
	public void setFbody(String fbody) {
		this.fbody = fbody;
	}
	public String getRbody() {
		return rbody;
	}
	public void setRbody(String rbody) {
		this.rbody = rbody;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public Date getQdate() {
		return qdate;
	}
	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}
	public Date getQedate() {
		return qedate;
	}
	public void setQedate(Date qedate) {
		this.qedate = qedate;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	public Date getFedate() {
		return fedate;
	}
	public void setFedate(Date fedate) {
		this.fedate = fedate;
	}
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public Date getRedate() {
		return redate;
	}
	public void setRedate(Date redate) {
		this.redate = redate;
	}
	public Time getQtime() {
		return qtime;
	}
	public void setQtime(Time qtime) {
		this.qtime = qtime;
	}
	public Time getQetime() {
		return qetime;
	}
	public void setQetime(Time qetime) {
		this.qetime = qetime;
	}
	public Time getFtime() {
		return ftime;
	}
	public void setFtime(Time ftime) {
		this.ftime = ftime;
	}
	public Time getFetime() {
		return fetime;
	}
	public void setFetime(Time fetime) {
		this.fetime = fetime;
	}
	public Time getRtime() {
		return rtime;
	}
	public void setRtime(Time rtime) {
		this.rtime = rtime;
	}
	public Time getRetime() {
		return retime;
	}
	public void setRetime(Time retime) {
		this.retime = retime;
	}
	
	public int getImageno() {
		return imageno;
	}
	public void setImageno(int imageno) {
		this.imageno = imageno;
	}
	
	public String getIsavename() {
		return isavename;
	}
	public void setIsavename(String isavename) {
		this.isavename = isavename;
	}
	@Override
	public String toString() {
		return "BoardVO [mno=" + mno + ", qmno=" + qmno + ", rmno=" + rmno + ", bno=" + bno + ", fbno=" + fbno
				+ ", qno=" + qno + ", upno=" + upno + ", qupno=" + qupno + ", fupno=" + fupno + ", rno=" + rno
				+ ", rcno=" + rcno + ", cno=" + cno + ", ano=" + ano + ", pno=" + pno + ", pcno=" + pcno + ", click="
				+ click + ", cnt=" + cnt + ", step=" + step + ", lat=" + lat + ", plong=" + plong + ", id=" + id
				+ ", title=" + title + ", ftitle=" + ftitle + ", qtitle=" + qtitle + ", rtitle=" + rtitle + ", body="
				+ body + ", qbody=" + qbody + ", fbody=" + fbody + ", rbody=" + rbody + ", sdate=" + sdate + ", stime="
				+ stime + ", sedate=" + sedate + ", setime=" + setime + ", avatar=" + avatar + ", score=" + score
				+ ", cname=" + cname + ", gname=" + gname + ", jname=" + jname + ", wdate=" + wdate + ", qdate=" + qdate
				+ ", qedate=" + qedate + ", fdate=" + fdate + ", fedate=" + fedate + ", rdate=" + rdate + ", redate="
				+ redate + ", wtime=" + wtime + ", qtime=" + qtime + ", qetime=" + qetime + ", ftime=" + ftime
				+ ", fetime=" + fetime + ", rtime=" + rtime + ", retime=" + retime + ", list=" + list + "]";
	}
	
	

}
