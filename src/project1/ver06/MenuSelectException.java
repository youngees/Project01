package project1.ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelectException extends Exception
{

	public MenuSelectException() {
		super("숫자를 잘못입력하셨습니다.");
	}
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			int user = scanner.nextInt();
			
			if(user>5) {
				MenuSelectException mse = new MenuSelectException();
			}
		}
		catch(InputMismatchException e) {
			//버퍼에 남아있는 엔터키를 제거한다.
			scanner.nextLine();
			System.out.println("입력오류(숫자만 입력하세요)");
		}
		catch(NullPointerException e) {
			
		}
		
	}
}
