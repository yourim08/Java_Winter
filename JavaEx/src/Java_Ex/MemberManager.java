package Java_Ex;


import java.util.*;
public class MemberManager {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		var list = new HashMap<Integer, Member>();
		int count = 1;
		while(true) {
			System.out.println("=====회원관리=====");
			System.out.println("1:등록  2:수정  3:삭제  4:검색  5:목록  6:종료");
			System.out.print("선택 : ");
			int answer = sc.nextInt();

			// 1:등록
			try {
				if(answer == 1) {
					System.out.print("이름 : ");
					String name = sc.next();
					System.out.print("나이 : ");
					int age = sc.nextInt();
					System.out.print("성별 : ");
					String gender = sc.next();
					System.out.print("전화번호 : ");
					String tel = sc.next();
					sc.nextLine();
					System.out.print("주소 : ");
					String address = sc.nextLine();
					System.out.print("비고 : ");
					String extra = sc.next();
					list.put(count, new Member(name, age, gender, address, tel, extra));
					System.out.println("등록 성공! 회원님의 ID: "+count+"\n");
					count++;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("올바른 숫자를 입력하시오!"+"\n");
				sc.nextLine();
			}
			// 2:수정
			if(answer == 2) {
				System.out.println("회원님의 ID: ");
				int ID = sc.nextInt();
				if(!list.containsKey(ID)) {
					System.out.println("존재하지 않는 회원입니다!"+"\n");
				}
				else {
					list.get(ID).Edit(ID);
				}
			}

			// 3:삭제 
			if(answer == 3) {
				System.out.print("삭제할 ID: ");
				int Delete = sc.nextInt();
				if(!list.containsKey(Delete)) {
					System.out.println("존재하지 않는 회원입니다!"+"\n");
				}
				else{
					list.remove(Delete);
					System.out.println("삭제 성공!"+"\n");
				}
			}

			// 4:검색
			if(answer == 4) {
				System.out.print("검색할 ID: ");
				int Search = sc.nextInt();
				if(!list.containsKey(Search)) {
					System.out.println("존재하지 않는 회원입니다!"+"\n");
				}
				else {
					list.get(Search).Find(Search);
				}
			}

			// 5:목록
			if(answer == 5) {
				int n = 1;
				if(list.size()==0) {
					System.out.println("등록된 회원이 없습니다!"+"\n");
				}
				else {
					System.out.println("회원 목록: ");
					for(int i=0; i<=list.size(); i++) {
						// 해시맵은 안채워짐... 그래서 containsKey 사용, 없으면 continue!
						if(list.containsKey(i+1)) {
							System.out.println(n+". "+list.get(i+1).print());
							n++;
						}
						else {
							continue;
						}
					}
					System.out.println();
				}
			}

			// 6:종료 
			if(answer == 6) {
				System.out.println("종료되었습니다...");
				break;
			}
		}
	}
}

class Member{
	String name;
	String gender;
	String tel;
	String address;
	String extra;
	int age;
	Scanner sx = new Scanner(System.in);

	public Member(String name, int age, String gender, String address, String tel, String extra) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.tel = tel;
		this.extra = extra;
		this.address =address;
	}

	public void Edit(int ID) {
		System.out.println("수정하려는 정보 선택"+"\n"+"(1:이름 2:나이 3:성별 "+"\n"+"4:전화번호 5:주소 6:비고) : ");
		int editNumber = sx.nextInt();
		if(editNumber == 1) {
			System.out.print("이름 : ");
			String Ename = sx.next();
			this.name = Ename;
			System.out.println("수정 성공! "+"\n");
		}
		if(editNumber == 2) {
			System.out.print("나이 : ");
			int Eage = sx.nextInt();
			this.age = Eage;
			System.out.println("수정 성공! "+"\n");
		}
		if(editNumber == 3) {
			System.out.print("성별 : ");
			String Egender = sx.next();
			this.gender = Egender;
			System.out.println("수정 성공! "+"\n");
		}
		if(editNumber == 4) {
			System.out.print("전화번호 : ");
			String Etel = sx.next();
			this.tel = Etel;
			System.out.println("수정 성공! "+"\n");
		}
		if(editNumber == 5) {
			sx.nextLine();
			System.out.print("주소 : ");
			String Eaddress = sx.nextLine();
			this.address = Eaddress;
			System.out.println("수정 성공! "+"\n");
		}
		if(editNumber == 6) {
			System.out.print("비고 : ");
			String Eextra = sx.next();
			this.address = Eextra;
			System.out.println("수정 성공! "+"\n");
		}
	}

	public void Find(int Search) {
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("성별 : "+gender);
		System.out.println("전화번호 : "+tel);
		System.out.println("주소 : "+address);
		System.out.println("비고 : "+extra+"\n");
	}

	public String print(){
		return name;
	}
}
