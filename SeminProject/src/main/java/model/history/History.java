package model.history;

public class History {
	private String year;
	private String subject;
	private int studno;
	private int grade;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "History [year=" + year + ", subject=" + subject + ", studno=" + studno + ", grade=" + grade + "]";
	}
	
	
}
