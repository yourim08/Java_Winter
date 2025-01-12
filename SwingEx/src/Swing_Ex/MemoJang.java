package Swing_Ex;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
// io도 필요함
import java.io.*;

// 메모장
public class MemoJang extends JFrame {

	private JTextArea textArea;

	public MemoJang() {
		setTitle("메모장");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 창이 "화면의" 중앙이 되도록 설정.
		setLocationRelativeTo(null);

		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);

		// 메뉴, 메뉴 바, 메뉴 항목 추가
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
		
		JMenuItem saveItem = new JMenuItem("저장");
		JMenuItem openItem = new JMenuItem("열기");

		saveItem.addActionListener(new SaveAction());
		openItem.addActionListener(new OpenAction());
		
		// "파일" 메뉴 드롭다운에 추가
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		
		// 메뉴 바에 "파일" 추가
		menuBar.add(fileMenu);
		// 만든 메뉴 바를 메뉴 바 창에 추가
		setJMenuBar(menuBar);
	}

	private class SaveAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 파일 선택기 추가
			JFileChooser fileChooser = new JFileChooser();
			// saveDialog = 저장 대화상자(파일탐색기)
			// Memojang.this 로 메모장 위에 뜨게 함
			// APPROVE_OPTION은 사용자가 "파일"을 저장하겠다고 선택했는지 알려줌
			if(fileChooser.showSaveDialog(MemoJang.this)== JFileChooser.APPROVE_OPTION) {
				// 저장한 파일 가져오기
				File file = fileChooser.getSelectedFile();
				
				// 쓰기 위한 writer 객체 생성. 데이터를 파일에 하나하나 씀.
				// getText가 입력창에 있는 데이터를 문자열로 바꿔주는 기능
				try (PrintWriter writer = new PrintWriter(file)){
					writer.write(textArea.getText());
				} 
				catch (IOException ex){
					// "파일을 찾을 수 없음" 등과 같은 에외문구
					ex.printStackTrace();
				}
			}
		} 
	}

	private class OpenAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			if(fileChooser.showOpenDialog(MemoJang.this) == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				
				// 파일을 불러오기 위해 버퍼 리더 생성 (파일 리더와 함께 동시 생성)
				try (BufferedReader reader = new BufferedReader(new FileReader(file))){
					// 내용을 새로입력해야 되기 때문에, 기존의 영역을 지움
					textArea.setText("");
					// 한 줄씩 읽어서 내용 추가
					String line;
					while((line = reader.readLine()) != null) {
						textArea.append(line+"\n");
					}
				}
				catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String args[]) {
		// 메모장 객체 생성하고 화면에 표시
		// invokeLater는 GUI전용 스레드 (EDT)에서 실행하도록 예약함
		// 이유 : 하나의 스레드가 여러 GUI를 관리하면, 충돌이 일어날 수 있음!
		// 즉, 충돌을 막기 위해서 invokeLater메소드를 사용한다.
		SwingUtilities.invokeLater(() -> {
			MemoJang notepad = new MemoJang();
			notepad.setVisible(true);
		});
	}
}
