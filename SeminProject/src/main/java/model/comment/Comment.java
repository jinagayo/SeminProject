package model.comment;

import java.util.Date;

public class Comment {
	private int seq;
	private int num2;
	private String writer;
	private String content;
	private Date regdate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Comment [seq=" + seq + ", num2=" + num2 + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + "]";
	}
	
	
}
