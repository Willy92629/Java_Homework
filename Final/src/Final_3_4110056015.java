
public class Final_3_4110056015 {
	public static void main(String[] args) {
		char[] Sharp = new char[9];
		char token ='¢Ý';
		int win=3,exit = 0;
		int Whof=(int)(Math.random()*2),FP=Whof;
		
		for(int i=0; i<9;i++)
			Sharp[i] = '¡@';
		if(FP==1) {
			Sharp[((int)(Math.random()*9))]='¢æ';
			FP++;
		}
		for(int p=0;p<9;p++) {
			if(FP%2==0) 
				token='¢Ý';
			else
				token='¢æ';
			
			while(true) {
				int i=((int)(Math.random()*9));
				if(Sharp[i] == '¡@') {
					Sharp[i] = token;
					break;
				}
			}
			for(int i=0;i<3;i++) {
				if(Sharp[3*i]!='¡@') {
					if(Sharp[3*i]==Sharp[3*i+1]&&Sharp[3*i+1]==Sharp[3*i+2]) {
						exit=1;
						break;
					}
				}
			}
			for(int i=0;i<3;i++) {
				if(Sharp[i]!='¡@') {	
					if(Sharp[i]==Sharp[i+3]&&Sharp[i+3]==Sharp[i+6]) {
						exit=1;
						break;
					}
				}
			}
			if(Sharp[4]!='¡@') {
				if((Sharp[0]==Sharp[4]&&Sharp[4]==Sharp[8])||(Sharp[2]==Sharp[4]&&Sharp[4]==Sharp[6])) {
					exit=1;
				}
			}
			
			if(exit==1) {
				win=FP%2;
				break;
			}
			if((Whof==0&&p==8)||(Whof==1&&p==7)) 
				break;
			FP++;
		}
		
		for(int i=0;i<3;i++) {
			System.out.print("|");
			for(int j=0;j<3;j++) {
				System.out.print(Sharp[3*i+j]);
				System.out.print("|");
			}
			System.out.println("");
		}
		if(win==0) {
			System.out.println("(¢Ý)Win!");
		}else if(win==1) {
			System.out.println("(¢æ)Win!");
		}else {
			System.out.println("Tie Game!");
		}
	}
}
