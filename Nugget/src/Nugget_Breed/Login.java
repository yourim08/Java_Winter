package Nugget_Breed;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame {
	int user_id;
	public Login() {
		// 폰트
		Font mv = new Font("MV Boli", Font.PLAIN, 25);
		Font pre_bold = new Font("NanumGothicExtraBold", Font.BOLD, 20);
		Font pre = new Font("NanumGothic", Font.PLAIN, 15);

		JFrame loginJF = new JFrame("Login");
		loginJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginJF.setLayout(null);

		JPanel loginJP = new JPanel();
		RoundedButton login = new RoundedButton("로그인");
		JButton signup = new JButton("회원가입");
		login.setFont(pre);
		signup.setFont(pre);
		signup.setBorderPainted(false);
		login.setBackground(new Color(251,217,98));
		signup.setBackground(new Color(255,255,255));
		loginJP.setBackground(new Color(251,217,98));

		ImageIcon login_box = new ImageIcon("img/login_box.png");
		JLabel box = new JLabel(login_box);
		JLabel login_text = new JLabel("로그인");
		JLabel id_text = new JLabel("아이디");
		JTextField id = new JTextField(50);
		JPasswordField pw = new JPasswordField(50);
		// 밑면만 border
		id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		pw.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		JLabel pw_text = new JLabel("비밀번호");
		login_text.setFont(pre_bold);
		id_text.setFont(pre);
		pw_text.setFont(pre);
		id.setFont(pre);
		pw.setFont(pre);

		loginJP.add(id);
		loginJP.add(pw);
		loginJP.add(login_text);
		loginJP.add(id_text);
		loginJP.add(pw_text);
		loginJP.add(login);
		loginJP.add(signup);
		loginJP.add(box);


		loginJF.add(loginJP);

		// 패널 설정
		loginJP.setBounds(0,0,1000,732);
		loginJP.setLayout(null);

		id.setBounds(330, 270, 320, 20);
		pw.setBounds(330, 430, 320, 20);
		signup.setBounds(485, 545, 95, 20);
		login.setBounds(580,535,80,35);
		box.setBounds(290,97,400,500);
		login_text.setBounds(323,135,100,40);
		id_text.setBounds(330,220,100,40);
		pw_text.setBounds(330,380,100,40);

		loginJF.setSize(1000, 732);
		loginJF.setLocationRelativeTo(null);
		loginJF.setVisible(true);

		// 회원가입, 로그인 버튼 이벤트 리스너
		login.addActionListener(new ActionListener() {
			public void  actionPerformed (ActionEvent e) {
				// 입력된 아이디, 비번을 변수에 초기화
				String input_id = id.getText();
				String input_pw = "";
				LoginDB db = new LoginDB();
				for(int i=0; i<pw.getPassword().length; i++) {
					input_pw = input_pw + pw.getPassword()[i];
				}
				if(input_id.equals("") || input_pw.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
				else if(input_id != null && input_pw != null) {
					if(db.logincheck(input_id, input_pw)) {
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
						loginJF.setVisible(false);
						setID(db.getUserId(input_id)); 
						new MainPage(user_id);
					}
					else {
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
					}
				}
			}
		});
		signup.addActionListener(new ActionListener() {
			public void  actionPerformed (ActionEvent e) {
				loginJF.setVisible(false);
				new SignUp();
			}
		});
	}
	
	public void setID(int id) {
		this.user_id = id;
	}

}
