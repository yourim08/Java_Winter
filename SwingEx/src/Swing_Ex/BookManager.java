package Swing_Ex;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookManager extends JFrame {

	// 메인
	public static void main(String args[]) {
		new BookManager();
	}


	// 홈 화면
	public BookManager () {
		setTitle("도서관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Container c = getContentPane();
		c.add(new JTextField(10));
		c.add(new JTextField(10));

		setSize(500,400);
		setLocationRelativeTo(null); 
		setVisible(true);
	}
}
