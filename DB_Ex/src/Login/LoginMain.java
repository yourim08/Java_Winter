package Login;

import java.sql.*;
import java.io.*;

public class LoginMain {
	// 객체 생성
	DataBase db = null;
	MainFrame mf = null;
	
	// 메인
	public static void main(String args[]) {
		LoginMain m = new LoginMain();
		m.db = new DataBase();
		m.mf = new MainFrame(m);
	}
}

