package ch09.exam09;

public class ButtonExample {
	//0901
	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setOnClickListener(new OkListener());
		btnOk.click();
		
		Button btnCancel = new Button();
		btnCancel.setOnClickListener(new CancelListener());
		btnCancel.click();

	}

}

class OkListener implements Button.OnClickListener {	//OnClickListener을 구현한 객체가 됨.

	@Override
	public void onClick() {	//OnClickListener의 안에 있는 onClick 추상 메소드 재정의
		System.out.println("ok버튼이 눌렸습니다.");
	}

}
class CancelListener implements Button.OnClickListener {	//OnClickListener을 구현한 객체가 됨.
	
	@Override
	public void onClick() {
		System.out.println("Cancel버튼이 눌렸습니다.");
	}
	
}
