import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
	
	private JLabel Text2 = new JLabel("Pick two stations.");
	private JButton b7 = new JButton("Calc difference");
	private JButton b8 = new JButton("Calc sum");
	private JButton b9 = new JButton("Calc product");
	private JButton b10 = new JButton("Calc quotient");
	private JTextField outputText = new JTextField(4);
	
	public void playAudio(String name) {
		
		try 
		   {
		    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
		    Clip clip = AudioSystem.getClip();
		    clip.open(audioInputStream);
		    clip.start();
		   }
		   catch(Exception ex)
		   {
		     System.out.println("Error with playing sound.");
		     ex.printStackTrace( );
		   }
	}
	
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
		dropdown3.setEditable(false);
		
		JFrame mainWindow = new JFrame("Main window");
		
		mainWindow.setLayout(new GridLayout(2,2));
		
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(600,600);

		
		JPanel panel1 = new JPanel(new GridLayout(4,1));
		
		panel1.add(Text1);
		panel1.add(b1);
		panel1.add(b3);
		panel1.add(b5);
		
		
		JPanel panel2 = new JPanel(new GridLayout(4,1));
		
		panel2.add(dropdown3);
		panel2.add(b2);
		panel2.add(b4);
		panel2.add(b6);
		
		JPanel panel3 = new JPanel(new GridLayout(3,1));
		
		panel3.add(Text2);
		panel3.add(dropdown1);
		panel3.add(dropdown2);
		
		JPanel panel4 = new JPanel(new GridLayout(2,1));
		
		JPanel panel5 = new JPanel(new GridLayout(2,2));
		
		panel5.add(b7);
		panel5.add(b8);
		panel5.add(b9);
		panel5.add(b10);
		
		JPanel panel6 = new JPanel(new GridLayout(1,1));
		
		outputText.setEditable(false);
		panel6.add(outputText);
		
		panel4.add(panel5);
		panel4.add(panel6);
		
		mainWindow.add(panel1);
		mainWindow.add(panel2);
		mainWindow.add(panel3);
		mainWindow.add(panel4);
		
		
		b1.addActionListener((e) -> {
			this.playAudio("mg1.wav");
		});
		
		b2.addActionListener((e) -> {
			this.playAudio("idle1.wav");
		});
		
		b3.addActionListener((e) -> {
			this.playAudio("engine1.wav");
		});
		
		b4.addActionListener((e) -> {
			this.playAudio("engine2.wav");
		});
		
		b5.addActionListener((e) -> {
			this.playAudio("gun1.wav");
		});
		
		b6.addActionListener((e) -> {
			this.playAudio("gun2.wav");
		});
		
		
		b7.addActionListener((e) -> {
			String val1 = dropdown1.getSelectedItem().toString();
			outputText.setText(val1);
		});
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Soundboard_StationCalc a = new Soundboard_StationCalc();
		
		a.construct();
	}
}
