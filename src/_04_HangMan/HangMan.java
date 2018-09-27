package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

public class HangMan implements KeyListener { 
	String currentWord;
	String hiddenWord;
	int lives = 10;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label1 = new JLabel(hiddenWord);
	JLabel label2 = new JLabel("Lives remaining:");
	JLabel label3 = new JLabel(Integer.toString(lives));
	void startGame() {
		currentWord = s.pop();
		hiddenWord="";
		for (int i = 0; i < currentWord.length(); i++) {
			hiddenWord += "_";
		}
		lives = 10;
	}
	void Setup() {
		String x =	JOptionPane.showInputDialog("how many words would you like to have");
		int y = Integer.parseInt(x);
		for (int i = 0; i < y; i++) {
			String word = Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt");
			if (!s.contains(word)) {
				s.push(word);
			}
		}
	frame.add(panel);
	panel.add(label1);
	panel.add(label2);
	panel.add(label3);
	frame.addKeyListener(this);
	label1.setText(hiddenWord);
	frame.setVisible(true);

	frame.pack();
	
	startGame();
	}
	static Stack<String> s = new Stack<>();
	public static void main(String[] args) {
		HangMan hang = new HangMan();
		hang.Setup();	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(currentWord.contains(Character.toString(e.getKeyChar()))) {
			String newHiddenWord = "";
			for (int i = 0; i < currentWord.length(); i++) {
				if(currentWord.charAt(i) == e.getKeyChar()) {
					newHiddenWord += e.getKeyChar();
				}
				else {
					newHiddenWord += hiddenWord.charAt(i);
				}
			}
			hiddenWord = newHiddenWord;
			label1.setText(newHiddenWord);
			frame.pack();
		}
		else if(lives <= 0) {
			JOptionPane.showMessageDialog(null, "game over the work was " + currentWord);
		}
		else{
			lives -= 1;
			label3.setText(Integer.toString(lives));
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
