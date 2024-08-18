import java.awt.*;
import javax.swing.*;
public class Lab12_1_4110056015 {

	public static void main(String[] args) {
		JFrame Window = new JFrame("Lab12_1");
		Container Con = Window.getContentPane();
		JLabel Ques = new JLabel();
		JRadioButton Bon1 = new JRadioButton("SpongeBob");
		JRadioButton Bon2 = new JRadioButton("Patrick");
		JRadioButton Bon3 = new JRadioButton("Squidwward");
		JRadioButton Bon4 = new JRadioButton("Mr. Krabs");
		JRadioButton Bon5 = new JRadioButton("Plankton");
		JRadioButton Bon6 = new JRadioButton("Sandy");
		Con.setSize(450,250);
		Ques.setText("Which is your favorite character in SpongeBob SquarePants?");
		
		ButtonGroup Bon = new ButtonGroup();
		Bon.add(Bon1);
		Bon.add(Bon2);
		Bon.add(Bon3);
		Bon.add(Bon4);
		Bon.add(Bon5);
		Bon.add(Bon6);
		Bon1.setSelected(true);
		
		Con.add(Ques);
		Con.add(Bon1);
		Con.add(Bon2);
		Con.add(Bon3);
		Con.add(Bon4);
		Con.add(Bon5);
		Con.add(Bon6);
		
		Ques.setBounds(0,0,400,20);
		Bon1.setBounds(20,40,140,20);
		Bon2.setBounds(20,60,140,20);
		Bon3.setBounds(20,80,140,20);
		Bon4.setBounds(20,100,140,20);
		Bon5.setBounds(20,120,140,20);
		Bon6.setBounds(20,140,140,20);
		
		Con.setBackground(Color.LIGHT_GRAY);
		Bon1.setBackground(Color.LIGHT_GRAY);
		Bon2.setBackground(Color.LIGHT_GRAY);
		Bon3.setBackground(Color.LIGHT_GRAY);
		Bon4.setBackground(Color.LIGHT_GRAY);
		Bon5.setBackground(Color.LIGHT_GRAY);
		Bon6.setBackground(Color.LIGHT_GRAY);
			
		Con.setLayout(null);
		Window.setSize(450,250);
		Window.setLocation(540, 300);
		Window.setVisible(true);
	}

}
