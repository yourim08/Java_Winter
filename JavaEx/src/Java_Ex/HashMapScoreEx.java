package Java_Ex;


import java.util.*;
public class HashMapScoreEx {
	public static void main(String args[]) {
		HashMap<String, Integer> javaScore = new HashMap<String,  Integer>();
		javaScore.put("전유림",95);
		javaScore.put("조현서",90);
		javaScore.put("황기태",88);
		javaScore.put("이재문",70);
		javaScore.put("한원선",78);
		
		System.out.println("HashMap의 요소 개수 : "+javaScore.size());
		
		// key문자열을 가진 집합 Set컬렉션 리턴
		Set<String> keys = javaScore.keySet();
		
		// key 문자열에 순서대로 접근하는 Iterator
		Iterator<String> it = keys.iterator();
		
		while(it.hasNext()) {
			String name = it.next();
			int score = javaScore.get(name); // 이름을 key로 해서 점수를 검색함
			System.out.println(name+" : "+score);
		}
	}
}
