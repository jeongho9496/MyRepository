package ch09.exam11;


public class ButtonExample {
	//0901
	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setOnClickListener(new Button.OnClickListener() {	//익명클래스 생성자로 구현 객체 생성
			
			@Override
			public void onClick() {
				System.out.println("음악을 재생합니다.");
				
			}
		});
		btnOk.click();
		
		Button btnCancel = new Button();
		btnCancel.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("음악을 중지합니다.");
				
			}
		});
		btnCancel.click();

	}

}
