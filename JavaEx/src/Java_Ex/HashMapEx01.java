package Java_Ex;


import java.util.*;
public class HashMapEx01 {
	public static void main(String args[]) {
		var dic = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		
		// 값 삽입
		dic.put("취미","기타" );
		dic.put("음식","치킨");
		dic.put("나라","한국");
		
		// 값 검색
		while(true) {
			System.out.print("찾고 싶은 단어는? : ");
			String word = sc.nextLine();
			if(word.equals("종료")) {
				System.out.println("종료!");
				break;
			}
			
			String mean = dic.get(word);
			if(mean == null) {
				System.out.println("없는단어!");
			}
			else {
				System.out.println(mean);
			}
		}
	}
}
