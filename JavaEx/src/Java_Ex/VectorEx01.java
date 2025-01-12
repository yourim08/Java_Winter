package Java_Ex;


import java.util.Vector;

public class VectorEx01 {
   public static void main(String args[]) {
      Vector<Integer> v = new Vector<Integer>();
      v.add(5);
      v.add(4);
      v.add(-1);
      v.add(2,100); // 4와 -1사이에 100 삽입, 즉 2인덱스에 100 위치
      System.out.println("벡터 내 요소 객체 수 : "+v.size());
      System.out.println("벡터의 현재 용량 : "+v.capacity());
      
      for(int i=0; i<v.size(); i++) {
         int n = v.get(i);
         System.out.println(n);
      }
   }
}