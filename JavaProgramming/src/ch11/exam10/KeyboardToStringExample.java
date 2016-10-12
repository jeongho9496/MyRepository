package ch11.exam10;

import java.io.IOException;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class KeyboardToStringExample {
	//0905	p498
	public static void main(String[] args) throws IOException {
		
		byte[] bytes = new byte[100];
		
		System.out.print("입력 : ");
		int readByteNo = System.in.read(bytes);//읽은 바이트수 리턴
		String str = new String(bytes, 0, readByteNo-2);//Enter처리한 2byte삭제
		System.out.println(str);
	}

}
