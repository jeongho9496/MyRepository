package ch02.exam01; //�뙣�궎吏� �꽑�뼵 �뙣�궎吏� �씠由꾩� �쟾遺� �냼臾몄옄濡� �븯�뒗寃� 愿�濡�

public class VariableScope { // 泥リ��옄 ��臾몄옄 �몢 �떒�뼱 �빀移섎㈃ �떒�뼱�쓽 泥リ��옄�뒗 ��臾몄옄. File�씠由꾧낵 �겢�옒�뒪 �씠由꾩�
								// ���냼臾몄옄 �룷�븿 紐⑤몢 �씪移� �빐�빞 �븳�떎.
	public static void main(String[] args) {
		int var1 = 10;
		System.out.println("var1: " + var1); // '()' 愿꾪샇 �븞�뿉 ""�븞�뿉 �엳�뒗 �떒�뼱�뒗 異쒕젰 "" �뾾�뒗
												// 蹂��닔�뒗 蹂��닔�쓽 媛� 異쒕젰. '+' -> 寃고빀�떆�궎�뒗 �뿭�븷

		if (true) {
			int var2 = 15;
			System.out.println("var1: " + var1);
			System.out.println("var1: " + var2);

			if (true) {
				int var3 = 20;
				System.out.println("var1: " + var1);
				System.out.println("var1: " + var2);
				System.out.println("var1: " + var3);
			}
			System.out.println("var1: " + var1);
			System.out.println("var1: " + var2);
			// System.out.println("var1: " + var3); // 蹂��닔 �꽑�뼵�븳 釉붾줉�쓣 踰쀬뼱�궓
		}

		System.out.println("var1 : " + var1);
		System.out.println("test");
		// System.out.println("var1: " + var2); // 蹂��닔 �꽑�뼵�븳 釉붾줉�쓣 踰쀬뼱�궓

	}

}
