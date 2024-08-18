
public class LAB13_1_4110056015 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Threads(1, 1000));
		Thread t2 = new Thread(new Threads(2, 2500));
		t1.start();
		t2.start();

	}

}

class Threads implements Runnable {
	int n = 0, mill = 1000;

	Threads(int n, int ms) {
		this.n = n;
		mill = ms;
	}

	public void run() // run() method
	{
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(mill);
			} catch (InterruptedException e) {

			}
			System.out.println("Thread " + n + " is running...");

		}
	}
}
