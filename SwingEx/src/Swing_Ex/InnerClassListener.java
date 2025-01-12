package Swing_Ex;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// 이벤트 리스너 (내부 클래스)
public class InnerClassListener extends JFrame {
	public InnerClassListener () {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		
		setSize(350,150);
		setVisible(true);
	}

	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action")) {
				b.setText("액션");
			}
			else {
				b.setText("Action");
			}
			// b의 텍스트 상태 불러옴
			InnerClassListener.this.setTitle(b.getText());
		}
	}
	
	// 메인
	public static void main(String argS[]) {
		new InnerClassListener();
	}
}
