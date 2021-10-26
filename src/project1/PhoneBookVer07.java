package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.MenuItem;
import project1.ver06.PhoneBookManager;
import project1.ver06.PhoneInfo;
import project1.ver06.MenuSelectException;

public class PhoneBookVer07
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
			try {
				
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
				if(choice<1 || choice>5) {
					MenuSelectException mse = new MenuSelectException();
					throw mse;
				}
				
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage()); 
			}
			catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("숫자만 입력해주세요.");
			}
			catch(NullPointerException e) {
				System.out.println("검색결과가 없습니다.");
			}
			catch(Exception e) {
				System.out.println("알 수 없는 오류 발생");
				e.printStackTrace();
			}
		}
		
	}
}
