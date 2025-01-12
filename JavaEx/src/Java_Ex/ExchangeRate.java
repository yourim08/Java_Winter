package Java_Ex;


import java.util.InputMismatchException;
import java.util.Scanner;
public class ExchangeRate {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      while(true) {
         try {
            System.out.print("나라를 선택하세요 (1:한국, 2:다른나라) : ");
            int answer = sc.nextInt();
            if(answer == 1) {
               System.out.print("금액을 입력하세요 (단위:원) : ");
               double money = sc.nextDouble();
               System.out.print("나라를 선택하세요 (1:미국, 2:중국, 3:일본) : ");
               int country = sc.nextInt();
               switch(country) {
               case 1 : 
                  System.out.print("환율을 입력하세요 : ");
                  double USD = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"달러",(money*USD));
                  break;
               case 2 : 
                  System.out.print("환율을 입력하세요 : ");
                  double CHN = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"위안",(money*CHN)); 
                  break;
               case 3 :
                  System.out.print("환율을 입력하세요 : ");
                  double JAP = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"엔",(money*JAP)); 
                  break;
               default : System.err.println("올바른 값을 입력하시오!");
               break;
               }
               System.out.println();
               System.out.println();
               System.out.println("1: 계속하기, 2:종료");
               int answer1 = sc.nextInt();
               if(answer1==2) {
                  break;
               }
            }
            else if (answer == 2) {
               System.out.print("금액을 입력하세요 : ");
               double money = sc.nextDouble();
               System.out.print("나라를 선택하세요 (1:미국, 2:중국, 3:일본, 4:한국) : ");
               int country = sc.nextInt();
               switch(country) {
               case 1 : 
                  System.out.print("환율을 입력하세요 : ");
                  double USD = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"달러",(money*USD));
                  break;
               case 2 : 
                  System.out.print("환율을 입력하세요 : ");
                  double CHN = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"위안",(money*CHN)); 
                  break;
               case 3 :
                  System.out.print("환율을 입력하세요 : ");
                  double JAP = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"엔",(money*JAP)); 
                  break;
               case 4 :
                  System.out.print("환율을 입력하세요 : ");
                  double KOR = sc.nextDouble();
                  System.out.printf("결과 : "+"%.3f"+"원",(money*KOR)); 
                  break;
               default : System.err.println("올바른 값을 입력하시오!");
               break;
               }
               System.out.println();
               System.out.println();
               System.out.println("1: 계속하기, 2:종료");
               int answer2 = sc.nextInt();
               if(answer2==2) {
                  break;
               }
            }
         }
         catch(InputMismatchException e) {
            System.err.println("올바른 금액을 입력하시오!");
            sc.nextLine();
         }
      }
      sc.close();
   }
}
