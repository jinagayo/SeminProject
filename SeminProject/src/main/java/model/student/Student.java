package model.student;

public class Student {
	private int studno;
	private String entry;
	private double tograde;
	private int grade;
	private int profno;
	private int mcode;
	private int semester;
	private double grade1;
	private double grade2;
	private double grade3;
	private double grade4;
	private double grade5;
	private double grade6;
	private double grade7;
	private double grade8;
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public double getTograde() {
		return tograde;
	}
	public void setTograde(double tograde) {
		this.tograde = tograde;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public int getMcode() {
		return mcode;
	}
	public void setMcode(int mcode) {
		this.mcode = mcode;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public double getGrade1() {
		return grade1;
	}
	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}
	public double getGrade2() {
		return grade2;
	}
	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}
	public double getGrade3() {
		return grade3;
	}
	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}
	public double getGrade4() {
		return grade4;
	}
	public void setGrade4(double grade4) {
		this.grade4 = grade4;
	}
	public double getGrade5() {
		return grade5;
	}
	public void setGrade5(double grade5) {
		this.grade5 = grade5;
	}
	public double getGrade6() {
		return grade6;
	}
	public void setGrade6(double grade6) {
		this.grade6 = grade6;
	}
	public double getGrade7() {
		return grade7;
	}
	public void setGrade7(double grade7) {
		this.grade7 = grade7;
	}
	public double getGrade8() {
		return grade8;
	}
	public void setGrade8(double grade8) {
		this.grade8 = grade8;
	}
	@Override
	public String toString() {
		return "Student [studno=" + studno + ", entry=" + entry + ", tograde=" + tograde + ", grade=" + grade
				+ ", profno=" + profno + ", mcode=" + mcode + ", semester=" + semester + ", grade1=" + grade1
				+ ", grade2=" + grade2 + ", grade3=" + grade3 + ", grade4=" + grade4 + ", grade5=" + grade5
				+ ", grade6=" + grade6 + ", grade7=" + grade7 + ", grade8=" + grade8 + "]";
	}
}
