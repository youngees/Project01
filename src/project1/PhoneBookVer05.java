package project1;

import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;
import project1.ver05.PhoneInfo;

public class PhoneBookVer05
{
	public static void printMenu() {
		System.out.println("선택하세요..");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택:");
	}
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		
		while(true) {
			
			printMenu();
			
			int choice = scanner.nextInt();
			switch(choice) {
			case MenuItem.INPUT: 
				//데이터 입력
				pbm.dataInput(choice);
				System.out.println();
				break;
			case MenuItem.SEARCH:
				//데이터 검색
				pbm.dataSearch(choice);
				System.out.println();
				break;
			case MenuItem.DELETE:
				//데이터 삭제
				pbm.dataDelete(choice);
				System.out.println();
				break;
			case MenuItem.SHOW:
				//주소록 출력
				pbm.dataAllShow(choice);
				System.out.println();
				break;
			case MenuItem.TERMINATE:
				//프로그램 종료
				System.out.println("프로그램종료");
				return;
			}
			
		}
		
	}
}