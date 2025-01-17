package Nugget_Breed;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class FoodGame extends JFrame {
   private JLabel basket;
   private JLabel bread;
   private JLabel cake;
   private JLabel cookie;
   private JLabel candy;
   private JLabel rotten_cheese;
   private JLabel rotten_meat;
   private JLabel highScore;
   private JLabel Score;
   private JLabel home;
   private JLayeredPane layeredPane;

   private List<JLabel> foods = new ArrayList<>();
   private List<JLabel> Nfoods = new ArrayList<>();
   private List<Timer> timers = new ArrayList<>();

   private int time = 0;
   private int score = 0;
   static int meat = 0;
   
   private String id;
   private int n_id;
   
   private Database database;
   private int highscore;
   
   public FoodGame(String id) {
      this.database = new Database();
      this.id = id;
      this.highscore = database.getScore(id); 
      
      setTitle("Game");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600, 700);
       setResizable(false);
      setLocationRelativeTo(null);
      getContentPane().setLayout(null);

      // 레이어를 설정하여 앞뒤 순서 지정
      layeredPane = new JLayeredPane();
      layeredPane.setBounds(0, 0, 600, 700);
      getContentPane().add(layeredPane);
      
      highScore = new JLabel("HighScore   " + highscore);
      highScore.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
      highScore.setBounds(38, 83, 156, 41);
      
      Score = new JLabel("Score    0");
      Score.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
      Score.setBounds(38, 15, 156, 41);

      JLabel img = new JLabel("");
      img.setBounds(0, 0, 588, 663);
      img.setIcon(new ImageIcon("img/gameBack.png"));
      
      home = new JLabel("");
      home.setBounds(520, 15, 40, 40); 
      home.setIcon(new ImageIcon("img/home.png"));

      basket = new JLabel("");
      basket.setBounds(200, 470, 180, 87); 
      basket.setIcon(new ImageIcon("img/basket.png"));
      
      JLabel react = new JLabel("");
      react.setBounds(24, 13, 204, 118); 
      react.setIcon(new ImageIcon("img/react.png"));      
      
       
      bread = new JLabel("");
      bread.setIcon(new ImageIcon("img/bread.png"));
      
      cake = new JLabel("");
      cake.setIcon(new ImageIcon("img/cake.png"));
      
      cookie = new JLabel("");
      cookie.setIcon(new ImageIcon("img/cookie.png"));
      
      candy = new JLabel("");
      candy.setIcon(new ImageIcon("img/candy.png"));
      
      rotten_cheese = new JLabel("");
      rotten_cheese.setIcon(new ImageIcon("img/rotten_cheese.png"));
      
      rotten_meat = new JLabel("");
      rotten_meat.setIcon(new ImageIcon("img/rotten_meat.png"));
      
      // 레이어 순서
      layeredPane.add(highScore, Integer.valueOf(4));
      layeredPane.add(Score, Integer.valueOf(4));
      layeredPane.add(img, Integer.valueOf(0));
      layeredPane.add(home, Integer.valueOf(3));
      layeredPane.add(react, Integer.valueOf(3));
      layeredPane.add(basket, Integer.valueOf(2));
      
      foods.add(bread);
      foods.add(cake);
      foods.add(cookie);
      foods.add(candy);
      
      Nfoods.add(rotten_cheese);
      Nfoods.add(rotten_meat);
      
      InitPos(foods);
      InitPos(Nfoods);
      
      //홈 버튼 이벤트
      home.addMouseListener(new java.awt.event.MouseAdapter() {
          @Override
          public void mouseClicked(java.awt.event.MouseEvent e) {
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
               catch (SQLException e2) {
                  e2.printStackTrace();
                  JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e2.getMessage());
               }
               catch (Exception e1) {
                  System.out.println("오류 발생");
               }
             setVisible(false);
             new MainPage(n_id);
          }
      });

      // 방향키로 바구니 조정
      addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
              switch (e.getKeyCode()) {
                  case KeyEvent.VK_LEFT:
                     left();
                      break;
                  case KeyEvent.VK_RIGHT:
                     right();
                      break;
              }
          }
      });
      
      Timer crash = new Timer(500, new ActionListener() { 
          @Override
          public void actionPerformed(ActionEvent e) { 
             // foods 충돌 처리
             int n = crash(foods);
             if (n != -1) {
                score += 5;
                 Score.setText("Score    " + score);
               int rand = (int)(Math.random() * 550);
               foods.get(n).setBounds(rand, -15, 60, 60);
             }
             
             // Nfoods 충돌 처리
             if (crash(Nfoods) != -1) {
                 score += time;
                 database.updateMeat(id,bab(score),database.getMeat(id));
                 if (score > highscore) {
                     database.updateScore(id, score);
                 }
                 JLabel gameOverLabel = new JLabel("Game Over");
                 gameOverLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 50));
                 gameOverLabel.setForeground(Color.red);
                 gameOverLabel.setBounds(160, 170, 400, 100); 

                 home.setBounds(270, 240, 100, 100);
                 home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));  

                 layeredPane.add(gameOverLabel, Integer.valueOf(5));
                 layeredPane.add(home, Integer.valueOf(5));

                 // 게임 종료 처리를 위해 타이머 정지
                 stopTimers();
             }
          }
      });
      timers.add(crash);
      crash.start(); // 타이머 시작
      
      Timer timer = new Timer(100, new ActionListener() { // 100ms 간격
          @Override
          public void actionPerformed(ActionEvent e) { 
             goDown(foods,false);
          }
      });
      timers.add(timer);
      timer.start(); // 타이머 시작
      
      Timer t = new Timer(50, new ActionListener() { // 100ms 간격
          @Override
          public void actionPerformed(ActionEvent e) { 
             goDown(Nfoods,false);
          }
      });
      timers.add(t);
      t.start(); // 타이머 시작
      
      setVisible(true);
      
   }
   //창을 벗어나지 않게
   public void left() {
      if(-50 < basket.getX()) {
         basket.setLocation(basket.getX() - 10, basket.getY());
      }
   }
   public void right() {
      if(450 > basket.getX()) {
         basket.setLocation(basket.getX() + 10, basket.getY());
      }
   }
   public void goDown(List<JLabel> a , boolean crash) {
      for (JLabel item : a) {
            if (item.getY() < 500 && !crash) { // 화면 아래로 이동
                item.setLocation(item.getX(), item.getY() + 10); 
            } else { // 화면 아래에 도달하면 랜덤 위치에서 다시 시작
                int rand = (int)(Math.random() * 600); // 새 x좌표
                item.setLocation(rand, -15); 
            }
        }
   }
   
   public void InitPos(List<JLabel> a) {
      int y = 0;
      for(JLabel items : a) {
         int rand = (int)(Math.random() * 550);
         items.setBounds(rand, -200 + y, 60, 60); 
         layeredPane.add(items, Integer.valueOf(1)); 
         y += 150;
      }
   }
   public int crash(List<JLabel> a) {
       for (int i = 0; i < a.size(); i++) {
           JLabel item = a.get(i);

           int itemX = item.getX();
           int itemY = item.getY();
           int itemWidth = item.getWidth();
           int itemHeight = item.getHeight();

           int basketX = basket.getX();
           int basketY = basket.getY();
           int basketWidth = basket.getWidth();
           int basketHeight = basket.getHeight();

           if (itemX < basketX + basketWidth && 
               itemX + itemWidth > basketX &&
               itemY < basketY + basketHeight && 
               itemY + itemHeight > basketY) {
               return i;
           }
       }
       return -1;
   }

   //밥
   public static int bab(int score) {
      int bab = 0;
      bab = score / 20;
      return bab;
   }
   private void stopTimers() {
       for (Timer timer : timers) {
           timer.stop();
       }
   }
}
