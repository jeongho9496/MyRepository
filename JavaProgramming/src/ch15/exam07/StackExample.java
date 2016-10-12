package ch15.exam07;

import java.util.Stack;

public class StackExample {
	//0920
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Coin> stack = new Stack<>();//마지막에 들어온 객체부터 처리
		
		stack.push(new Coin(100));
		stack.push(new Coin(500));
		stack.push(new Coin(50));
		
		while (!stack.isEmpty()) {
			Coin coin = stack.pop();
			System.out.println(coin.getValue() + "원");
		}
	}

}
