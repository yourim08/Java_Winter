package Swing_Ex;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 마우스 리스너 연습
public class MouseListenerEx extends JFrame{
	private JLabel la = new JLabel("Hello");
	
	public MouseListenerEx() {
		setTitle("마우스 이벤트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		
		c.setLayout(null); // 요소 위치 계속 변하기 때문제 null
		la.setSize(50,20);
		la.setLocation(30,30); // 요소 초기 위치
		c.add(la);
		
		setSize(250,250);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e) {
			int x = e.getX(); // 위치 알아내기
			int y = e.getY();
			la.setLocation(x,y);
		}
		
		// Pressed만 할건데도 나머지 4개를 다 써야함.. -> 어뎁터 필요!
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	// 메인
	public static void main(String args[]) {
		new MouseListenerEx();
	}
}
