package ch11.exam04;

public class ExitExample2 {
	// 0902
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager(){
			@Override
			public void checkExit(int status) {	//exit() 에소드 호출 확인
				if (status != 5) {
					throw new SecurityException();					
				}
				System.out.println("나 죽네");
			}
			
		});	//익명 객체 생성
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				
				System.exit(i); // 프로세스를 멈추어라
			} catch (SecurityException e) {
				// TODO: handle exception
				
			}
		}

		System.out.println("출력");
	}

	public static void method(int x) {
		if (x == 5) {
			return;
		}
		System.out.println(x);
	}
}
