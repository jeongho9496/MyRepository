package ch11.exam01;

public class Board {
	//0902
	private int bno;
	private String title;
	private String content;
	
	public Board(int bno, String title, String content) {
//		super();	//object로 상속은 자동으로 되기때문에 extends 없이 super()가능 -> 즉 컴파일이 자동으로 되기 때문에 안써도 된다.?
		this.bno = bno;
		this.title = title;
		this.content = content;
	}
	
	public int getBno() {
		return bno;
	}
	
	@Override
	public boolean equals(Object obj) {	//들어오는 매개변수는 .equals의 우항 값이다.
		// TODO Auto-generated method stub
		if (obj instanceof Board) {	//매개변수로 들어오는 클래스가 Board타입인지 확인
			Board target = (Board) obj;
			if (bno == target.getBno()) {	//bno은 외부에서 참조할수 없는 private이므로 문법상 getBno 메소드를 통해 외부에서 호출해야 한다.
				return true;
			}
		}
		return false;
	}
	
	
}
