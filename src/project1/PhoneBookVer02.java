package project1;

import java.util.Scanner;
import project1.ver02.PhoneInfo;

public class PhoneBookVer02
{
	public static void main(String[] args)
	{
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			int user = 0;
			
			System.out.println("선택하세요..");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택:");
			user = scanner.nextInt();
			scanner.nextLine();//버퍼날리기
			
			if(user==1) {
				
				System.out.println("이름:");
			    String name = scanner.nextLine();
				
				System.out.println("전화번호:"); 
				String phoneNumber = scanner.nextLine();
				
				System.out.println("생년월일:"); 
				String birth = scanner.nextLine();
				
				PhoneInfo pcc2 = new PhoneInfo(name,phoneNumber,birth);
				System.out.println("입력된 정보 출력...");
				pcc2.showPhoneInfo();
				System.out.println();
				
			}
			else if(user==2){
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else {
				System.out.println("숫자를 잘못 입력하셨습니다.");
			}
			
		}
		
	}
}
