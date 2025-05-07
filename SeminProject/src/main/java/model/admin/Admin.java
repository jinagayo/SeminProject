package model.admin;

public class Admin {
	private int admno;

	public int getAdmno() {
		return admno;
	}

	public void setAdmno(int admno) {
		this.admno = admno;
	}

	@Override
	public String toString() {
		return "Admin [admno=" + admno + "]";
	}
	
}
