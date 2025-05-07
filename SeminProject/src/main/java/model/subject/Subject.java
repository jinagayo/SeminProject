package model.subject;

public class Subject {
	private int subcode;
	private String subname;
	private int time;
	private int starttime;
	private int day;
	private String location;
	private int profno;
	private boolean teachsub;
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getStarttime() {
		return starttime;
	}
	public void setStarttime(int starttime) {
		this.starttime = starttime;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public boolean isTeachsub() {
		return teachsub;
	}
	public void setTeachsub(boolean teachsub) {
		this.teachsub = teachsub;
	}
	@Override
	public String toString() {
		return "Subject [subcode=" + subcode + ", subname=" + subname + ", time=" + time + ", starttime=" + starttime
				+ ", day=" + day + ", location=" + location + ", profno=" + profno + ", teachsub=" + teachsub + "]";
	}
	
	
}
