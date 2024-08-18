import java.util.Scanner;

public class HW2_4110056015 {
	
	public static int countDigitOccurrence (int n, int digit) {
		int count = 0;
		while(n != 0) {
			if(n % 10 == digit) {
				count++;
			}
			n/=10;
		}
				
		return(count);
	}

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		System.out.print("Enter numbers a <= b: ");
		int a = S.nextInt();
		int b = S.nextInt();
		int count = b - a +1;
		
		if(a <= b && a > 0 && b <= 10000) {}
		else {
			System.out.println("Invaild input");
			System.exit(0);
		}
	
		for(int i = a; i <= b; i++) {
			for(int j = 0; j <= 9; j++) {
				if(countDigitOccurrence(i,j) > 1) {
					count--;
					break;
				}
			}
		}
		
		System.out.println("There are " + count + " vaild numbers between " + a +" and " + b);
		S.close();
	}

}