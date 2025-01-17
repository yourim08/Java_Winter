package Nugget_Breed;

import java.sql.*;

public class Database {
    Connection con = null;
    Statement stmt = null;
    private static final String URL = "jdbc:mysql://localhost:3306/nuggetdb";
    private static final String USER = "root";
    private static final String PASSWORD = "qwer1357!";
    
    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = con.createStatement();
            System.out.println("MySQL 서버 연동 성공");
        } catch (Exception e) {
            System.out.println("MySQL 서버 연동 실패: " + e.toString());
        }
    }
    
    public int getScore(String id) {
        String query = "SELECT score FROM member WHERE ID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("score");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    
    public int getSofa(String id) {
        String query = "SELECT sofa FROM member WHERE ID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("sofa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }
    public int getMeat(String id) {
        String query = "SELECT meat FROM member WHERE ID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("meat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; 
    }

    public void updateScore(String id, int newScore) {
        String query = "UPDATE member SET score = ? WHERE ID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, newScore);
            pstmt.setString(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateSofa(String id, int sofa) {
        String query = "UPDATE member SET sofa = ? WHERE ID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, sofa);
            pstmt.setString(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMeat(String id,int meat1, int meat2) {
        String query = "UPDATE member SET meat = ? WHERE ID = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, meat1 + meat2);
            pstmt.setString(2, id);
            int rowsUpdated = pstmt.executeUpdate();
            
            if (rowsUpdated > 0) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DB 연결 종료 메소드
    public void close() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
