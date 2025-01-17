package Nugget_Breed;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp {
	public SignUp() {
		// 폰트
		Font mv = new Font("MV Boli", Font.PLAIN, 25);
		Font pre_bold = new Font("NanumGothicExtraBold", Font.BOLD, 20);
		Font pre = new Font("NanumGothic", Font.PLAIN, 15);

		JFrame signupJF = new JFrame("SignUp");
		signupJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signupJF.setLayout(null);

		JPanel signupJP = new JPanel();
		RoundedButton signup = new RoundedButton("가입하기");
		signup.setFont(pre);
		signup.setBackground(new Color(251,217,98));
		signupJP.setBackground(new Color(251,217,98));

		ImageIcon signup_box = new ImageIcon("img/login_box.png");
		JLabel box = new JLabel(signup_box);
		JLabel signup_text = new JLabel("회원가입");
		JLabel id_text = new JLabel("아이디");
		JLabel name_text = new JLabel("이름");
		JLabel pw_text = new JLabel("비밀번호");
		JTextField id = new JTextField(50);
		JTextField name = new JTextField(50);
		JPasswordField pw = new JPasswordField(50);
		// 밑면만 border
		name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		id.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		pw.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		signup_text.setFont(pre_bold);
		id_text.setFont(pre);
		pw_text.setFont(pre);
		name_text.setFont(pre);
		id.setFont(pre);
		pw.setFont(pre);
		name.setFont(pre);

		signupJP.add(id);
		signupJP.add(pw);
		signupJP.add(name);
		signupJP.add(name_text);
		signupJP.add(signup_text);
		signupJP.add(id_text);
		signupJP.add(pw_text);
		signupJP.add(signup);
		signupJP.add(box);


		signupJF.add(signupJP);

		// 패널 설정
		signupJP.setBounds(0,0,1000,732);
		signupJP.setLayout(null);
		
		name.setBounds(330,470,320,20);
		name_text.setBounds(330,420,100,40);
		id.setBounds(330, 270, 320, 20);
		pw.setBounds(330, 370, 320, 20);
		signup.setBounds(485, 545, 95, 20);
		signup.setBounds(580,535,80,35);
		box.setBounds(290,97,400,500);
		signup_text.setBounds(323,135,100,40);
		id_text.setBounds(330,220,100,40);
		pw_text.setBounds(330,320,100,40);

		signupJF.setSize(1000, 732);
		signupJF.setLocationRelativeTo(null);
		signupJF.setVisible(true);
		
		// 가입하기 버튼 이벤트
		signup.addActionListener(new ActionListener() {
			public void  actionPerformed (ActionEvent e) {
				// 입력된 아이디, 비번, 이름을 변수에 초기화
				String input_id = id.getText();
				String input_pw = "";
				String input_name = name.getText();
				
				SignUpDB sdb = new SignUpDB();
				for(int i=0; i<pw.getPassword().length; i++) {
					input_pw = input_pw + pw.getPassword()[i];
				}
				if(input_id.equals("") || input_pw.equals("") || input_name.equals("")){
					JOptionPane.showMessageDialog(null, "아이디, 비밀번호, 이름를 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
				}
				else if(input_id != null && input_pw != null && input_name != null) {
					if(sdb.signupcheck(input_id, input_pw, input_name)) {
						JOptionPane.showMessageDialog(null, "가입되었습니다!");
						signupJF.setVisible(false);
						new Login();
					}
				}
			}
		});
	}
}
