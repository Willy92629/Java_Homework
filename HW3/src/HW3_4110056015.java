import java.util.Scanner;
public class HW3_4110056015 {

	public static void main(String[] args) {
		int digit = 10, code, gues = 0, temp , Gd = 0, bull, cow;
		int n = 1, r = 1; 
		int Crt[]= new int[9];
		Scanner Sc = new  Scanner(System.in);
		
		while(n == 1) { //detect the code whether it is valid
			System.out.print("Enter number of digits in code (3, 4 or 5): ");
			digit = Sc.nextInt();
			if(digit == 0 || digit == 3 || digit == 4 || digit == 5) {
				n = 0;
			}else {
				System.out.println("Invalid Input");
			}
		}
		
		n = 1;
		BullsAndCows Bnc = new BullsAndCows(digit);
		
		if(digit == 0) { //Cheat code or Normal mode
			System.out.print("Enter code:");
			code = Sc.nextInt();
			System.out.print("Enter number of digits in code: ");
			digit = Sc.nextInt();
			Bnc.CheatMode(code,digit);
		}else {
			code = Bnc.generate_code(digit);
		}
		
		Bnc.ITA(digit,code,Crt);
		System.out.print("Number to guess: ");
		for(int i =0 ; i<digit ; i++) {
			System.out.print(Crt[i]);
			if(i != digit-1)
				System.out.print("-");
		}
		System.out.print("\n");
		
		while(n == 1 ) {  //guessing the code
			while(r == 1) { //detect guess and whether it is valid
				System.out.print("Enter Guess: ");
				gues = Sc.nextInt();
				temp = gues;
				Gd = 0;
				while(temp != 0) { //Guess code digit
					Gd ++;
					temp/=10;
				}
				if(Gd > digit) {
					System.out.println("You can only enter "+ digit +" digits.↵");
				}else if(Bnc.Repeat(digit, gues)) {
					System.out.println("Each number must be different.");
				}else {
					r = 0 ;
				}
			}
			r = 1;
			bull = Bnc.Bulls(gues);
			cow = Bnc.Cows(gues);
			if(bull != digit) {
				System.out.println(bull + " bulls");
				System.out.println(cow + " cows");
			}else {
				System.out.print(digit + " bulls ... ");
				for(int i =0 ; i<digit ; i++) {
					System.out.print(Crt[i]);
					if(i != digit-1)
						System.out.print("-");
				}
				System.out.println(" is correct!");
				n = 0;
			}
		}
		Sc.close();
}
static class BullsAndCows { 
	int code = 0;
	int Rnd = 0;
	int RndC[]= new int[9];
	
	public BullsAndCows(int input) {
		code = input;
	}
	
	int generate_code(int num) { //when game in Normal mode, generate Random code
		int n = 1;
		while(n!=0) {
			n = 1;
			Rnd = (int)(Math.random()*Math.pow(10,num));
			if(!Repeat(num,Rnd))
				n = 0;
		}
		ITA(num,Rnd,RndC);
		return Rnd ;
	}
	void CheatMode(int num,int n) { 
		Rnd = num;
		code = n;
		ITA(code,Rnd,RndC);
	}
	boolean Repeat(int num, int gues) {
		int n = 0;
		int C[]= new int[9];
		ITA(num,gues,C);
		for(int i=0 ; i < num ; i++) {
			for(int j=0 ; j < i ; j++) {
				if(C[i] == C[j]) {
					n = 2;
					break;
				}
			}
		}
		return (n==2);
	}
	int Bulls(int gues) {
		int C[]= new int[9];
		int n = 0;
		ITA(code,gues,C);
		for(int i=0 ; i < code ; i++) {
			if(RndC[i] == C[i])
				n++;
		}
		return n;
	}
	int Cows(int gues) {
		int C[]= new int[9];
		int n = 0;
		ITA(code,gues,C);
		for(int i = 0 ; i < code ; i++) {
			for(int j = 0 ; j < code ; j++) {
				if(i==j)
					continue;
				if(RndC[i] == C[j]) 
					n++;
			}
		}
		return n;
	}
	void ITA(int digit, int num, int C[]) { //Integer to Array
		for(int i = digit-1 ; i >= 0 ; i--) {
			C[i] = num % 10;
			num/=10;
		}
	}
}
}