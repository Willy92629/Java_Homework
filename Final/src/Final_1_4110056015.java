
public class Final_1_4110056015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle C = new Circle(1.5);
		Triangle T =new Triangle(10.5,9);
		Rectangle R = new Rectangle(1.5,3);
		
		System.out.println("Constructor and Get Function Test");
		System.out.println("C Radius:"+C.getRadius());
		System.out.println("T Height:"+T.getHeight()+" Base:"+T.getBase());
		System.out.println("R Height:"+R.getHeight()+" Width:"+R.getWidth());
		System.out.println("");
		
		System.out.println("Set Test");
		C.setRadius(1);
		T.setHeight(4);
		T.setBase(6);
		R.setHeight(2);
		R.setWidth(8.5);
		System.out.println("C Radius:"+C.getRadius());
		System.out.println("T Height:"+T.getHeight()+" Base:"+T.getBase());
		System.out.println("R Height:"+R.getHeight()+" Width:"+R.getWidth());
		System.out.println("");
		
		System.out.println("Circumference and Area Test");
		System.out.println("C A:"+C.calculateArea()+" Cir:"+C.calculateCircumference());
		System.out.println("T A:"+T.calculateArea()+" Cir:"+T.calculateCircumference());
		System.out.println("R A:"+R.calculateArea()+" Cir:"+R.calculateCircumference());
		System.out.println("");
	}

}
abstract class Shape{
	int x=0,y=0;
	Shape(){
	}
	public double calculateArea() {
		return 0;
	}
	
	public double calculateCircumference() {
		return 0;
	}
}
class Circle extends Shape {
	public double radius;
	Circle(double a){
		radius = a;
	}
	public double getRadius() {
		return radius;
	}
	void setRadius(double a) {
		radius = a;
	}
	public double calculateArea() {
		return(Math.PI*radius*radius);
	}
	public double calculateCircumference() {
		return(Math.PI*2.0*radius);
	}
}

class Rectangle extends Shape {
	public double height,width;
	Rectangle(double h,double w){
		height = h;
		width = w;
	}
	public double getHeight() {
		return height;
	}
	public double getWidth() {
		return width;
	}
	void setHeight(double h) {
		height = h;
	}
	void setWidth(double w) {
		width = w;
	}
	public double calculateArea() {
		return (height*width);
	}
	public double calculateCircumference() {
		return(2.0*(height+width));
	}
}

class Triangle extends Shape {
	public double height,base;
	Triangle(double h,double b){
		height = h;
		base = b;
	}
	public double getHeight() {
		return height;
	}
	public double getBase() {
		return base;
	}
	void setHeight(double h) {
		height = h;
	}
	void setBase(double b) {
		base = b;
	}
	public double calculateArea() {
		return (height*base/2.0);
	}
	public double calculateCircumference() {
		return (2.0*Math.sqrt((1/2.0)*base*(1/2.0)*base+height*height)+base);
	}
}