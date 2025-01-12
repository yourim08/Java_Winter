package Java_Ex;


import java.util.*;
public class Dice2 {
	public static void main(String args[]) {
		Scanner sx = new Scanner(System.in);
		DiceRoll d = new DiceRoll();
		int acount = 0;
		int bcount = 0;
		d.SetName();
		while(true) {
			// 1회
			System.out.println(d.a+"님의 첫번째 주사위 : "+d.ARoll());
			System.out.println(d.b+"님의 첫번째 주사위 : "+d.BRoll());
			// 2회
			System.out.println(d.a+"님의 두번째 주사위 : "+d.ARoll());
			System.out.println(d.b+"님의 두번째 주사위 : "+d.BRoll());

			// 합 비교
			if(d.asum>10) {
				System.out.println(d.a+"의 합이 너무 큽니다. 패배 ㅠㅠ");
				bcount++;
				d.Reset();
			}
			if(d.bsum>10) {
				System.out.println(d.b+"의 합이 너무 큽니다. 패배 ㅠㅠ");
				acount++;
				d.Reset();
			}
			else if(d.asum>d.bsum) {
				System.out.println(d.a+"가 이겼습니다!");
				acount++;
				d.Reset();
			}
			else if(d.bsum>d.asum) {
				System.out.println(d.b+"가 이겼습니다!");
				bcount++;
				d.Reset();
			}
			else if(d.asum==d.bsum) {
				System.out.println("비겼습니다!");
				d.Reset();
			}
			else if(d.asum>10 && d.bsum>10) {
				System.out.println("둘다 10 초과! 다시시작!");
				d.Reset();
			}
			
			// 다시하기
			System.out.print("\n"+"1:계속하기  2:종료 ");
			int answer = sx.nextInt();
			if(answer == 2) {
				System.out.println("=== 전체 승수 ===");
				System.out.println(d.a+" : "+acount + "\n"+d.b+" : "+bcount);
				break;
			}
		}
	}
}

class DiceRoll{
	private int aran;
	private int bran;
	int asum = 0;
	int bsum = 0;
	String a;
	String b;
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	public void SetName() {
		System.out.println("=====주사위 게임2=====");
		System.out.print("플레이어 1 : ");
		a = sc.nextLine();
		System.out.print("플레이어 2 : ");
		b = sc.nextLine();
	}
	public int ARoll() {
		aran = ran.nextInt(6)+1;
		asum+=aran;
		return aran;
	}
	public int BRoll() {
		bran = ran.nextInt(6)+1;
		bsum+=bran;
		return bran;
	}
	public void Reset() {
		this.asum = 0;
		this.bsum = 0;
	}
}
