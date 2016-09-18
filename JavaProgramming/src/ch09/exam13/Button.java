package ch09.exam13;

public class Button {
	//0901
	//이벤트 처리 패턴
	public static interface OnClickListener{
		void onClick();	//추상 메소드
		
		static void onClick2() {
			System.out.println("------------------------");
			System.out.println("클릭");
		}//정적 메소드
		
	}	//중첩인터페이스 선언
	
	private OnClickListener onClickListener;	//인터페이스 타입 필드 선언
	
	public void setOnClickListener(OnClickListener onClickListener) {	//필드 값을 설정(저장)하는 setter메소드 선언
		this.onClickListener = onClickListener;							//외부값(매개변수)을 받아(자동 형변환) 필드에 설정
	}

	public void click(){	//외부값을 저장한 필드값이 인터페이스 타입 이므로 인터페이스 안에 있는 추상메소드를 호출 할수 있다.
		if (onClickListener != null) {			
			onClickListener.onClick();
			
			OnClickListener.onClick2();
		}
	}
	
}
