import java.io.*;
import java.util.Scanner;
public class Lab10_3_4110056015 {

	public static void main(String[] args) {
		double max =0 ,min=100,tmp=0;
		try {
			Scanner sc = new Scanner(System.in);
			FileOutputStream Fo = new FileOutputStream("stutent.txt");
			FileInputStream Fi = new FileInputStream("stutent.txt");
			DataOutputStream Out = new DataOutputStream(Fo);
			DataInputStream In = new DataInputStream(Fi);
			
			for(int i=1;i<=8;i++) {
				System.out.print("Input grade of student " +i +" :");
				tmp = sc.nextDouble();
				Out.writeDouble(tmp);
			}
			System.out.println("Grades are written to the file student.txt");
			System.out.println("Reading grades form the file");
			for(int i=0;i<8;i++) {
				tmp = In.readDouble();
				if(tmp> max)
					max = tmp;
				if(tmp< min)
					min = tmp;
			}
			System.out.println("Highest grade is :" + max);
			System.out.println("Lowest Grade is :" + min);
			System.out.println("End of the program.");
			sc.close();
			Fo.close();
			Fi.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
