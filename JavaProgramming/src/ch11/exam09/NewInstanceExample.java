package ch11.exam09;

public class NewInstanceExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		final String ADDRESS = "ch11.exam09.";
		 
		Class clazz = Class.forName(ADDRESS+args[0]);
		
		Object obj = clazz.newInstance(); // 기본 생성자로 객체 만듬
		Action action = (Action) obj;

		action.excute();	//SendAction, ReceiveAction의 excute실행 다형성이 성립

	}

}
