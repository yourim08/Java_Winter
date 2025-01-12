package Java_Ex;

import java.util.*;
public class ArrayListEx01{
	public static void main(String args[]) {
		var a = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		// 삽입
		for(int i=0; i<4; i++) {
			System.out.print("이름 입력 : ");
			String s = sc.nextLine();
			a.add(s); // 이름 삽입
		}
		
		// 출력
		for(int i=0; i<a.size(); i++) {
			System.out.println(a.get(i));
		}
		
		// 응용
		int len = 0;
		int lenindex =0;
		for(int i=0; i<a.size(); i++) {
			if(a.get(i).length()>len) {
				len = a.get(i).length();
				lenindex = i;
			}
		}
		// 변수 하나 지우는 방법 ... 이야 똑똑하다 ~~ 
		int index = 0;
		for(int i=1; i<a.size(); i++) {
			if(a.get(index).length() < a.get(i).length()) {
				index = i;
			}
		}
		System.out.println("가장 긴 이름 : "+a.get(lenindex));
	}
}