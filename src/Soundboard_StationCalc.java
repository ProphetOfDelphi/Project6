import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	public void playAudio(String name)  {
		
		try 
		   {
		    AudioInputStream sound = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile());
		    Clip clip = AudioSystem.getClip();
		    clip.open(sound);
		    clip.start();
		   }
		   catch(Exception ex)
		   {
			   this.playAudio("error.wav");
		   }
	}
	
	public void setVisuals(String name) throws IOException {
		
		if (name.equalsIgnoreCase("T-64A")) {
			File img = new File("t64.png");
			BufferedImage image = ImageIO.read(img);
			ImageIcon picture = new ImageIcon(image);
			b1.setIcon(picture);
			b2.setIcon(picture);
			b3.setIcon(picture);
			b4.setIcon(picture);
			b5.setIcon(picture);
			b6.setIcon(picture);
		}
		else {
			File img = new File("t2.png");
			BufferedImage image = ImageIO.read(img);
			ImageIcon picture = new ImageIcon(image);
			b1.setIcon(picture);
			b2.setIcon(picture);
			b3.setIcon(picture);
			b4.setIcon(picture);
			b5.setIcon(picture);
			b6.setIcon(picture);
		}
	}
	
	
	public void construct() throws IOException {
		ArrayList<String> list = new ArrayList<String>(1000);
		File stuff = new File("Mesonet.txt");
		Scanner scnr = new Scanner(stuff);
		
		while(scnr.hasNext() == true) {
			list.add(scnr.nextLine());
		}
		
		JComboBox<String> dropdown1 = new JComboBox<String>();
		JComboBox<String> dropdown2 = new JComboBox<String>();
		JComboBox<String> dropdown3 = new JComboBox<String>();
		
		for (int x = 0; x < list.size(); ++x) {
			dropdown1.addItem(list.get(x));
			dropdown2.addItem(list.get(x));
		}
		dropdown1.setEditable(false);
		dropdown2.setEditable(false);
		
		File img = new File("t64.png");
		BufferedImage image = ImageIO.read(img);
		ImageIcon picture = new ImageIcon(image);
		b1.setIcon(picture);
		b2.setIcon(picture);
		b3.setIcon(picture);
		b4.setIcon(picture);
		b5.setIcon(picture);
		b6.setIcon(picture);
		
		dropdown3.addItem("T-64A");
		dropdown3.addItem("Tiger II Sla. 16");
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
		
		dropdown3.addActionListener((e) -> {
			try {
				this.setVisuals(dropdown3.getSelectedItem().toString());
			} catch (IOException e1) {
				System.out.println("Error with loading visuals.");
			}
		});
		
		b1.addActionListener((e) -> {
			if (dropdown3.getSelectedItem().toString().equalsIgnoreCase("T-64A")) {
				this.playAudio("mg1.wav");
			}
			else {
				this.playAudio("mg2.wav");
			}
		});
		
		b2.addActionListener((e) -> {
			if (dropdown3.getSelectedItem().toString().equalsIgnoreCase("T-64A")) {
				this.playAudio("idle1.wav");
			}
			else {
				this.playAudio("idle2.wav");
			}
		});
		
		b3.addActionListener((e) -> {
			if (dropdown3.getSelectedItem().toString().equalsIgnoreCase("T-64A")) {
				this.playAudio("engine1.wav");
			}
			else {
				this.playAudio("engine3.wav");
			}
		});
		
		b4.addActionListener((e) -> {
			if (dropdown3.getSelectedItem().toString().equalsIgnoreCase("T-64A")) {
				this.playAudio("engine2.wav");
			}
			else {
				this.playAudio("engine4.wav");
			}
		});
		
		b5.addActionListener((e) -> {
			if (dropdown3.getSelectedItem().toString().equalsIgnoreCase("T-64A")) {
				this.playAudio("gun1.wav");
			}
			else {
				this.playAudio("gun4.wav");
			}
		});
		
		b6.addActionListener((e) -> {
			if (dropdown3.getSelectedItem().toString().equalsIgnoreCase("T-64A")) {
				this.playAudio("gun4.wav");
			}
			else {
				this.playAudio("gun3.wav");
			}
		});
		
		
		b7.addActionListener((e) -> {
			String val1 = dropdown1.getSelectedItem().toString();
			String val2 = dropdown2.getSelectedItem().toString();
			
			int intVal1 = 0;
			int intVal2 = 0;
			int finalVal = 0;
			
			for (int x = 0; x < val1.length(); ++x) {
				intVal1 = intVal1 + Character.getNumericValue(val1.charAt(x));
			}
			
			for (int x = 0; x < val2.length(); ++x) {
				intVal2 = intVal2 + Character.getNumericValue(val2.charAt(x));
			}
			
			if (intVal1 > intVal2) {
				finalVal = intVal1 - intVal2;
			}
			
			else if (intVal1 <= intVal2) {
				finalVal = intVal2 - intVal1;
			}
			
			else {
				outputText.setText("The distance is 0");
			}
			
			outputText.setText("The distance is " + String.valueOf(finalVal));
		});
		
		b8.addActionListener((e) -> {
			String val1 = dropdown1.getSelectedItem().toString();
			String val2 = dropdown2.getSelectedItem().toString();
			
			int intVal1 = 0;
			int intVal2 = 0;
			
			for (int x = 0; x < val1.length(); ++x) {
				intVal1 = intVal1 + Character.getNumericValue(val1.charAt(x));
			}
			
			for (int x = 0; x < val2.length(); ++x) {
				intVal2 = intVal2 + Character.getNumericValue(val2.charAt(x));
			}
			
			outputText.setText("The sum is " + String.valueOf(intVal1 + intVal2));
		});
		
		b9.addActionListener((e) -> {
			String val1 = dropdown1.getSelectedItem().toString();
			String val2 = dropdown2.getSelectedItem().toString();
			
			int intVal1 = 0;
			int intVal2 = 0;
			
			for (int x = 0; x < val1.length(); ++x) {
				intVal1 = intVal1 + Character.getNumericValue(val1.charAt(x));
			}
			
			for (int x = 0; x < val2.length(); ++x) {
				intVal2 = intVal2 + Character.getNumericValue(val2.charAt(x));
			}
			
			outputText.setText("The product is " + String.valueOf(intVal1 * intVal2));
		});
		
		b10.addActionListener((e) -> {
			String val1 = dropdown1.getSelectedItem().toString();
			String val2 = dropdown2.getSelectedItem().toString();
			
			int intVal1 = 0;
			int intVal2 = 0;
			
			for (int x = 0; x < val1.length(); ++x) {
				intVal1 = intVal1 + Character.getNumericValue(val1.charAt(x));
			}
			
			for (int x = 0; x < val2.length(); ++x) {
				intVal2 = intVal2 + Character.getNumericValue(val2.charAt(x));
			}
			
			outputText.setText("The quotient is " + String.valueOf((double)intVal1 / intVal2));
		});
		
		scnr.close();
	}
	
	public static void main(String[] args) throws IOException {
		Soundboard_StationCalc a = new Soundboard_StationCalc();
		
		a.construct();
	}
}
