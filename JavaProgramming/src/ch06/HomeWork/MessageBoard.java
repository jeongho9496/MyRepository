package ch06.HomeWork;

public class MessageBoard {

	//Field
		int no;
		String title;
		String text;
		String name;
		int count;
		
		//Constructor
		MessageBoard(){}
		MessageBoard(int no, String title,String text, String name){
			this.no = no;
			this.title = title;
			this.text = text;
			this.name = name;
		}
		MessageBoard(int no, String title,String text, String name, int count){
			this.no = no;
			this.title = title;
			this.text = text;
			this.name = name;
			this.count = count;
		}
}
