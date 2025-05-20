package model.major;

public class Major {
	private int mcode;
	private String mname;
	private int ccode;
	public void setCcode(int ccode) {
		this.ccode = ccode;
	}
	public int getCcode() {
		return ccode;
	}
	public int getMcode() {
		return mcode;
	}
	public void setMcode(int mcode) {
		this.mcode = mcode;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Major [mcode=" + mcode + ", mname=" + mname + "]";
	}
	
	
}
