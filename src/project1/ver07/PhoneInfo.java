package project1.ver07;

import java.util.Objects;

public class PhoneInfo
{
	String name; //이름
	String phoneNumber; //전화번호 
	
	
	//3개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo()
	{
		System.out.println("이름:"+name); 
		System.out.println("전화번호:"+phoneNumber); 
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		PhoneInfo po = (PhoneInfo)obj;
		if(po.name.equals(this.name)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
