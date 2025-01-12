package Java_Ex;


import java.util.*;
public class HashMapLogin {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		var map = new HashMap<String, Integer>();
		map.put("jeon", 1234);
		while(true) {
			System.out.print("로그인 하시겠습니까?(y or n) : ");
			String answer = sc.next();
			if(answer.equals("y")) {
				System.out.print("id: ");
				String id = sc.next();
				System.out.print("pw: ");
				int pw = sc.nextInt();

				// 아이디 틀림
				if(!map.containsKey(id)) {
					System.out.println("아이디가 존재하지 않습니다.");
				}
				// 비번 틀림
				else if(pw != (map.get(id))) {
					System.out.println("비밀번호 불일치!");
				}
				
				else {
					System.out.println("로그인 성공!");
					break;
				}
			}
			else {
				System.out.println("종료됨");
				break;
			}
		}
	}
}
