package model.teacher;

public class Teacher {
	private int studno;
	private boolean pracice;
	private  boolean personsubmit;
	private int service ;
	private boolean teacherYN;
	public int getStudno() {
		return studno;
	}
	public boolean isPracice() {
		return pracice;
	}
	public boolean isPersonsubmit() {
		return personsubmit;
	}
	public int getService() {
		return service;
	}
	public boolean isTeacherYN() {
		return teacherYN;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public void setPracice(boolean pracice) {
		this.pracice = pracice;
	}
	public void setPersonsubmit(boolean personsubmit) {
		this.personsubmit = personsubmit;
	}
	public void setService(int service) {
		this.service = service;
	}
	public void setTeacherYN(boolean teacherYN) {
		this.teacherYN = teacherYN;
	}
	@Override
	public String toString() {
		return "Teacher [studno=" + studno + ", pracice=" + pracice + ", personsubmit=" + personsubmit + ", service="
				+ service + ", teacherYN=" + teacherYN + "]";
	}
	
	
}
