package Nugget_Breed;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;

public class MainPage extends JFrame {
   int main_id;
   String d_name;
   String d_sick;
   String d_id;
   int d_heart;
   int d_hungry;
   int d_meat;
   int d_pill;
   int d_play;
   int d_level;
   int d_sofa;
   String url = "jdbc:mysql://localhost/nuggetdb?serverTimezone=Asia/Seoul";
   String user = "root";
   String password = "qwer1357!";
   Connection con;
   private HashMap<Integer, String> sofaMap = new HashMap<>();

   public MainPage(int id) {
      
       sofaMap.put(0, "img/white_sofa.png");
       sofaMap.put(1, "img/green_sofa.png");
       sofaMap.put(2, "img/red_sofa.png");
       sofaMap.put(3, "img/premium_sofa.png");
       sofaMap.put(4, "img/blue_sofa.png");
       sofaMap.put(5, "img/luxury_sofa.png");

      this.main_id = id;
      System.out.println(main_id);


      // 로그인 시 일정 확률로 "건강"이 "아픔"으로 변경
      try {
         // 사용자 상태 가져오기
         con = DriverManager.getConnection(url, user, password);
         String getStatusQuery = "SELECT status FROM member WHERE user_id = ?";
         PreparedStatement pstmtStatus = con.prepareStatement(getStatusQuery);
         pstmtStatus.setInt(1, main_id);
         ResultSet rsStatus = pstmtStatus.executeQuery();

         if (rsStatus.next()) {
            d_sick = rsStatus.getString("status");

            // 상태가 "건강"인 경우에만 아픔으로 변경할 확률 계산
            if (d_sick.equals("건강")) {
               // 20% 확률로 "아픔" 상태로 변경
               double probability = Math.random(); // 0.0 ~ 1.0 랜덤 값 생성
               if (probability < 0.1) { // 20% 확률
                  d_sick = "아픔";

                  // DB 업데이트
                  String updateStatusQuery = "UPDATE member SET status = ? WHERE user_id = ?";
                  PreparedStatement pstmtUpdateStatus = con.prepareStatement(updateStatusQuery);
                  pstmtUpdateStatus.setString(1, d_sick);
                  pstmtUpdateStatus.setInt(2, main_id);
                  pstmtUpdateStatus.executeUpdate();

                  JOptionPane.showMessageDialog(null, "당신의 너겟이 병에 걸렸습니다!");
               }
            }
         }


         // 폰트
         Font mv = new Font("MV Boli", Font.PLAIN, 25);
         Font s_mv = new Font("MV Boli", Font.PLAIN, 20);
         Font k_mv = new Font("Hi Melody", Font.PLAIN, 27);
         Font pre_bold = new Font("NanumGothicExtraBold", Font.BOLD, 20);
         Font pre = new Font("NanumGothic", Font.PLAIN, 15);


         // 아픔
         Statement stmt_sick = con.createStatement();
         ResultSet rs_sick = stmt_sick.executeQuery("select status from member where user_id = "+main_id+"");
         if(rs_sick.next()) {
            d_sick = rs_sick.getString("status");
         }

         // 아이디
         Statement stmt_id = con.createStatement();
         ResultSet rs_id = stmt_id.executeQuery("select ID from member where user_id = "+main_id+"");
         if(rs_id.next()) {
            d_id = rs_id.getString("ID");
         }

         // 레벨
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select level from member where user_id = "+main_id+"");
         if (rs.next()) { // next 반드시 필요
            d_level = rs.getInt("level");
            System.out.println(d_level);
         }

         Statement stmt1 = con.createStatement();
         ResultSet rs_name = stmt1.executeQuery("select name from member where user_id = "+main_id+"");
         if(rs_name.next()) {
            d_name = rs_name.getString("name");
         }

         Statement stmt2 = con.createStatement();
         ResultSet rs_heart = stmt2.executeQuery("select love from member where user_id = "+main_id+"");
         if(rs_heart.next()) {
            d_heart = rs_heart.getInt("love");
         }

         Statement stmt3 = con.createStatement();
         ResultSet rs_hungry = stmt3.executeQuery("select hungry from member where user_id = "+main_id+"");
         if(rs_hungry.next()) {
            d_hungry = rs_hungry.getInt("hungry");
         }

         Statement stmt4 = con.createStatement();
         ResultSet rs_meat = stmt4.executeQuery("select meat from member where user_id = "+main_id+"");
         if(rs_meat.next()) {
            d_meat = rs_meat.getInt("meat");
         }

         Statement stmt5 = con.createStatement();
         ResultSet rs_pill = stmt5.executeQuery("select pill from member where user_id = "+main_id+"");
         if(rs_pill.next()) {
            d_pill = rs_pill.getInt("pill");
         }

         Statement stmt6 = con.createStatement();
         ResultSet rs_play = stmt5.executeQuery("select play from member where user_id = "+main_id+"");
         if(rs_play.next()) {
            d_play = rs_play.getInt("play");
         }
         Statement st_sofa = con.createStatement();
         ResultSet rs_sofa = st_sofa.executeQuery("select sofa from member where user_id = "+main_id+"");
         if(rs_sofa.next()) {
            d_sofa = rs_sofa.getInt("sofa");
         }
         
         
         JFrame mainJF = new JFrame("MainPage");
         mainJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainJF.setLayout(null);

         JPanel mainJP = new JPanel();
         mainJP.setBackground(new Color(255,247,179));


         // 이미지 넣기
         // DB 레벨에 따른 외형 불러오기
         ImageIcon character = new ImageIcon("img/main_level" + d_level + ".png");
         JLabel c_img = new JLabel(character);
         if(d_sick.equals("아픔")) {
            c_img.setIcon(new ImageIcon("img/main_sick.png")); 
         }
         
         
         //sofa img
         ImageIcon sf = new ImageIcon();
         String imagePath = sofaMap.get(d_sofa);
         System.out.println(imagePath);
         if (imagePath != null) {
             // ImageIcon 객체 생성
             sf = new ImageIcon(imagePath);
             System.out.println("ImageIcon created with path: " + imagePath);
         } else {
             System.out.println("Invalid sofa key: " + d_sofa);
         }
         
         ImageIcon back = new ImageIcon("img/main_back1.png");
         ImageIcon st = new ImageIcon("img/main_back3.png");
         ImageIcon inven = new ImageIcon("img/main_back2.png");
         ImageIcon gm = new ImageIcon("img/main_game.png");
         ImageIcon pl = new ImageIcon("img/main_play.png");
         ImageIcon eat = new ImageIcon("img/main_eat.png");
         ImageIcon sick = new ImageIcon("img/main_pill.png");
         ImageIcon sp = new ImageIcon("img/main_shop.png");

         RoundedButton loginBack = new RoundedButton("로그아웃");
         loginBack.setFont(pre);
         loginBack.setBackground(new Color(255,247,179));
         
         JLabel background = new JLabel(back);
         JLabel status = new JLabel(st);
         JLabel item = new JLabel(inven);
         JLabel sofa = new JLabel(sf);
         JLabel game = new JLabel(gm);
         JLabel play = new JLabel(pl);
         JLabel feed = new JLabel(eat);
         JLabel medicine = new JLabel(sick);
         JLabel shop = new JLabel(sp);
         JLabel name = new JLabel(d_name);
         JLabel heart = new JLabel(String.valueOf(d_heart));
         JLabel hungry = new JLabel(String.valueOf(d_hungry));
         JLabel meat = new JLabel(String.valueOf(d_meat));
         JLabel pill = new JLabel(String.valueOf(d_pill));

         name.setFont(k_mv);
         heart.setFont(s_mv);
         hungry.setFont(s_mv);
         meat.setFont(mv);
         pill.setFont(mv);

         mainJP.add(loginBack);
         mainJP.add(shop);
         mainJP.add(play);
         mainJP.add(feed);
         mainJP.add(medicine);
         mainJP.add(game);
         mainJP.add(c_img);
         mainJP.add(name);
         mainJP.add(heart);
         mainJP.add(hungry);
         mainJP.add(meat);
         mainJP.add(pill);
         mainJP.add(sofa);
         mainJP.add(status);
         mainJP.add(item);
         mainJP.add(background);
         mainJF.add(mainJP);

         // 앞서 말한 패널 설정
         mainJP.setBounds(0,0,1000,732);
         mainJP.setLayout(null);

         loginBack.setBounds(20,620,85,35);
         play.setBounds(150, 560, 100, 100);
         feed.setBounds(350, 560, 100, 100);
         medicine.setBounds(550, 560, 100, 100);
         shop.setBounds(750,563,100,100);
         sofa.setBounds(340,250,300,200);
         game.setBounds(630,365,120,100);
         name.setBounds(58,36,100,30);
         heart.setBounds(110,75,100,20);
         hungry.setBounds(110,120,100,20);
         meat.setBounds(800,23,100,20);
         pill.setBounds(900,23,100,20);
         c_img.setBounds(360,350,265,150);
         background.setBounds(0,40,1000,660);
         status.setBounds(2,2,270,160);
         item.setBounds(700,10,200,50);
         mainJF.setSize(1000, 732);
         mainJF.setLocationRelativeTo(null);
         mainJF.setVisible(true);


         // 버튼 리스너 (로그인 창으로)
         loginBack.addActionListener(new ActionListener() {
            public void  actionPerformed (ActionEvent e) {
               mainJF.setVisible(false);
               new Login();
            }
         });
         
      // 상점
         shop.addMouseListener(new MouseAdapter() {
            public void  mouseClicked(MouseEvent e) {
               mainJF.setVisible(false);
               new Shop(d_id);
            }
         });

         // 게임
         game.addMouseListener(new MouseAdapter() {
            public void  mouseClicked(MouseEvent e) {
               mainJF.setVisible(false);
               new FoodGame(d_id);
               meat.setText(String.valueOf(d_meat));
            }
         });

         // 놀아주기 버튼
         play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               try {
                  if(d_play == 0) {
                     JOptionPane.showMessageDialog(null, "오늘은 더이상 놀아줄 수 없습니다!");
                  }
                  else {
                     d_pill++;
                     d_play--;
                     pill.setText(String.valueOf(d_pill));
                     JOptionPane.showMessageDialog(null, "신나게 놀아주었습니다!");
                     // DB 업데이트 (pill ++, play --)
                     updateDB();
                  }
               } catch (SQLException ex) {
                  ex.printStackTrace();
                  JOptionPane.showMessageDialog(mainJF, "DB 업데이트 오류: " + ex.getMessage());
               }
            }
         });

         // 약먹기 버튼
         medicine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               try {
                  if(d_pill == 0) {
                     JOptionPane.showMessageDialog(mainJF, "약이 없습니다!");
                  }
                  else {
                     // 약 주기 로직 실행
                     givePill();
                     pill.setText(String.valueOf(d_pill));
                     c_img.setIcon(new ImageIcon("img/main_level" + d_level + ".png")); 
                  }
               } catch (SQLException ex) {
                  ex.printStackTrace();
                  JOptionPane.showMessageDialog(mainJF, "DB 업데이트 오류: " + ex.getMessage());
               }
            }
         });


         // 밥주기 버튼
         feed.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               try {
                  if(d_sick.equals("아픔")) {
                     JOptionPane.showMessageDialog(null, "아파서 밥을 먹지 못합니다ㅜㅜ");
                  }
                  else if(d_hungry == 100) {
                     JOptionPane.showMessageDialog(null, "배불러요! 내일 다시 주세요^0^");
                  }
                  else if(d_meat == 0) {
                     JOptionPane.showMessageDialog(null, "스테이크가 없습니다!");
                  }
                  else {
                     d_meat--;
                     d_hungry+=10;
                     d_heart+=15;
                     JOptionPane.showMessageDialog(null, "한우 투뿔 스테이크를 먹였습니다!");
                     meatDB();
                     heart.setText(String.valueOf(d_heart));
                     hungry.setText(String.valueOf(d_hungry));
                     meat.setText(String.valueOf(d_meat));
                     // 캐릭터 외형 변경
                     c_img.setIcon(new ImageIcon("img/main_level" + d_level + ".png")); 

                  }
               } catch (SQLException ex) {
                  ex.printStackTrace();
                  JOptionPane.showMessageDialog(mainJF, "DB 업데이트 오류: " + ex.getMessage());
               }
            }
         }); 
      }
      catch (SQLException e) {
         e.printStackTrace();
         JOptionPane.showMessageDialog(null, "데이터베이스 오류: " + e.getMessage());
      }
      catch (Exception e) {
         System.out.println("오류 발생");
      }
   }

   // 약주기
   private void updateDB () throws SQLException {
      String query = "UPDATE member SET pill = +"+d_pill+" WHERE user_id = "+main_id+"";
      Statement stmt = con.createStatement();
      stmt.executeUpdate(query);

      String query2 = "UPDATE member SET play = +"+d_play+" WHERE user_id = "+main_id+"";
      Statement stmt2 = con.createStatement();
      stmt2.executeUpdate(query2);
   }

   private void givePill() throws SQLException {
      if (d_sick.equals("아픔")) {
         if (d_pill == 0) {
            JOptionPane.showMessageDialog(null, "약이 부족합니다!");
         } else {

            String heal = "건강";
            String updateStatusQuery = "UPDATE member SET status = '"+heal+"' WHERE user_id = "+main_id+"";
            Statement stmtStatus = con.createStatement();
            stmtStatus.executeUpdate(updateStatusQuery);

            String updatePillQuery = "UPDATE member SET pill = pill - 1 WHERE user_id = "+main_id+"";
            Statement stmtPill = con.createStatement();
            stmtPill.executeUpdate(updatePillQuery);

            d_pill--; 
            d_sick = heal; 
            JOptionPane.showMessageDialog(null, "약을 먹어 건강해졌습니다!");
         }
      } else {
         JOptionPane.showMessageDialog(null, "이미 건강한 상태입니다!");
      }
   }


   private void meatDB () throws SQLException {
      String query = "UPDATE member SET meat = +"+d_meat+" WHERE user_id = "+main_id+"";
      Statement stmt = con.createStatement();
      stmt.executeUpdate(query);

      String query2 = "UPDATE member SET love = +"+d_heart+" WHERE user_id = "+main_id+"";
      Statement stmt2 = con.createStatement();
      stmt2.executeUpdate(query2);

      String query3 = "UPDATE member SET hungry = +"+d_hungry+" WHERE user_id = "+main_id+"";
      Statement stmt3 = con.createStatement();
      stmt2.executeUpdate(query3);

      if(d_heart >= 100) {
         d_level++;
         d_heart = d_heart-100;
         String query_love = "UPDATE member SET love = +"+d_heart+" WHERE user_id = "+main_id+"";
         Statement stmt_love = con.createStatement();
         stmt_love.executeUpdate(query_love);
      }

      String query4 = "UPDATE member SET level = +"+d_level+" WHERE user_id = "+main_id+"";
      Statement stmt4 = con.createStatement();
      stmt4.executeUpdate(query4);
   }
}