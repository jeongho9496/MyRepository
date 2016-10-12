package ch11.exam03;

public class SmartPhone {
//0902
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		// TODO Auto-generated constructor stub
		this.company = company;
		this.os = os;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return company + ", " + os;
		}
}
