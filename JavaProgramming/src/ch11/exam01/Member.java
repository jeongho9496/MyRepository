package ch11.exam01;

public class Member {
	//0902
	public String id;
	public Member(String id) {
		// TODO Auto-generated constructor stub
		this.id = id;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		if (obj instanceof Member) {
			Member member = (Member)obj;
			if (id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}

}
