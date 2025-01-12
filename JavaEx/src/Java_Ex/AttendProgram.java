package Java_Ex;

import java.util.*;
public class AttendProgram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		AttendManager am = new AttendManager();
		while(true) {
			System.out.println("=====출석관리=====");
			System.out.println("1:등록  2:목록  3:출석  4:현황  5:종료");
			int answer = sc.nextInt();
			sc.nextLine();

			// 1:등록
			if(answer == 1) {
				System.out.print("이름 입력 : ");
				String name = sc.nextLine();
				Student s = new Student(name);
				am.setStudent(s); // 배열 등록
			}

			// 2:목록 
			if(answer == 2) {
				System.out.println("목록 : ");
				am.getStudent();
			}

			// 3:출석
			if(answer == 3) {
				System.out.print("출석 학생 이름 : ");
				String attendname = sc.nextLine();
				am.Attend(attendname);
			}

			// 4:출석현황
			if(answer == 4) {
				System.out.println("출석 현황 : ");
				am.AttendList();
			}

			// 5:종료
			if(answer == 5) {
				System.out.println("종료되었습니다...");
				break;
			}
		}
	}
}

class Student{
	private String name;
	private boolean isPresent;

	public Student(String name) {
		this.name=name;
		this.isPresent = false; // 초기 상태 결석
	}

	public String getName() {
		return name;
	}

	public boolean IsPresent() {
		return isPresent;
	}

	public void markPresent() {
		this.isPresent=true;
	}

	public void markAbsent() {
		this.isPresent=false;
	}
}

class AttendManager {
	private ArrayList<Student> students;

	public AttendManager() {
		students = new ArrayList<Student>();  // ArrayList 초기화
	}

	// 등록
	public void setStudent(Student s) {
		for(int i=0; i<students.size(); i++) {
			if((s.getName()).equals(students.get(i).getName())) {
				System.out.println("이미 등록되었습니다!"+"\n");
				return;   // 리턴으로 코드 끊어버리기 ********
			}
		}
		students.add(s);   // 없으면 성공!
		System.out.println("등록 성공!"+"\n");
	}

	public void getStudent() {
		if(students.size() == 0) {
			System.out.println("등록된 학생이 없습니다!"+"\n");
		}
		else {
			for(int i=0; i<students.size(); i++) {
				System.out.println((i+1)+". "+students.get(i).getName());
			}
			System.out.println();
		}
	}

	public void Attend(String name) {
		int count = 0;
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).getName().equals(name)) {
				students.get(i).markPresent();
				System.out.println(students.get(i).getName()+" 출석 처리되었습니다."+"\n");
				break;
			}
			else {
				count++;
			}
		}
		if(count == students.size()) {
			System.out.println("등록되지 않은 이름입니다!"+"\n");
		}
	}

	public void AttendList() {
		for(int i=0; i<students.size(); i++) {
			if(students.get(i).IsPresent() == true) {
				System.out.println((i+1)+". "+students.get(i).getName()+": "+"출석");
			}
			else {
				System.out.println((i+1)+". "+students.get(i).getName()+": "+"결석");
			}
		}
		System.out.println();
	}
}