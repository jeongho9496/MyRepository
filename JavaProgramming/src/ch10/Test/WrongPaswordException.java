package ch10.Test;

public class WrongPaswordException extends Exception {
	public WrongPaswordException(){}
	public WrongPaswordException(String message){
		System.out.println("비밀번호가 일치 하지 않습니다.");
	}
	

}
