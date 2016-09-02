package ch11.exam05;

public class Employee {	//사원
	
	private int eno;
	
	public Employee(int eno){
		
		this.eno = eno;	//필드 초기화
		System.out.println("Employee(" + eno + ") 가 메모리에 생성됨.");
		
	}
	
	@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
		System.out.println("Employee(" + eno + ") 가 메모리에 제거됨.");
			
		}
	
	
	
}
