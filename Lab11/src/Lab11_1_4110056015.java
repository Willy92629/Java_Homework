
public class Lab11_1_4110056015 {

	public static void main(String[] args) {
		CCircle cir = new CCircle(8, 6, 2);
		cir.showData();
	}

}
interface iVolume{
	public void showData();
	public double vol();
}

abstract class CSphere implements iVolume{
	final double PI = 3.14;
	protected int x;
	protected int y;
}

class CCircle extends CSphere{
	int x;
	int y;
	int Rad;
	CCircle(int x ,int y,int r){
		this.x = x;
		this.y = y;
		Rad = r;
	}
	public void showData() {
		System.out.println("center:(" + x + "," + y + ")");
		System.out.println("radius:" + Rad);
		System.out.println("volume:" + vol());
	}
	public double vol() {
		return (4.0/3) * PI * Math.pow(Rad, 3);
	}
	
}