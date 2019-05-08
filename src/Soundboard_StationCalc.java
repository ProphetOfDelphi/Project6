import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Soundboard_StationCalc {

	private JLabel Text1 = new JLabel("Pick the sound you would like to hear.");
	private JButton b1 = new JButton("Coaxial");
	private JButton b2 = new JButton("Idle Engine");
	private JButton b3 = new JButton("Engine Rev, Interior");
	private JButton b4 = new JButton("Engine Rev, Exterior");
	private JButton b5 = new JButton("Main Gun, Interior");
	private JButton b6 = new JButton("Target Destroyed");
	
	private JButton b7 = new JButton("Calc difference");
	private JButton b8 = new JButton("Calc sum");
	private JButton b9 = new JButton("Calc product");
	private JButton b10 = new JButton("Calc quotient");
	
	public void construct() throws FileNotFoundException {
		ArrayList<String> list = new ArrayList<String>(1000);
		File stuff = new File("Mesonet.txt");
		Scanner scnr = new Scanner(stuff);
		
		while(scnr.hasNext() == true) {
			list.add(scnr.nextLine());
		}
		Object[] list2 = list.toArray();
		
		JComboBox<String> dropdown1 = new JComboBox<String>();
		JComboBox<String> dropdown2 = new JComboBox<String>();
		JComboBox<String> dropdown3 = new JComboBox<String>();
		
		for (int x = 0; x < list.size(); ++x) {
			dropdown1.addItem(list.get(x));
			dropdown2.addItem(list.get(x));
		}
		dropdown1.setEditable(false);
		dropdown2.setEditable(false);
		
		dropdown3.addItem("T-64A");
		
		JFrame mainWindow = new JFrame("Main window");
		
		mainWindow.setLayout(new GridLayout(2,2));
		
		mainWindow.setVisible(true);
		
		JPanel panel1 = new JPanel(new GridLayout(4,1));
		
		panel1.add(Text1);
		panel1.add(b1);
		panel1.add(b3);
		panel1.add(b5);
		
		mainWindow.add(panel1);
		
		
		
		
		
	}
}
