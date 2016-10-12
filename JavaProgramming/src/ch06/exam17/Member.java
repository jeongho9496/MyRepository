package ch06.exam17;

public class Member {
	//0829
	//대부분 필드는 private를 쓴다.
	//Field
	private String mid;
	private String mname;
	private String mpassword;
	private int mage;
	private boolean madult;
	private double mheight;	//public으로 사용할시 음수도 가능 하므로 음수작성을 안할수 있게 메소드를 만든다.
	
	
	//Constructor
	public Member(String mid){
		this.mid = mid;
	}	
	
	//Method
	public String getMname() {//getter -> 필드의 값을 외부에 제공
		return mname;
	}
	public void setMname(String mname) {//private 필드 값을 셋팅 할수 있다. 올바른 값을 가지기 위한 조건식을 적용 할수 있다.
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public int getMage() {
		return mage;
	}
	public void setMage(int mage) {
		this.mage = mage;
	}
	public boolean isMadult() {//boolean 타입의 메소드는 get~~ 아니라 is~~ 으로 시작한다.
		return madult;
	}
	public void setMadult(boolean madult) {
		this.madult = madult;
	}
	public double getMheight() {
		return mheight;
	}
	public void setMheight(double mheight) {
		this.mheight = mheight;
	}
	public String getMid() {
		return mid;
	}
	
	
}
