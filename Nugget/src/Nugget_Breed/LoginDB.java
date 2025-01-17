package Nugget_Breed;

import java.sql.*;
import java.io.*;

public class LoginDB {
	Connection con = null;
	Statement st = null;
	String url = "jdbc:mysql://localhost/nuggetdb?serverTimezone=Asia/Seoul";
	String user = "root";
	String password = "qwer1357!";
	
	public LoginDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
		}
		catch (Exception e) { // 뭔가 예외가 발생하면, 문자열로 출력
			System.out.println("서버 연동 실패"+e.toString());
		}
	}
	
	// 로그인 정보 확인
	boolean logincheck(String ii, String pp) {
		boolean flag = false;
		String id = ii;
		String pw = pp;
		
		try {
			String checkingStr = "select PW from member where ID = '"+id+"'";
			ResultSet rs = st.executeQuery(checkingStr);
			
			while(rs.next()) {
				if(pw.equals(rs.getString("PW"))) {
					flag = true;
				}
				else {
					flag = false;
				}
			}
		}
		catch (Exception e) {
			flag = false;
			System.out.println("로그인 실패"+e.toString());
		}
		return flag;
	}
	
	// user_id 반환 메서드
    public int getUserId(String input_id) {
        int userId = 0;
        String input = input_id;
        try {
        	// 아이디로 user_id 찾기
            String query = "SELECT user_id FROM member WHERE ID = '"+input+"'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            System.out.println("user_id 가져오기 실패: " + e.toString());
        }
        return userId;
    }
}

