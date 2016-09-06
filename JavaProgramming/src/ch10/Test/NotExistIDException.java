package ch10.Test;

public class NotExistIDException extends Exception {
	public NotExistIDException(){}
	public NotExistIDException(String message){
		System.out.println("id가 일치하지 않습니다.");
	}
	

}
