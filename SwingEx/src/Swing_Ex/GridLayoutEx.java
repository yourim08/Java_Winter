package Swing_Ex;


import java.awt.*;
import javax.swing.*;

// GridLayout
public class GridLayoutEx extends JFrame {
	public GridLayoutEx() {
		
		setTitle("GridLayout 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		// 2행 4열의 그리드 생성
		c.setLayout(new GridLayout(4,2));
		
		c.add(new JButton("이름"));
		c.add(new JTextField(""));
		c.add(new JButton("학번"));
		c.add(new JTextField(""));
		c.add(new JButton("학과"));
		c.add(new JTextField(""));
		c.add(new JButton("과목"));
		c.add(new JTextField(""));
		
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String args[]) {
		new GridLayoutEx();
	}
}
