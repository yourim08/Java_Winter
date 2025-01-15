package Login;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainFrame  extends JFrame {
	// 패널
	JPanel basePanel = new JPanel(new BorderLayout());
	JPanel centerPanel = new JPanel(new BorderLayout());
	JPanel eastPanel = new JPanel(new BorderLayout());
	JPanel westPanel = new JPanel(new BorderLayout());
	JPanel southPanel = new JPanel(new BorderLayout());

	// 라벨
	JLabel idL = new JLabel("아이디");
	JLabel pwL = new JLabel("비밀번호");

	// 입력창
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();

	// 버튼
	JButton loginBtn = new JButton("로그인");
	JButton joinBtn = new JButton("회원가입");
	JButton exitBtn = new JButton("프로그램 종료");

	LoginMain lm = null;

	// 생성자 호출
	public MainFrame(LoginMain lmm) {
		lm = lmm;
		setTitle("로그인");

		// 패널 크기 작업
		centerPanel.setPreferredSize(new Dimension(260,80));
		westPanel.setPreferredSize(new Dimension(210,75));
		eastPanel.setPreferredSize(new Dimension(90,75));
		southPanel.setPreferredSize(new Dimension(290,40)); // 아래서부터 40만큼, 가로 290

		// 라벨 크기 작업
		idL.setPreferredSize(new Dimension(50,30));
		pwL.setPreferredSize(new Dimension(50,30));

		// 입력창 크기 작업
		id.setPreferredSize(new Dimension(140,30));
		pw.setPreferredSize(new Dimension(140,30));

		// 버튼 크기 작업
		loginBtn.setPreferredSize(new Dimension(75,63));
		joinBtn.setPreferredSize(new Dimension(135,25));
		exitBtn.setPreferredSize(new Dimension(135,25));

		// 패널 추가 작업
		setContentPane(basePanel); // panel을 기본 컨테이너로 설정

		basePanel.add(centerPanel, BorderLayout.CENTER);
		basePanel.add(southPanel, BorderLayout.SOUTH);
		centerPanel.add(westPanel, BorderLayout.WEST);
		centerPanel.add(eastPanel, BorderLayout.EAST);

		westPanel.setLayout(new FlowLayout());
		eastPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new FlowLayout());

		// westPanel 컴포넌트
		westPanel.add(idL);
		westPanel.add(id);
		westPanel.add(pwL);
		westPanel.add(pw);

		// eastPanel 컴포넌트
		eastPanel.add(loginBtn);

		// southPanel 컴포넌트
		southPanel.add(exitBtn);
		southPanel.add(joinBtn);


		// 버튼 이벤트 리스너
		ButtonListener bl = new ButtonListener();
		loginBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		exitBtn.addActionListener(bl);

		setSize(310, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		// 사이즈 고정! 레이아웃 깨짐 방지
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Button 이벤트 리스너
	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();

			// 입력된 아이디, 비번을 변수에 초기화
			String uid = id.getText();
			String upw = "";
			for(int i=0; i<pw.getPassword().length; i++) {
				upw = upw + pw.getPassword()[i];
			}

			// 종료 버튼 이벤트
			if(b.getText().equals("프로그램 종료")){
				System.out.println("프로그램 종료");
				System.exit(0);
			}

			// 회원가입 버튼 이벤트
			else if(b.getText().equals("회원가입")) {
				System.out.println("회원가입");
			}

			// 로그인 버튼 이벤트
			else if(b.getText().equals("로그인")) {
				if(uid.equals("") || upw.equals("")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요", "로그인 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("로그인 실패 > 로그인 정보 미입력");
				}
				else if(uid != null && upw != null) {
					if(lm.db.logincheck(uid, upw)) {
						System.out.println("로그인 성공");
						JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
					}
					else {
						System.out.println("로그인 실패 > 로그인 정보 불일치");
						JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
					}
				}
			}
		}
	}
}

