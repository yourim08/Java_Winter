package Swing_Ex;


import java.awt.*;
import javax.swing.*;

//FlowLayout
public class FlowLayoutEx extends JFrame {
	public FlowLayoutEx() {
		setTitle("FlowLayout 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		// 레이아웃 설정
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40)); 
		// LEFT로 설정, 가로갭 30, 세로갭 40
		
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String args[]) {
		new FlowLayoutEx();
	}
}
