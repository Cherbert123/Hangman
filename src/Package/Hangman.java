package Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	String labelText = "";
	public static void main(String[] args){
		Hangman runner = new Hangman();
		runner.run();
	}
	public void run() {
		
	frame.add(panel);
	panel.add(label);
	label.setText(labelText);
	frame.setVisible(true);
	try {
		BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
		try {
			for(int i =0; i < wordNum;i++) {
			word = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(word);
		for(int i =0; i < word.length();i++) 
		{labelText = labelText + "_";}
		label.setText(labelText);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		for(int i = 1; i < word.length(); i++) {
		if(e.getKeyChar() == word.charAt(i)) {
		String part1 = labelText.substring(0, i);
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
