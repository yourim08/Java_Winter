package Swing_Ex;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class UserHome extends JFrame {
	public UserHome() {
		setTitle("유저-메인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// 폰트
		Font title = new Font("SanSerif", Font.BOLD, 20);
		Font subtitle = new Font("SanSerif", Font.BOLD, 17);
		Font font = new Font("Dialog", Font.PLAIN, 15);
		Font Sfont = new Font("Dialog", Font.PLAIN, 12);

		// 대출, 반납
		JLabel U_text = new JLabel("유림 도서관");
		JTextField in_info = new JTextField(20);
		JTextField out_info = new JTextField(20);
		JButton in_btn = new JButton("대출");
		JButton out_btn = new JButton("반납");
		JButton home = new JButton("홈");
		home.setBackground(new Color(200, 213, 223));
		U_text.setFont(title);
		in_info.setFont(Sfont);
		out_info.setFont(Sfont);
		in_btn.setFont(Sfont);
		out_btn.setFont(Sfont);
		home.setFont(Sfont);


		// 프레임에 추가
		add(U_text);
		add(in_info);
		add(out_info);
		add(in_btn);
		add(out_btn);
		add(home);


		// 위치 지정
		U_text.setBounds(190, 40, 150, 30);    
		in_info.setBounds(50, 125, 250, 30);   
		in_btn.setBounds(340, 125, 80, 30);    
		out_info.setBounds(50, 165, 250, 30); 
		out_btn.setBounds(340, 165, 80, 30);   
		home.setBounds(200, 250, 100, 40);


		setSize(500,400);
		setLocationRelativeTo(null); 
		setVisible(true);

		// 대출
		in_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bookName = in_info.getText();
				if (bookName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "책 이름을 입력해주세요.");
					return;
				}

				// 파일에서 O인지 확인
				boolean isBookAvailable = false;
				File bookFile = new File("book_list.txt");
				var bookList = new ArrayList<String>();
				try (BufferedReader reader = new BufferedReader(new FileReader(bookFile))) {
					String line;
					while ((line = reader.readLine()) != null) {
						bookList.add(line);
					}
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "파일 읽기를 실패했습니다.");
					return;
				}

				boolean bookFound = false;
				for (int i = 0; i < bookList.size(); i++) {
					String book = bookList.get(i);
					String[] bookDetails = book.split(", ");
					String bookTitle = bookDetails[0];
					String bookStatus = bookDetails[3];

					// 책 이름이 맞고, 상태가 'O'인 경우 대출 가능
					if (bookTitle.equals(bookName)) {
						bookFound = true;
						if ("X".equals(bookStatus)) {
							JOptionPane.showMessageDialog(null, "이 책은 대여중입니다");
						} else {
							// 상태 변경
							bookDetails[3] = "X";
							bookList.set(i, String.join(", ", bookDetails));
							isBookAvailable = true;
							JOptionPane.showMessageDialog(null, "대출이 완료되었습니다!");
						}
						break;
					}
				}

				if (!bookFound) {
					JOptionPane.showMessageDialog(null, "책을 찾을 수 없습니다");
				}

				// 파일에 변경된 리스트 저장
				if (isBookAvailable) {
					try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookFile))) {
						for (String book : bookList) {
							writer.write(book);
							writer.newLine();
						}
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "파일을 저장하는 데 실패했습니다");
					}
				}
			}
		});

		// 반납
		out_btn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String bookName = out_info.getText();
		        if (bookName.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "책 이름을 입력해주세요");
		            return;
		        }

		        // 파일에서 X인지 확인
		        boolean isBookReturned = false;
		        File bookFile = new File("book_list.txt");
		        var bookList = new ArrayList<String>();
		        try (BufferedReader reader = new BufferedReader(new FileReader(bookFile))) {
		            String line;
		            while ((line = reader.readLine()) != null) {
		                bookList.add(line);
		            }
		        } catch (IOException ex) {
		            JOptionPane.showMessageDialog(null, "파일 읽기를 실패했습니다");
		            return;
		        }

		        boolean bookFound = false;
		        for (int i = 0; i < bookList.size(); i++) {
		            String book = bookList.get(i);
		            String[] bookDetails = book.split(", ");
		            String bookTitle = bookDetails[0];
		            String bookStatus = bookDetails[3];

		            // 책 이름이 맞고, 상태가 'X'인 경우 반납 가능
		            if (bookTitle.equals(bookName)) {
		                bookFound = true;
		                if ("O".equals(bookStatus)) {
		                    JOptionPane.showMessageDialog(null, "이미 반납된 책입니다");
		                } else {
		                    // 반납 처리: 상태 변경 'X' -> 'O'
		                    bookDetails[3] = "O";
		                    bookList.set(i, String.join(", ", bookDetails));
		                    isBookReturned = true;
		                    JOptionPane.showMessageDialog(null, "반납이 완료되었습니다!");
		                }
		                break;
		            }
		        }

		        if (!bookFound) {
		            JOptionPane.showMessageDialog(null, "책을 찾을 수 없습니다");
		        }

		        // 반납 성공 시 파일에 변경된 리스트 저장
		        if (isBookReturned) {
		            try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookFile))) {
		                for (String book : bookList) {
		                    writer.write(book);
		                    writer.newLine();
		                }
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(null, "파일을 저장하는 데 실패했습니다");
		            }
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
