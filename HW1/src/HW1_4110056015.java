import java.util.Scanner;

public class HW1_4110056015 {

	public static void main(String[] args) {
		Scanner Sc = new Scanner(System.in);
		int Age,BirY,CurY=2022,Hei;
		String stname,ndname;
		float GR;
		
		System.out.print("First name: ");
		stname = Sc.next();
		System.out.print("Last name: ");
		ndname = Sc.next();
		System.out.print("Birth Year: ");
		BirY = Sc.nextInt();
		System.out.print("Height in cm: ");
		Hei = Sc.nextInt();
		
		Age = CurY - BirY;
		GR =(float)(Hei - 51)/Age;
		
		System.out.println("\nHello " + stname +" "+ ndname + ".");
		System.out.println("You are " + Age + " years old in " + CurY);
		System.out.println("Your height is " + Hei + " cm.");
		System.out.printf("You grew an average of %.3f cm per year (assuming you were 51 cm at birth).",GR);
		
		Sc.close();
		
		
	}

}
