package Swing_Ex;

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUp extends JFrame{
	public SignUp(){
		// 폰트
		Font title = new Font("SanSerif", Font.BOLD, 20);
		Font subtitle = new Font("SanSerif", Font.BOLD, 17);
		Font font = new Font("Dialog", Font.PLAIN, 15);
		Font Sfont = new Font("Dialog", Font.PLAIN, 12);

		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		Container c = getContentPane();

		// ID, PWD 입력 창
		JPanel IDpanel = new JPanel();
		JPanel PWpanel = new JPanel();
		JLabel SignUpText = new JLabel("회원가입");
		JLabel IDlabel = new JLabel("ID : ");
		JLabel PWlabel = new JLabel("PW : ");
		JTextField ID = new JTextField(20);
		JTextField PW = new JTextField(20);
		JButton signup = new JButton("가입하기");
		SignUpText.setFont(title);
		ID.setFont(font);
		PW.setFont(font);
		IDlabel.setFont(subtitle);
		PWlabel.setFont(subtitle);
		signup.setFont(Sfont);

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
		c.add(SignUpText);
		c.add(signup);

		// 위치 지정
		SignUpText.setBounds(203,50,100,20);
		IDpanel.setBounds(65,105,350,40);
		PWpanel.setBounds(59,155,350,50);
		signup.setBounds(200, 230,90,40);
		setSize(500,400);
		setLocationRelativeTo(null); 
		setVisible(true);
		
		// 회원가입 
		signup.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String userID = ID.getText().trim();
		        String userPW = PW.getText().trim();

		        if (userID.isEmpty() || userPW.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 모두 입력해주세요.");
		            return;
		        }

		        // user.txt 파일에서 중복된 ID가 있는지 확인
		        File userFile = new File("user.txt");
		        boolean isDuplicate = false;
		        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                String[] userDetails = line.split(", ");
		                String existingID = userDetails[0];
		                if (existingID.equals(userID)) {
		                    isDuplicate = true;
		                    break;
		                }
		            }
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(null, "파일을 읽는 데 실패했습니다.");
		            return;
		        }

		        // 중복된 ID가 있을 경우
		        if (isDuplicate) {
		            JOptionPane.showMessageDialog(null, "이미 사용 중인 아이디입니다.");
		            return;
		        }

		        // ID와 PW를 user.txt에 저장
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
		            writer.write(userID + ", " + userPW);
		            writer.newLine();
		            JOptionPane.showMessageDialog(null, "가입 성공!");
		            dispose();  
		            new BookManager();  
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(null, "회원가입 중 오류가 발생했습니다.");
		        }
		    }
		});
	}
}
