package project1.ver09;

import java.util.Scanner;

public class DataInputSQL extends IConnectImpl
{
	public DataInputSQL() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {
			
			String query = "INSERT INTO phonebook_tb VALUES "
					+ " (seq_phonebook.NEXTVAL,?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			
			//3.입력할 내용을 사용자로부터 입력받는다. 
			
			Scanner scan = new Scanner(System.in);
			System.out.print("아이디:");
			String id = scan.nextLine();
			System.out.print("이름:");
			String name = scan.nextLine();
			System.out.print("전화번호:");
			String phoneNumber = scan.nextLine();
			System.out.print("생년월일:");
			String birth = scan.nextLine();
			
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setString(3, phoneNumber);
			psmt.setString(4, birth);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new DataInputSQL().execute();
	}
}
