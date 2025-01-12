package Swing_Ex;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class AdminList extends JFrame {
    public AdminList() {
        setTitle("도서 목록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        JTextArea listArea = new JTextArea();
        listArea.setEditable(false);  // 내용 수정 불가
        JScrollPane scrollPane = new JScrollPane(listArea);  
        scrollPane.setBounds(50, 50, 400, 250);  
        
        add(scrollPane);
        
        // 도서 목록 출력
        try {
            BufferedReader reader = new BufferedReader(new FileReader("book_list.txt"));
            String line;
            int n = 1;  
            while ((line = reader.readLine()) != null) {
                // ", O"를 제거
                line = line.replace(", O", "");
                listArea.append(n + ". " + line + "\n");  
                n++;
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "파일 읽기를 실패하였습니다");
        }

        setSize(500, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
