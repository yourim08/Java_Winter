package Java_Ex;


import java.util.*;
public class HashMapEx02 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		var map = new HashMap<String, Student02>();
		map.put("전유림", new Student02(1, "010-1111-1111"));
		map.put("황기태", new Student02(2, "010-2222-2222"));
		map.put("이재문", new Student02(3, "010-3333-3333"));
		
		while(true) {
			System.out.print("검색할 이름 : ");
			String name = sc.next();
			if(name.equals("종료")) {
				System.out.println("종료됨...");
				break;
			}
			Student02 s = map.get(name);
			if(s == null) {
				System.out.println(name+"은 없는 사람입니다!");
			}
			else {
				System.out.println("id: "+s.id+"\n"+"tel: "+s.tel);
			}
		}
	}
}

class Student02{
	int id;
	String tel;
	public Student02(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
}
	