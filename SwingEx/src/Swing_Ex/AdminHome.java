package Swing_Ex;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AdminHome extends JFrame {
	public AdminHome() {
		setTitle("관리자-메인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 폰트
		Font title = new Font("SanSerif", Font.BOLD, 20);
		Font subtitle = new Font("SanSerif", Font.BOLD, 17);
		Font font = new Font("Dialog", Font.BOLD, 15);
		Font Sfont = new Font("Dialog", Font.PLAIN, 12);

		JButton add_btn = new JButton("추가");
		JButton list_btn = new JButton("목록");
		JButton home = new JButton("홈");
		add_btn.setFont(font);
		list_btn.setFont(font);
		home.setFont(Sfont);
		home.setBackground(new Color(200, 213, 223));

		// 프레임에 추가
		add(add_btn);
		add(list_btn);
		add(home);

		// 버튼 위치 설정
		add_btn.setBounds(85,100,140,70);
		list_btn.setBounds(265,100,140,70);
		home.setBounds(208,270,70,30);
		setSize(500,400);
		setLocationRelativeTo(null);
		setVisible(true);
		
		// 추가 창으로 이동
		add_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminAdd();
			}
		});
		
		// 목록 창으로 이동
		list_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				setVisible(false);
				new AdminList();
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

class Book {
	String name;
	String author;
	String publisher;
	int n;
	boolean status = false;
	public Book (String name, String author, String publisher, int n, boolean status) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.n = n;
		this.status = status;
	}
}