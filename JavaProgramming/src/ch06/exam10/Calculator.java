package ch06.exam10;

public class Calculator {
	//0824
	//MethodOveloading
	//정사각형의 넓이
	double areaRectangle(double width){
		return width * width;
	}
	
	//직사각형의 넓이
	double areaRectangle(double width, double height){
		return width * height;
	}
}
