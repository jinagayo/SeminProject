package model.professor;

public class Professor {
	private int profno;
	private String sub;
	private int mcode;
	public int getProfno() {
		return profno;
	}
	public void setProfno(int profno) {
		this.profno = profno;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public int getMcode() {
		return mcode;
	}
	public void setMcode(int mcode) {
		this.mcode = mcode;
	}
	@Override
	public String toString() {
		return "Professor [profno=" + profno + ", sub=" + sub + ", mcode=" + mcode + "]";
	}
	
	
}
