package model.graduation;

public class Graduation {
	private int studno;
	private int comcredit;
	private int teachcredit;
	private boolean graduation;
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public int getComcredit() {
		return comcredit;
	}
	public void setComcredit(int comcredit) {
		this.comcredit = comcredit;
	}
	public int getTeachcredit() {
		return teachcredit;
	}
	public void setTeachcredit(int teachcredit) {
		this.teachcredit = teachcredit;
	}
	public boolean isGraduation() {
		return graduation;
	}
	public void setGraduation(boolean graduation) {
		this.graduation = graduation;
	}
	@Override
	public String toString() {
		return "Graduation [studno=" + studno + ", comcredit=" + comcredit + ", teachcredit=" + teachcredit
				+ ", graduation=" + graduation + "]";
	}
	
	
	
}
