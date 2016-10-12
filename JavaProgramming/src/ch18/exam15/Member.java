package ch18.exam15;

import java.io.Serializable;

public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7614355132400340926L;//UID 명시적 기입하여 클래스의 필드가 변경되어도 파일에 있는 데이터를 복원 할수 있게 한다.
	//0922
	private String mid;
	private String mname;
	private static String nation = "한국";
	private transient String mpassword;	//저장이 안됨
	private int mage;
	private String job;
	
	public Member(String mid, String mname, String mpassword, int mage) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpassword = mpassword;
		this.mage = mage;
	}
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
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
	public static String getNation() {
		return nation;
	}

	public static void setNation(String nation) {
		Member.nation = nation;
	}


	
	
}
