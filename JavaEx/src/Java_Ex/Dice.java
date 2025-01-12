package Java_Ex;


import java.util.*;
public class Dice {
	public static void main(String argsp[]) {
		new Dice();
	}
	
	Dice () {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int life = 10;
		int score = 0;
		System.out.println("=====주사위 게임=====");
		System.out.print("닉네임 : ");
		String name = sc.nextLine();
		while(true) {
			int Cran = ran.nextInt(5)+1;
			int MYran = ran.nextInt(5)+1;
			System.out.println("\n"+"com : "+Cran);
			System.out.println(name+" : "+MYran);
			if(Cran>MYran) {
				System.out.println("컴퓨터 승!"+"\n");
				life-=1;
				if(life==0) {
					System.out.println("라이프 0! 패배 ㅠㅠ");
					break;
				}
				System.out.println("현재 라이프 : "+life);
				System.out.println("현재 스코어 : "+score+"\n");
				System.out.println("1:계속하기  2:종료");
				int answer = sc.nextInt();
				sc.nextLine();
				if(answer == 2) {
					break;
				}
			}
			else if(Cran<MYran) {
				System.out.println(name+" 승!"+"\n");
				score+=10;
				if(score == 100) {
					System.out.println("스코어 100! 승리 ^ㅁ^");
					break;
				}
				System.out.println("현재 라이프 : "+life);
				System.out.println("현재 스코어 : "+score+"\n");
				System.out.println("1:계속하기  2:종료");
				int answer = sc.nextInt();
				sc.nextLine();
				if(answer == 2) {
					break;
				}
			}
			else if(Cran == MYran) {
				System.out.println("비김!"+"\n");
				System.out.println("현재 라이프 : "+life);
				System.out.println("현재 스코어 : "+score+"\n");
				System.out.println("1:계속하기  2:종료");
				int answer = sc.nextInt();
				sc.nextLine();
				if(answer == 2) {
					break;
				}
			}
		}
	}
}



