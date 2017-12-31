package Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman implements KeyListener  {
	Random find = new Random();
	int wordNum = find.nextInt(2998);
	String word = "";
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel livesL = new JLabel();
	String labelText = "";
	int lives = 5;
	ArrayList<String> words = new ArrayList<String>();
	public static void main(String[] args){
		Hangman runner = new Hangman();
		runner.run();
	}
	public void run() {
	livesL.setText("Lives: " + lives);
	frame.add(panel);
	panel.add(label);
	panel.add(livesL);
	label.setText(labelText);
	frame.setVisible(true);
	frame.addKeyListener(this);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	for (int o = 0; o < 6; o++) {
		wordNum = find.nextInt(2998);
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
		try {
			
			for(int i =0; i < wordNum;i++) {
			word = br.readLine();
			}
			words.add(word);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
		int w = find.nextInt(words.size());
		word = words.get(w);
		words.remove(w);
		
		labelText = "";
		label.setText(labelText);
		System.out.println(word);
		for(int i =0; i < word.length();i++) 
		{labelText = labelText + "_";}
		label.setText(labelText);
		if(words.size() == 1) {
			labelText = "You Win!";
			label.setText(labelText);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if(lives<=0) {
			labelText = "You Lose!!";
			label.setText(labelText);
			livesL.setText("");
		}else {
		
		if(labelText.equalsIgnoreCase(word)) {		
			if(words.size() == 1) {
				labelText = "You Win!";
				label.setText(labelText);
			}else {
				int w = find.nextInt(words.size());
				word = words.get(w);
				words.remove(w);
				labelText = "";
				System.out.println(word);
				for(int i =0; i < word.length();i++) 
				{labelText = labelText + "_";}
				label.setText(labelText);
			}
		}else {
		int fails = 0;
		for (int i = 0; i < labelText.length(); i++) {
			
			if(word.charAt(i) == e.getKeyChar()) {
				if(labelText.charAt(i) == '_') {
				String part1 = labelText.substring(0, i);
				String part2 = labelText.substring(i + 1, labelText.length());
				labelText = part1 + e.getKeyChar() + part2;
				label.setText(labelText);
				System.out.println("correct");
				}
			}else {
				if(lives<=0) {
					labelText = "You Lose!!";
					label.setText(labelText);
					livesL.setText("");
				}
				fails++;
			}
			
		}	
		if(fails >= labelText.length()) {
			lives = lives - 1;
			livesL.setText("Lives: " + lives);
		}
	}
	}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
