package DB;

import java.sql.*;
import java.io.*;

public class JDBC_Ex03 {
	public static void main(String args[]) {
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root","qwer1357!");
			System.out.println("DB 연결 완료!");
			// 이게 몰까.. 커넥에다가 SQL문 쓸 수 있게 statet생성?
			stmt = con.createStatement();
			
			// 추가
			stmt.executeUpdate("insert into student (name, id, dept) values ('아무개','0893012','컴퓨터 공학');");
			printTable(stmt);
			
			// 수정
			stmt.executeUpdate("update student set id='0189011' where name='아무개'");
			System.out.println();
			printTable(stmt);
			
			// 삭제
			stmt.executeUpdate("delete from student where name='아무개'");
			System.out.println();
			printTable(stmt);
			
			// 특정 값 찾기
			// rs = stmt.executeQuery("select name, id, dept from student where name='이기자'");
			// printData(rs, "name", "id", "dept");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
	}
	
	// 값 출력 메소드
//	private static void printData(ResultSet rs, String col1, String col2, String col3) throws SQLException{
//		while(rs.next()) {
//			if(!col1.equals("")) {
//				System.out.print(rs.getString("name"));
//			}
//			if(!col2.equals("")) {
//				System.out.print("\t|\t"+rs.getString("id"));
//			}
//			if(!col3.equals("")) {
//				System.out.println("\t|\t"+rs.getString("dept"));
//			}
//			else {
//				System.out.println();
//			}
//		}
//	}
	
	// 테이블 값 출력은 랜덤하게 나온다. 그래서 sorting이 필요한것!
	private static void printTable(Statement stmt) throws SQLException{
		ResultSet rs = null;
		rs = stmt.executeQuery("select * from student");
		while (rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.print("\t|\t"+rs.getString("id"));
			System.out.println("\t|\t"+rs.getString("dept"));
		}
	}
}