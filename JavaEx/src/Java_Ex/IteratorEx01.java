package Java_Ex;


import java.util.*;

public class IteratorEx01 {
	public static void main(String args[]) {
		var v = new Vector<Integer>();
		v.add(5);
		v.add(4);
		v.add(-1);
		v.add(2,100);
		
		// Iterator을 이용한 출력
		Iterator<Integer> it = v.iterator();
		while(it.hasNext()) {  // 다음을 가진다면,,, (boolean함수)
			int n = it.next(); // 다음값을 n에 넣기.
			System.out.println(n);
		}
		
		// Iterator을 이용한 덧셈
		int sum = 0;
		it = v.iterator(); // Iterator 객체 얻기
		while(it.hasNext()) {
			int m = it.next();
			sum+=m;
		}
		System.out.println("합 : "+sum);
	}
}
