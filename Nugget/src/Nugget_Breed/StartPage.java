package Nugget_Breed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartPage extends JFrame {
	
	public StartPage () {
		
		// 폰트
		Font mv = new Font("MV Boli", Font.PLAIN, 25);
		JFrame startJF = new JFrame("시작화면");
		startJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startJF.setLayout(null);
		
		// 보통 프레임 새로 만들고, 패널에 setBC 쓰는 경우 많음. 근데 그럴라면 패널도 크기&위치, 레이아웃 설정해줘야함.
		JPanel startJP = new JPanel();
		RoundedButton start = new RoundedButton("Start");
		startJP.setBackground(new Color(255,247,179));
		start.setBackground(new Color(252,191,70));
		
		// 이미지 넣기
		ImageIcon icon = new ImageIcon("img/startpage_title.png");
		ImageIcon character = new ImageIcon("img/startpage_nugget.png");
		JLabel lb1 = new JLabel(icon);
		JLabel lb2 = new JLabel(character);
		
		start.setFont(mv);
		startJP.add(lb1);
		startJP.add(lb2);
		startJP.add(start);
		startJF.add(startJP);
		
		// 앞서 말한 패널 설정
		startJP.setBounds(0,0,1000,732);
		startJP.setLayout(null);
		
		start.setBounds(437,570,100,50);
		lb1.setBounds(252,64,550,107);
		lb2.setBounds(335,240,330,220);
		startJF.setSize(1000, 732);
		startJF.setLocationRelativeTo(null);
		startJF.setVisible(true);
		
		
		// 버튼 리스너 (로그인 창으로)
		start.addActionListener(new ActionListener() {
			public void  actionPerformed (ActionEvent e) {
				startJF.setVisible(false);
				new Login();
			}
		});
		
	}
	
	public static void main(String args[]) {
		new StartPage();
	}
	
	
}


