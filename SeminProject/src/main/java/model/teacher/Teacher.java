package model.teacher;

public class Teacher {
	private int studno;
	private boolean practice;
	private  boolean personsubmit;
	private int service ;
	private boolean teacherYN;
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public boolean isPractice() {
		return practice;
	}
	public void setPractice(boolean practice) {
		this.practice = practice;
	}
	public boolean isPersonsubmit() {
		return personsubmit;
	}
	public void setPersonsubmit(boolean personsubmit) {
		this.personsubmit = personsubmit;
	}
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}
	public boolean isTeacherYN() {
		return teacherYN;
	}
	public void setTeacherYN(boolean teacherYN) {
		this.teacherYN = teacherYN;
	}
	@Override
	public String toString() {
		return "Teacher [studno=" + studno + ", practice=" + practice + ", personsubmit=" + personsubmit + ", service="
				+ service + ", teacherYN=" + teacherYN + "]";
	}

	
	
	
}
