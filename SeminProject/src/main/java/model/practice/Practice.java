package model.practice;

public class Practice {
	int studno;
	String activename;
	String content;
	String emotion;
	String file1;
	String day;
	public void setDay(String day) {
		this.day = day;
	}
	public String getDay() {
		return day;
	}
	public int getStudno() {
		return studno;
	}
	public String getActivename() {
		return activename;
	}
	public String getContent() {
		return content;
	}
	public String getEmotion() {
		return emotion;
	}
	public String getFile1() {
		return file1;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public void setActivename(String activename) {
		this.activename = activename;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	@Override
	public String toString() {
		return "Practice [studno=" + studno + ", activename=" + activename + ", content=" + content + ", emotion="
				+ emotion + "]";
	}
	
	
}

