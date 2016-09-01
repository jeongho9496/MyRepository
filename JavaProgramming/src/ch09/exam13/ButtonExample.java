package ch09.exam13;


public class ButtonExample {
	public static void main(String[] args) {
		Button btnOk = new Button();
		
		final int value = 10;	//메소드내에 선언되는 필드는 final이 되야한다.
		
		btnOk.setOnClickListener(new Button.OnClickListener() {	//익명클래스 생성자로 구현 객체 생성 메인 메소드에 생성된 로컬 클래스 
			
			@Override
			public void onClick() {
				System.out.println(value+"번 음악을 재생합니다.");	//메소드에 선언된 필드는 읽기만 가능하다.
				
			}
		});
		btnOk.click();

	}

}
