package Swing_Ex;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Admin extends JFrame{
	String id = "a";
	String pw = "a";
	public Admin() {
		setTitle("관리자 로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		// 폰트
		Font title = new Font("SanSerif", Font.BOLD, 20);
		Font subtitle = new Font("SanSerif", Font.BOLD, 17);
		Font font = new Font("Dialog", Font.PLAIN, 15);
		Font Sfont = new Font("Dialog", Font.PLAIN, 12);

		// ID, PWD 입력 창
		JPanel A_IDpanel = new JPanel();
		JPanel A_PWpanel = new JPanel();
		JLabel A_loginText = new JLabel("관리자");
		JLabel A_IDlabel = new JLabel("ID : ");
		JLabel A_PWlabel = new JLabel("PW : ");
		JTextField A_ID = new JTextField(20);
		JTextField A_PW = new JTextField(20);
		JButton A_login = new JButton("로그인");
		JButton home = new JButton("홈");
		A_loginText.setFont(title);
		A_ID.setFont(font);
		A_PW.setFont(font);
		A_IDlabel.setFont(subtitle);
		A_PWlabel.setFont(subtitle);
		A_login.setFont(font);
		home.setFont(Sfont);
		home.setBackground(new Color(200, 213, 223));

		// 플레이스 홀더
		A_ID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(A_ID.getText().equals("아이디를 입력해주세요")) {
					A_ID.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if(A_ID.getText().equals("")) {
					A_ID.setText("아이디를 입력해주세요");
				}
			}
		});

		A_PW.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(A_PW.getText().equals("비밀번호를 입력해주세요")) {
					A_PW.setText("");
				}
			}   
			public void focusLost(FocusEvent e) {
				if(A_PW.getText().equals("")) {
					A_PW.setText("비밀번호를 입력해주세요");
				}
			}
		});

		// 패널에 추가
		A_IDpanel.add(A_IDlabel);
		A_IDpanel.add(A_ID);
		A_PWpanel.add(A_PWlabel);
		A_PWpanel.add(A_PW);

		// 프레임에 추가
		add(A_IDpanel);
		add(A_PWpanel);
		add(A_loginText);
		add(A_login);
		add(home);
	
		
		// 위치 지정
		A_loginText.setBounds(215,50,100,20);
		A_IDpanel.setBounds(65,100,350,50);
		A_PWpanel.setBounds(59,140,350,50);
		A_login.setBounds(200, 230,90,40);
		home.setBounds(390,300,70,30);
		
		
		setSize(500,400);
		setLocationRelativeTo(null); 
		setVisible(true);
		
		// ID, PW 로그인
		A_login.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed (ActionEvent e) {
				if(A_ID.getText().equals(id) && A_PW.getText().equals(pw)) {
					JOptionPane.showMessageDialog(null, "로그인 성공!");
					setVisible(false);
					new AdminHome();
					
				}
				else if(!A_ID.getText().equals(id) && !A_PW.getText().equals(pw)) {
					JOptionPane.showMessageDialog(null, "아이디, 비밀번호가 틀렸습니다!");
				}
				else if(!A_ID.getText().equals(id)){
					JOptionPane.showMessageDialog(null, "아이디가 틀렸습니다!");
				}
				else if(!A_PW.getText().equals(pw)) {
					JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다!");
				}
			}
		});
		// 유저 로그인 하기
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new BookManager();
			}
		});
	}
}
