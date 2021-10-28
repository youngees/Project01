package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager
{
	
	HashSet<PhoneInfo> PhoneSet =  new HashSet<PhoneInfo>();
	
	Scanner scanner = new Scanner(System.in);
	
	public PhoneBookManager(int num) {
		PhoneSet = new HashSet<PhoneInfo>();
	}
	
	//메뉴출력
	public void printMenu() {
		System.out.println("메뉴를 선택하세요.");
		System.out.println("1.주소록 입력");
		System.out.println("2.검색");
		System.out.println("3.삭제");
		System.out.println("4.출력");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴선택:");
	}
	
	//입력
	public void dataInput(int choice) {
		
		int user = 0;
		System.out.println("==주소록을 입력함==");
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반 2.동창 3. 회사");
		System.out.println("선택>>");
		user= scanner.nextInt();
		scanner.nextLine();
		
		
		String name, phoneNumber;
		System.out.println("이름:");
		name = scanner.nextLine();
		System.out.println("전화번호:");
		phoneNumber = scanner.nextLine();
		
		PhoneInfo phoneInfo = null;
		
		if(user==SubMenuItem.NORMAL) {
			
			phoneInfo = new PhoneInfo(name, phoneNumber);
		}
		else if(user==SubMenuItem.SCHOOL) {
			
			System.out.println("전공:");
			String major = scanner.nextLine();
			System.out.println("학년:");
			int grade = scanner.nextInt();
			
			phoneInfo = new PhoneSchoolInfo(name, phoneNumber, major, grade);
		}
		else if(user==SubMenuItem.COMPANY) {
			
			System.out.println("회사:");
			String companyName = scanner.nextLine();
			
			phoneInfo = new PhoneCompanyInfo(name, phoneNumber, companyName);
			
		}
		
		//중복체크
		boolean recheck = PhoneSet.add(phoneInfo);
		if(recheck==true) {
			System.out.println("===입력이완료되었습니다===");
		}
		else {
			System.out.println("이미 저장된 데이터입니다.");
			System.out.println("덮어쓸까요? Y(y) / N(n)");
			String rewrite = scanner.nextLine();
						
			if(rewrite.equalsIgnoreCase("Y")) {
				PhoneSet.remove(phoneInfo);
				PhoneSet.add(phoneInfo);
				
				System.out.println("입력한 정보가 저장되었습니다.");
			}
			else if(rewrite.equalsIgnoreCase("N")) {
				System.out.println("기존 정보를 유지합니다.");	
			}
		}
	}
	
	//검색
	public void dataSearch(int choice) {
		boolean isFind = false;
		System.out.println("데이터 검색을 시작합니다..");
		System.out.println("이름:");
		String searchName = scanner.nextLine();
		
		Iterator<PhoneInfo> itr = PhoneSet.iterator(); //객체생성
		while(itr.hasNext()) {
			PhoneInfo po = itr.next();
			//검색할 이름과 이터레이터를 통해 반환되는 객체의 이름을 비교
			if(searchName.equals(po.getName())) {
				po.showPhoneInfo();
				System.out.println("검색이 완료되었습니다.");
				isFind = true; //정보를 찾았다면 변경
			}
			
		}	
		if(isFind==false) System.out.println("해당 데이터를 찾을 수 없습니다.");
		
	}
	//삭제
	public void dataDelete(int choice) {
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.println("이름:");
		String deleteName = scanner.nextLine();
		int deleteIndex = -1;
		
		Iterator<PhoneInfo> itr = PhoneSet.iterator(); 
		while(itr.hasNext()) {
			
			PhoneInfo po = itr.next();
			if(deleteName.compareTo(po.name)==0) {
				PhoneSet.remove(po);
				deleteIndex = 1;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("삭제된 데이터가 없습니다.");
		}
		else {
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	
	//전체정보출력
	public void dataAllShow(int choice) {
		System.out.println("==주소록을 출력함==");
		for(PhoneInfo po : PhoneSet) {
			po.showPhoneInfo();
		}
		System.out.println("===주소록 출력이 완료되었습니다===");
	}
}
