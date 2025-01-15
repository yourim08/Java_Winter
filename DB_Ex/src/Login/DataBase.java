package Login;

import java.sql.*;
import java.io.*;

public class DataBase {
	Connection con = null;
	Statement st = null;
	String url = "jdbc:mysql://localhost/dbstudy?serverTimezone=Asia/Seoul";
	String user = "root";
	String password = "qwer1357!";
	
	public DataBase() {
		try {
			// 이러한 jdbc드라이버를 연결하겠습니다! 
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 커넥션에 이러한 값들로 연결
			con = DriverManager.getConnection(url, user, password);
			// 쿼리문 작성을 위해 Statement를 만듦
			st = con.createStatement();
			System.out.println("서버 연동 성공!");
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
			String checkingStr = "select password from member where id = '"+id+"'";
			// String 이니까 쌍따옴표 필요, 근데 ' ' 안이니까 +을 이용해 "을 붙여줌
			ResultSet rs = st.executeQuery(checkingStr);
			
			while(rs.next()) {
				if(pw.equals(rs.getString("password"))) {
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
}

