package Nugget_Breed;

import java.sql.*;

import javax.swing.JOptionPane;

public class SignUpDB {
	Connection con = null;
	Statement st = null;
	String url = "jdbc:mysql://localhost/nuggetdb?serverTimezone=Asia/Seoul";
	String user = "root";
	String password = "qwer1357!";
	public SignUpDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
		}
		catch (Exception e) { // 뭔가 예외가 발생하면, 문자열로 출력
			System.out.println("서버 연동 실패"+e.toString());
		}
	}

	// 회원가입 정보 확인
	boolean signupcheck(String ii, String pp, String nn) {
		boolean flag = false;
		String id = ii;
		String pw = pp;
		String name = nn;
		try {
		    // ID 중복 확인
		    String checkQuery = "SELECT COUNT(*) FROM member WHERE ID = '"+id+"'";
		    Statement checkStmt = con.createStatement();
		    ResultSet rs = checkStmt.executeQuery(checkQuery);
		    rs.next();
		    if (rs.getInt(1) > 0) { 
		    	JOptionPane.showMessageDialog(null, "이미 존재하는 ID 입니다");
		        return false;
		    }

		    // 다음 user_id 가져오기
		    String getMaxIdQuery = "SELECT COALESCE(MAX(user_id), 0) + 1 AS next_user_id FROM member";
		    Statement getMaxIdStmt = con.createStatement();
		    ResultSet maxIdRs = getMaxIdStmt.executeQuery(getMaxIdQuery);
		    int nextUserId = 1; 
		    if (maxIdRs.next()) {
		        nextUserId = maxIdRs.getInt("next_user_id");
		    }

		    // 회원 정보 삽입
		    // String은 항상 ``로 감싸주기, int는 ""만
		    String insertQuery = "INSERT INTO member (user_id, name, ID, PW, love, hungry, meat, pill, level, play, status, score) "
		            + "VALUES ("+nextUserId+", '"+name+"', '"+id+"', '"+pw+"', 0, 10, 0, 0, 0, 1, '건강', 0)";
		    Statement insertStmt = con.createStatement();
		    int rowsInserted = insertStmt.executeUpdate(insertQuery);

		    if (rowsInserted > 0) {
		        flag = true; 
		    }
		} 
		catch (Exception e) {
			flag = false;
			System.out.println("회원가입 실패"+e.toString());
		}
		return flag;
	}
}
