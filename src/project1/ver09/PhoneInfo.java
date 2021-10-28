package project1.ver09;

public class PhoneInfo
{
	String name; //이름
	String phoneNumber; //전화번호 
	String birthday; //생년월일 
	
	//3개의 매개변수를 가진 생성자
	public PhoneInfo(String name, String phoneNumber, String birthday)
	{
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}
	//2개의 매개변수를 가진 생성자 오버로딩
	public PhoneInfo(String name, String phoneNumber)
	{
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthday = "입력되지않음";
	}
	public void showPhoneInfo()
	{
		System.out.println("이름:"+name); 
		System.out.println("전화번호:"+phoneNumber); 
		System.out.println("생년월일:"+birthday); 
	}
	
}
