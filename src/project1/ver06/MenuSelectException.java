package project1.ver06;

import project1.ver06.MenuItem;
import project1.ver06.PhoneBookManager;

public class MenuSelectException extends Exception
{
	public MenuSelectException() {
		super("숫자를 잘못입력하셨습니다.");
	}
}
