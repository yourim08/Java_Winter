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
	
	// 폰트
	Font title = new Font("SanSerif", Font.BOLD, 20);
	Font subtitle = new Font("SanSerif", Font.BOLD, 17);
	Font font = new Font("Dialog", Font.PLAIN, 15);
	Font Sfont = new Font("Dialog", Font.PLAIN, 12);
	
	// 홈 화면
	public BookManager () {
		setTitle("도서관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Container c = getContentPane();

		// ID, PWD 입력 창
		JPanel IDpanel = new JPanel();
		JPanel PWpanel = new JPanel();
		JLabel loginText = new JLabel("로그인");
		JLabel IDlabel = new JLabel("ID : ");
		JLabel PWlabel = new JLabel("PW : ");
		JTextField ID = new JTextField(20);
		JTextField PW = new JTextField(20);
		JButton login = new JButton("로그인");
		JButton signup = new JButton("회원가입");
		JButton admin = new JButton("관리자");
		loginText.setFont(title);
		ID.setFont(font);
		PW.setFont(font);
		IDlabel.setFont(subtitle);
		PWlabel.setFont(subtitle);
		login.setFont(font);
		signup.setFont(Sfont);
		admin.setFont(Sfont);
		admin.setBackground(new Color(200, 213, 223));

		// 플레이스 홀더
		ID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(ID.getText().equals("아이디를 입력해주세요")) {
					ID.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if(ID.getText().equals("")) {
					ID.setText("아이디를 입력해주세요");
				}
			}
		});

		PW.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(PW.getText().equals("비밀번호를 입력해주세요")) {
					PW.setText("");
				}
			}	
			public void focusLost(FocusEvent e) {
				if(PW.getText().equals("")) {
					PW.setText("비밀번호를 입력해주세요");
				}
			}
		});

		// 패널에 추가
		IDpanel.add(IDlabel);
		IDpanel.add(ID);
		PWpanel.add(PWlabel);
		PWpanel.add(PW);

		// 컨테이너에 추가
		c.add(IDpanel);
		c.add(PWpanel);
		c.add(loginText);
		c.add(login);
		c.add(signup);
		c.add(admin);

		// 위치 지정
		loginText.setBounds(215,50,100,20);
		IDpanel.setBounds(65,100,350,50);
		PWpanel.setBounds(59,140,350,50);
		login.setBounds(200, 230,90,40);
		signup.setBounds(205, 300,80,30);
		admin.setBounds(390,300,70,30);
		setSize(500,400);
		setLocationRelativeTo(null); 
		setVisible(true);

        // ID, PW 로그인
        login.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed (ActionEvent e) {
                // 파일에서 아이디, 비밀번호 읽기
                boolean loginSuccess = false;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] credentials = line.split(", "); // 아이디와 비밀번호 분리
                        String fileId = credentials[0];
                        String filePw = credentials[1];

                        // 입력된 아이디와 비밀번호가 일치하는지 확인
                        if(ID.getText().equals(fileId) && PW.getText().equals(filePw)) {
                            JOptionPane.showMessageDialog(null, "로그인 성공!");
                            setVisible(false);
                            new UserHome();  // 로그인 성공 후 이동할 화면
                            loginSuccess = true;
                            break;
                        }
                    }
                    reader.close();
                    
                    if (!loginSuccess) {
                        JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다!");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "파일 읽기를 실패하였습니다.");
                }
            }
        });
		// 회원가입
        signup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new SignUp();
			}
		});
		// 관리자 로그인 하기
		admin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Admin();
			}
		});
	}
}

