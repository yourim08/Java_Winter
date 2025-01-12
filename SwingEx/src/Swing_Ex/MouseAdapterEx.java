package Swing_Ex;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 어뎁터 연습
public class MouseAdapterEx extends JFrame{
	private JLabel la = new JLabel("Hello");
	
	public MouseAdapterEx() {
		setTitle("마우스 이벤트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseAdapter());
		
		c.setLayout(null); // 요소 위치 계속 변하기 때문제 null
		la.setSize(50,20);
		la.setLocation(30,30); // 요소 초기 위치
		c.add(la);
		
		setSize(250,250);
		setVisible(true);
	}
	
	// 어뎁터를 상속받아 추상클래스 삭제~
	class MyMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // 위치 알아내기
			int y = e.getY();
			la.setLocation(x,y);
		}
	}
	
	// 메인
	public static void main(String args[]) {
		new MouseAdapterEx();
	}
}
