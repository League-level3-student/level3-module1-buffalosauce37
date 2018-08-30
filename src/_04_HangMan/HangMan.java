package _04_HangMan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class HangMan{
	
	public static void main(String[] args) {
	String x =	JOptionPane.showInputDialog("how many words would you like to have");
		int y = Integer.parseInt(x);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test.txt"));
			
			String line = br.readLine();
			for (int i = 0; i < y; i++) {
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
