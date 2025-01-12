package Java_Ex;


import java.util.Vector;

public class VectorEx02 {
   public static void main(String args[]) {
      Vector<Point01> v = new Vector<Point01>();
      // 3개의 Point 객체 삽입
      v.add(new Point01(2,3));
      v.add(new Point01(-5,20));
      v.add(new Point01(30,-8));
      
      // 하나 지우기
      v.remove(1);
      
      //풀력하기
      for(int i=0; i<v.size(); i++) {
         Point01 p = v.get(i);
         System.out.println(p);
      }
   }
}

class Point01 {
   private int x, y;
   public Point01 (int x, int y) {
      this.x = x;
      this.y = y;
   }
   // toString 메소드는 객체를 호출할 때 자동으로 호출됨. 얘만 그래요 얘만...*****
   public String toString() {
      return "("+x+","+y+")";
   }
}