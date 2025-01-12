package Swing_Ex;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class AdminAdd extends JFrame {
	public AdminAdd() {
		setTitle("도서 추가");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 폰트
		Font title = new Font("SanSerif", Font.BOLD, 20);
		Font subtitle = new Font("SanSerif", Font.BOLD, 16);
		Font font = new Font("Dialog", Font.BOLD, 15);
		Font Sfont = new Font("Dialog", Font.PLAIN, 13);

		JLabel order = new JLabel("추가할 도서의 제목, 저자, 출판사를 입력해주세요");
		JTextField info = new JTextField(130);
		JButton info_btn = new JButton("추가");
		JButton home = new JButton("돌아가기");
		order.setFont(subtitle);
		info.setFont(Sfont);
		info_btn.setFont(Sfont);
		home.setFont(Sfont);
		home.setBackground(new Color(200, 213, 223));

		// 프레임에 더하기
		add(order);
		add(info);
		add(info_btn);
		add(home);

		order.setBounds(65,65,400,20);
		info.setBounds(70,156,250,20);
		info_btn.setBounds(345,150,70,30);
		home.setBounds(187,250,90,30);
		setSize(500,400);
		setVisible(true);
		setLocationRelativeTo(null);

		// 추가 메소드
		info_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				String bookInfo = info.getText().trim();

				if (!bookInfo.isEmpty()) {
					// 파일에 추가
					bookInfo += ", O";
					try (BufferedWriter writer = new BufferedWriter(new FileWriter("book_list.txt", true))) {
						writer.write(bookInfo);  // 도서 정보를 파일에 기록
						writer.newLine();
						JOptionPane.showMessageDialog(null, "도서가 추가되었습니다!");
						info.setText("");  // 입력창 초기화
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "저장 중 오류가 발생했습니다");
					}
				} else {
					JOptionPane.showMessageDialog(null, "정보를 입력해 주세요");
				}
			}
		});

		// 관리자 홈으로 돌아가기
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				setVisible(false);
				new AdminHome();
			}
		});
	}
}
