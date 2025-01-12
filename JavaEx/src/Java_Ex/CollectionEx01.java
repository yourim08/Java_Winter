package Java_Ex;

import java.util.*;
public class CollectionEx01 {
	public static void main(String args[]) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0, "터미네이터");
		myList.add(2, "아바타");
		
		// 요소 정렬
		Collections.sort(myList);
		printList(myList);
	
		
		// 요소 뒤집기
		Collections.reverse(myList);
		printList(myList);
		
		// 요소 검색
		int index = Collections.binarySearch(myList,"아바타")+1;
		System.out.println("아바타는 "+ index + "번째 요소입니다.");
	}
	
	static void printList(LinkedList<String> l) {
		// 하나씩 검색하는 용도의 Iterator
		Iterator<String> iterator = l.iterator(); // 객체 주입
		while(iterator.hasNext()) { 
			String e = iterator.next();
			String separator;
			if(iterator.hasNext()) {
				separator = "->";
			}
			else {
				separator ="\n";
			}
			System.out.print(e+separator);
		}
	}
}
