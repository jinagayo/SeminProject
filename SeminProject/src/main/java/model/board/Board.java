package model.board;

import java.util.Date;

public class Board {
	private int num;
	private String boardid;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int subcode;
	private String file1;
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public String getFile1() {
		return file1;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBoardid() {
		return boardid;
	}
	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", boardid=" + boardid + ", title=" + title + ", writer=" + writer + ", content="
				+ content + ", regdate=" + regdate + ", subcode=" + subcode + "]";
	}
	
	
}
