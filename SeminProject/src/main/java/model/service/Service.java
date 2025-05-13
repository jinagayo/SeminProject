package model.service;

public class Service {
	int studno;
	String day;
	String servicename;
	String groupname;
	int time;
	String content;
	String emotion;
	public int getStudno() {
		return studno;
	}
	public String getDay() {
		return day;
	}
	public String getServicename() {
		return servicename;
	}
	public String getGroupname() {
		return groupname;
	}
	public int getTime() {
		return time;
	}
	public String getContent() {
		return content;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	@Override
	public String toString() {
		return "Service [studno=" + studno + ", day=" + day + ", servicename=" + servicename + ", groupname="
				+ groupname + ", time=" + time + ", content=" + content + ", emotion=" + emotion + "]";
	}
	
	
}
