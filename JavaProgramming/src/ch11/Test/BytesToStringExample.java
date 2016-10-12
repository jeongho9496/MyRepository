package ch11.Test;

import java.io.UnsupportedEncodingException;

public class BytesToStringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		byte[] bytes = {73,32,108,111,118,101,32,121,111,117};
		String str = new String(bytes, "UTF-8");
		System.out.println(str);
	}
}
