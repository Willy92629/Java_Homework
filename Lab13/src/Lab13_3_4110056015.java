import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Lab13_3_4110056015 extends JFrame implements ActionListener {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;

	private JLabel l1;
	private JTextField t1;
	private JButton b1;
	private Font fontObj;

	public static void main(String[] args) {
		Lab13_3_4110056015 gui = new Lab13_3_4110056015();
		gui.setVisible(true);
		
	}
	/**
	 * Sets dimensions to the frame, adds text field and a Preview
	 * button on click of which the text in the text field is shown in 3 different font styles.
	 */
	public Lab13_3_4110056015() {
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Font Box");
		getContentPane().setBackground(Color.WHITE);
		setLayout(new FlowLayout());

		add(l1 = new JLabel("Enter Text"));
		add(t1 = new JTextField(20));
		

		b1 = new JButton("Preview");
		b1.addActionListener(this);
		add(b1);
				
		
	}

	public void actionPerformed(ActionEvent e) {
		Graphics a = getGraphics();
		
		fontObj = new Font("TimesRoman", Font.PLAIN,10);
		a.setFont(fontObj);
		a.setColor(Color.black);
		a.drawString(t1.getText()+":Times New Roman,10", 45, 88);
		fontObj = new Font("Calibri", Font.BOLD,14);
		a.setFont(fontObj);
		a.setColor(Color.black);
		a.drawString(t1.getText()+":Calibri,14", 45, 120);
		fontObj = new Font("Arial", Font.ITALIC,18);
		a.setFont(fontObj);
		a.setColor(Color.black);
		a.drawString(t1.getText()+":Arial Italic,18\n", 45, 150);
		
	}
}
