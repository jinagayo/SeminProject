package model.attendance;

public class Attendance {
	private int subcode;
	private int studno;
	private int late;
	private int absent;
	private String grade;
	public int getSubcode() {
		return subcode;
	}
	public void setSubcode(int subcode) {
		this.subcode = subcode;
	}
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Attendance [subcode=" + subcode + ", studno=" + studno + ", late=" + late + ", absent=" + absent
				+ ", grade=" + grade + "]";
	}
	
	
}
