package ch11.exam11;

public class Board implements Comparable{
	//java.lang.Comparable -> compareTo메소드에 return값을 따라 정렬할수 있는 기준을 전달
	//0906
	private int bno;
	private String title;
	
	public Board(int bno, String title) {
		this.bno = bno;
		this.title = title;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return bno+" : "+title;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Board target = (Board)o;
		return target.bno - bno;
		//결과 값이 양수이면 해당 객체의 위치가 내려간다
	}
}
