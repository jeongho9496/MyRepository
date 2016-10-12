package ch11.Test;

public class Student {
	private String studentNum;
	
	public Student(String studentNum){
		this.studentNum = studentNum;
	}
	
	public String getStudentNum(){
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student) {
			Student target = (Student)obj;
			if (studentNum.equals(target.getStudentNum())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return studentNum.hashCode();//동등객체가 된다.
	}
}
