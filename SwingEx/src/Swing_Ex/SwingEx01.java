package Swing_Ex;


import javax.swing.*;

//스윙으로 프레임 만들기
public class SwingEx01 extends JFrame {
	public SwingEx01() {
		setTitle("300x300 스윙 프레임 만들기");
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String args[]) {
		new SwingEx01();
	}
}
