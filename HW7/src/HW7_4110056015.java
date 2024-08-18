import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

class Display extends Thread {
	static Frame f;

	public void run() // run() method
	{
		while (true) {
			f.repaint();

			// Code here ...
			try {
				sleep(50);
			} catch (InterruptedException e) {

			}
		}
	}
}

class Ball extends Thread {
	int id;
	int x, y, dir, d, size, clr, slp;
	static int width=HW7_4110056015.WIDTH, height=HW7_4110056015.HEIGHT;
	static Frame f;
	static Color CC[] = { Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray,
			Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

	public Ball(int n) {
		id = n; // Ball ID
		size = (int) (Math.random() * 5 + 5) * 10; // Ball size
		x = (int) (Math.random() * (width - HW7_4110056015.inLeft - size)) + HW7_4110056015.inLeft; // Horizontal
																									// coordinate
		y = (int) (Math.random() * (height - HW7_4110056015.inTop - size)) + HW7_4110056015.inTop; // Vertical
																									// coordinate
		dir = (int) (Math.random() * 8); // Eight directions
		d = (int) (Math.random() * 5) + 1; // Displacement
		clr = n % CC.length; // Color index
		slp = (int) (Math.random() * 10) * 10 + 10; // The seed for the sleep function
	}

	public void run() { // run() method
		while (true) {
			System.out.println("Ball(" + id + ") [" + x + "," + y + "] [" + size + "] is running ...");

			// Code here ...

			try {
				sleep(slp);
				switch (dir) {
				case 0:
					y -= d;
					break;
				case 1:
					x += d;
					y -= d;
					break;
				case 2:
					x += d;
					break;
				case 3:
					x += d;
					y += d;
					break;
				case 4:
					y += d;
					break;
				case 5:
					x -= d;
					y += d;
					break;
				case 6:
					x -= d;
					break;
				case 7:
					x -= d;
					y -= d;
					break;
				}
				if (x > width - d - size) {
					switch (dir) {
					case 1:
						dir = 7;
						break;
					case 2:
						dir = 6;
						break;
					case 3:
						dir = 5;
						break;

					}
				}
				if (x < d) {
					switch (dir) {
					case 5:
						dir = 3;
						break;
					case 6:
						dir = 2;
						break;
					case 7:
						dir = 1;
						break;

					}
				}
				if (y > height - d - size) {
					switch (dir) {
					case 3:
						dir = 1;
						break;
					case 4:
						dir = 0;
						break;
					case 5:
						dir = 7;
						break;
					}
				}
				if (y < d + 22) {
					switch (dir) {
					case 7:
						dir = 5;
						break;
					case 0:
						dir = 4;
						break;
					case 1:
						dir = 3;
						break;
					}
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}

	// Draw the ball
	public void draw(Graphics g) {

		//Code here ...
		g.setColor(CC[clr]);
		g.fillOval(x, y, size, size);

	}
}

@SuppressWarnings("serial")
public class HW7_4110056015 extends Frame {
	static HW7_4110056015 frm = new HW7_4110056015();
	static Ball[] balls;
	static Display dis = new Display();
	static int inTop=8, inLeft=8; // The bottom and left boundaries
	final static int WIDTH = 400, HEIGHT = 300;
	boolean sf = false;
	static int n;

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		while (true) {
			Scanner scr = new Scanner(System.in);
			System.out.print("Please enter the number of moving balls: ");

			// Code here ...
			try {
				n = scr.nextInt();
				if (n <= 0) {
					System.out.println("[ERROR]: The input number must be greater than 0!");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("[ERROR]: The input type must be integer!");
				continue;
			}

			break;
		}
		balls = new Ball[n];

		frm.setTitle("Moving Balls");
		frm.setSize(WIDTH, HEIGHT);
		frm.setVisible(true);

		// Set the AWT window will close by the "close" button
		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Code here ...

		Display.f = frm;

		for (int i = 0; i < balls.length; i++) {
			balls[i] = new Ball(i);
			balls[i].setPriority(1);
			balls[i].start();
		}
		dis.start();
	}

	public void paint(Graphics g) {

		// Code here ...
		for (int i = 0; i < balls.length; i++) {
			g.setColor(Ball.CC[balls[i].clr]);
			g.fillOval(balls[i].x, balls[i].y, balls[i].size, balls[i].size);
		}

	}
}
