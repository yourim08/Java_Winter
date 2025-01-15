package DB;

import java.sql.*;
// next() 쓸라구 io를 받았나?
import java.io.*;

public class JDBC_Ex02 {
	public Connection con;
	public Statement stmt = null;
	public PreparedStatement psmt = null;
	public ResultSet rs;

	public JDBC_Ex02() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb","root","qwer1357!");
			System.out.println("연결 완료!");
			stmt = con.createStatement();
			// SQL문 실행해서 결과  rs에 넘겨줌
			rs = stmt.executeQuery("select * from member");
			printData(rs, "id", "name", "addr");
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 에러");
		}
		catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}	
	}
	
	private static void printData(ResultSet rs, String col1, String col2, String col3) throws SQLException{
		// throws 해야됨. 해야 오류 안남. try-catch를 직접 써놓은? 그런거
		while(rs.next()) {
			if(!col1.equals("")) {
				System.out.print(rs.getString("id"));
			}
			if(!col2.equals("")) {
				System.out.print("\t|\t"+rs.getString("name"));
			}
			if(!col3.equals("")) {
				System.out.println("\t|\t"+rs.getString("addr"));
			}
		}
	}
	public static void main(String args[]) {
		new JDBC_Ex02();
	}
}
