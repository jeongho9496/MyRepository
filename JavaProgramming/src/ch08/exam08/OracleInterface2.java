package ch08.exam08;

public interface OracleInterface2 extends OracleInterface {
	// 0831
	@Override
	default void method1() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	default void method2() {
		// TODO Auto-generated method stub
		OracleInterface.super.method2();
	}

}
