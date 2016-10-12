package ch06.exam14;

public class Earth {
	//0829
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
	static {
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS ;
	}
	
	public static void main(String[] args) {
		System.out.println("지구 반지름 -> "+Earth.EARTH_RADIUS +"km");
		System.out.println("지구 반지름 -> "+Earth.EARTH_SURFACE_AREA + "km^2");
		
//		Earth.EARTH_RADIUS = 3400; -> final값 수정 불가
		
	}
}
