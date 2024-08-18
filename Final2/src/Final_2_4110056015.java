
public class Final_2_4110056015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle(4); // Radius of 4
		Rectangle r = new Rectangle(4,3); // Height = 4,Width = 3
		ShowArea(c);
		ShowArea(r);
	}
	public static void ShowArea(Shape s)
	{
	double area = s.area();
	System.out.println("The area of the shape is " + area);
	}
}

interface Shape {
	public double area();
}

class Circle implements Shape{
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
	public double area() {
		return(Math.PI*radius*radius);
	}
}

class Rectangle implements Shape{
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
	public double area() {
		return (width * height);
	}
}
