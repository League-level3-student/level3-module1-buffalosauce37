package _04_HangMan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangMan{ 
	String currentWord;
	String hiddenWord;
	int lives = 0;
	void Setup() {
		String x =	JOptionPane.showInputDialog("how many words would you like to have");
		int y = Integer.parseInt(x);
		for (int i = 0; i < y; i++) {
			String word = Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			if (!s.contains(word)) {
				s.push(word);
			}
		}
		currentWord = s.pop();
		hiddenWord="";
		for (int i = 0; i < currentWord.length(); i++) {
			hiddenWord += " _ ";
		}
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel(hiddenWord);
	JLabel label2 = new JLabel("Lives remaining:");
	JLabel label3 = new JLabel(Integer.toString(lives));
	frame.add(panel);
	panel.add(label1);
	panel.add(label2);
	panel.add(label3);
	frame.setVisible(true);

	frame.pack();
	
	
	}
	static Stack<String> s = new Stack<>();
	public static void main(String[] args) {
		HangMan hang = new HangMan();
		hang.Setup();	
	}
	
}
