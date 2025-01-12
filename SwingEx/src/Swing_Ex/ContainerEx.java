package Swing_Ex;

import javax.swing.*;
import java.awt.*;

//컨테이너와 컴포넌트
public class ContainerEx extends JFrame {
	public ContainerEx() {
		setTitle("ComponentPane과 JFrame");
		// 프레임과 패널을 동시에 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		// 컨테이너는 추상클래스라 new가 아니라 get 씀.
		Container contentPane = getContentPane();  // contentPane이라는 이름의 컨테이너 가져옴
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		
		// 버튼 추가
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300,150);
		setVisible(true); // 이건 왜...? ->
	}
	public static void main(String args[]) {
		new ContainerEx();
	}
}
