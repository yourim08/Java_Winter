package Nugget_Breed;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Decoration extends JFrame {
    private ArrayList<JLabel> labels = new ArrayList<>();
    private int deco;
    private Database database;
    private String id;
    private int n_id;
    
    public Decoration(String id) {
       this.database = new Database();
      this.id = id;

        createLabel(85, 244);
        createLabel(285, 244);
        createLabel(485, 244);
        createLabel(681, 244);
        createLabel(85, 475);
        createLabel(285, 475);
        createLabel(485, 475);
        

        setTitle("Shop");
        setSize(793, 600);
        setResizable(false);
        getContentPane().setLayout(null);

        RoundedButton btnNewButton_1 = new RoundedButton("장식");
        btnNewButton_1.setFont(new Font("학교안심 둥근미소 TTF B", Font.PLAIN, 17));
        btnNewButton_1.setBackground(new Color(252, 227, 165));
        btnNewButton_1.setBounds(144, 34, 108, 43);
        getContentPane().add(btnNewButton_1);

        RoundedButton btnNewButton = new RoundedButton("가구");
        btnNewButton.setFont(new Font("학교안심 둥근미소 TTF B", Font.PLAIN, 17));
        btnNewButton.setBackground(new Color(245, 180, 7));
        btnNewButton.setBounds(26, 34, 108, 43);
        getContentPane().add(btnNewButton);
        
        

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               new Shop("1");
            }
        });

        JLabel exit = new JLabel("");
        exit.setBounds(700, 28, 35, 35);
        exit.setIcon(new ImageIcon("img/exit.png"));
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               System.out.println("클릭");
               setVisible(false);
               try {
                    Connection con = null;
                    Statement stmt = null;
                    String url = "jdbc:mysql://localhost:3306/nuggetdb";
                    String user = "root";
                    String password = "qwer1357!";
                    con = DriverManager.getConnection(url, user, password);
                    Statement stmt_n = con.createStatement();
                    ResultSet rs_n = stmt_n.executeQuery("select user_id from member where ID = '"+id+"'");
                    if(rs_n.next()) {
                       n_id = rs_n.getInt("user_id");
                    }
                 }
                 catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e1.getMessage());
                 }
                 catch (Exception e2) {
                    System.out.println("오류 발생");
                 }
               new MainPage(n_id);
            }
        });

        getContentPane().add(exit);

        JLabel img = new JLabel("");
        img.setBounds(-20, -22, 800, 600);
        img.setIcon(new ImageIcon("img/decoration.png"));
        getContentPane().add(img);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createLabel(int x, int y) {
        JLabel label = new JLabel("");
        label.setBounds(x, y, 100, 100);
        
        getContentPane().add(label);
        labels.add(label);
        
        int index = labels.indexOf(label);

        if (index == deco) {
            handleLabelClick(label, x, y);
        }

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleLabelClick(label, x, y);
            }
        });
    }

    private void handleLabelClick(JLabel clickedLabel, int x, int y) {
        for (JLabel label : labels) {
            if (label != clickedLabel) {
                label.setIcon(null);
            }
        }

        clickedLabel.setIcon(new ImageIcon("img/check.png"));
        clickedLabel.setBounds(x, y, 30, 20);

        int index = labels.indexOf(clickedLabel);
        deco = index;
    }
}
