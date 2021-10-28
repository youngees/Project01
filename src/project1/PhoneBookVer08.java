package project1;

import java.util.InputMismatchException;
import java.util.Scanner;
import project1.ver08.MenuSelectException;
import project1.ver08.AutoSaverT;
import project1.ver08.MenuItem;
import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;

public class PhoneBookVer08
{
	
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		AutoSaverT as = new AutoSaverT(pbm);

		while(true) {
			try {
				
				pbm.printMenu();
				
				int choice = scanner.nextInt();
				
				switch(choice) {
				case MenuItem.INPUT: 
					//데이터 입력
					pbm.dataInput();
					System.out.println();
					break;
				case MenuItem.SEARCH:
					//데이터 검색
					pbm.dataSearch();
					System.out.println();
					break;
				case MenuItem.DELETE:
					//데이터 삭제
					pbm.dataDelete();
					System.out.println();
					break;
				case MenuItem.SHOW:
					//주소록 출력
					pbm.dataAllShow();
					System.out.println();
					break;
				case MenuItem.OPTION:
					//자동저장
					if(!as.isAlive()) {
						as = new AutoSaverT(pbm);
						pbm.autosave(as);
					}
					else {
						pbm.autosave(as);
					}
					break;
				case MenuItem.TERMINATE:
					//프로그램 종료
					pbm.savePhoneInfo();
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
