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
	frame.addKeyListener(this);
	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		labelText = "";
		label.setText(labelText);
		System.out.println(word);
		for(int i =0; i < word.length();i++) 
		{labelText = labelText + "_";}
		label.setText(labelText);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		if(labelText.equalsIgnoreCase(word)) {
			int wordNum = find.nextInt(2998);

				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader("src/dictionary.txt"));

					for(int i =0; i < wordNum;i++) {
					try {
						word = br.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				labelText = "";
				System.out.println(word);
				for(int i =0; i < word.length();i++) 
				{labelText = labelText + "_";}
				label.setText(labelText);
			
		}else {
		for (int i = 0; i < labelText.length(); i++) {
			if(word.charAt(i) == e.getKeyChar()) {
				if(labelText.charAt(i) == '_') {
				String part1 = labelText.substring(0, i);
				String part2 = labelText.substring(i + 1, labelText.length());
				labelText = part1 + e.getKeyChar() + part2;
				label.setText(labelText);
				System.out.println("correct");
				}
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
