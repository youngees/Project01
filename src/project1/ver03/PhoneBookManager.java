package project1.ver03;

import java.util.Scanner;

public class PhoneBookManager
{
	private PhoneInfo[] myPhone;
	private int phoneData;
	
	Scanner scanner = new Scanner(System.in);
	
	public PhoneBookManager(int num) {
		myPhone = new PhoneInfo[num];
		phoneData = 0;
	}
	//입력
	public void dataInput(int choice) {
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("이름:");
		String name = scanner.nextLine();
		System.out.println("전화번호:");
		String phoneNumber = scanner.nextLine();
		System.out.println("생년월일:");
		String birth = scanner.nextLine();
		
		PhoneInfo po = new PhoneInfo(name, phoneNumber,birth);
		myPhone[phoneData++] = po;
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	//검색
	public void dataSearch(int choice) {
		boolean isFind = false;
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름:");
		String searchName = scanner.nextLine();
		
		for(int i=0 ; i<phoneData ; i++) {
			if(searchName.compareTo(myPhone[i].name)==0) {
				myPhone[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true;
			}
		}
		if(isFind==false) {
			System.out.println("데이터를 찾을 수 없습니다.");
		}
	}
	
	//삭제
	public void dataDelete(int choice) {
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.println("이름:");
		String deleteName = scanner.nextLine();
		int deleteIndex = -1;
		
		for(int i=0 ; i<phoneData ; i++) {
			if(deleteName.compareTo(myPhone[i].name)==0) {

				myPhone[i] = null;
				deleteIndex = i;
				phoneData--;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			for(int i=deleteIndex ; i<phoneData ; i++) {
				myPhone[i] = myPhone[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	
	//전체정보출력
	public void dataAllShow(int choice) {
		for(int i=0 ; i<phoneData ; i++) {
			myPhone[i].showPhoneInfo();
		}
		System.out.println("전체 주소록이 출력되었습니다.");
	}
}
