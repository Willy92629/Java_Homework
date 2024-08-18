import java.util.Scanner;
public class Lab13_2_4110056015 {
	public static void main(String[] args) {
		Buzzer bz = new Buzzer();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter time delay for the Buzzer :");
		int timeDelay = keyboard.nextInt();
		System.out.print("Enter no of repetition : ");
		int no = keyboard.nextInt();
		bz.setBuzzerTime(timeDelay, no);
		bz.blowBuzzer();
	}
}

/**
 * 
 * Interface that provides methods to set the buzzer time and blow the
 * buzzer
 */
interface MonitorTime {
	//code here
	void setBuzzerTime(int bTime, int no);
}

/**
 * Buzzer class that uses a thread and MonitorTime interface to start
 * the buzzer and blow the buzzer at the interval set by the user.
 * 
 */
class Buzzer extends Thread implements MonitorTime {
	private int buzzerTime;
	private int noOfTimes;

	@Override
	public void run() {
		//code here
		for(int i =0;i<noOfTimes;i++) {
			doNothing(buzzerTime);
			System.out.println("!!!! Buzzer !!!!");
		}
	}

	public void setBuzzerTime(int bTime, int no) {
		//code here
		buzzerTime =bTime;
		noOfTimes = no;
	}

	public void blowBuzzer() {
		//code here
		run();
	}

	public void doNothing(int milliseconds) {
		//code here
		try{
			sleep(milliseconds);
		}catch(InterruptedException e) {
			
		}
	}
}
