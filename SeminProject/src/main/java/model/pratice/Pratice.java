package model.pratice;

public class Pratice {
	private int studno;
	private String DAY;
	private String activatename;
	private String content;
	private String emotion;
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public String getDAY() {
		return DAY;
	}
	public void setDAY(String dAY) {
		DAY = dAY;
	}
	public String getActivatename() {
		return activatename;
	}
	public void setActivatename(String activatename) {
		this.activatename = activatename;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	@Override
	public String toString() {
		return "Pratice [studno=" + studno + ", DAY=" + DAY + ", activatename=" + activatename + ", content=" + content
				+ ", emotion=" + emotion + "]";
	}
	
	
}
