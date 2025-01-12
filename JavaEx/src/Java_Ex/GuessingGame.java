package Java_Ex;

import java.util.Scanner;
public class GuessingGame {
	GuessingGame(){
		int ran;
		int answer;
		System.out.println("=======숫자 맞추기 게임=======");
		ran = (int)(Math.random()*100)+1;
		Scanner sc = new Scanner(System.in);
		int numberOfTries = 0;
		do {
			System.out.print("숫자 입력 : ");
			answer = sc.nextInt();
			numberOfTries++;
			if(answer>ran) {
				System.out.println("Down!");
			}
			else if(answer<ran) {
				System.out.println("Up!");
			}
			System.out.println("시도 횟수 : "+numberOfTries);
		}while(ran!=answer);
		System.out.println("정답입니다!");
	}

	public static void main(String args[]) {
		new GuessingGame();
	}
}