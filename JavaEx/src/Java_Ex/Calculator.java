package Java_Ex;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Calculator {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      while(true) {
         try {
            System.out.print("두 수를 입력하시오 : ");
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            sc.nextLine();
            System.out.print("연산자를 입력하시오 : ");
            String c = sc.nextLine();
            if(!c.equals("+") &&!c.equals("-")&&!c.equals("*")
                  &&!c.equals("/")&&!c.equals("%")) {
               System.err.println("올바른 값을 입력해주세요!");
            }
            else if(c.equals("+")) {
               System.out.println("결과 : "+(a+b));
            }
            else if(c.equals("-")) {
               System.out.println("결과 : "+(a-b));
            }
            else if(c.equals("*")) {
               System.out.println("결과 : "+(a*b));
            }
            else if(c.equals("/")) {
               if(b == 0) {
                  System.err.println("0으로 나눌 수 없습니다!");
                  continue;
               }
               System.out.println("결과 : "+(a/b));
            }
            else if(c.equals("%")) {
               System.out.println("결과 : "+(a%b));
            }
            System.out.print("계속하시겠습니까? (1:예, 2:아니오) ");
            int answer = sc.nextInt();
            if(answer == 2) {
               break;
            }
         }
         catch(InputMismatchException e) {
            System.err.println("올바른 값을 입력해주세요!");
            sc.nextLine();
         }
      }
      sc.close();
   }
}
