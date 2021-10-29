package project1.ver09;

import java.sql.SQLException;
import java.util.Scanner;

public class DataSearchQuery extends IConnectImpl
{
	public DataSearchQuery() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	@Override
	public void execute() {
		try {
			stmt = con.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.print("찾는이름:");
			String sename = scanner.nextLine();
			
			String query = "SELECT * FROM phonebook_tb "
					+ " WHERE name LIKE '%"+sename+"%'";
			 
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString("name");
				String phoneNumber = rs.getString("phoneNumber");
				String birth = rs.getString("birth");

				System.out.printf("%s %s %s %s\n",id, name, phoneNumber, birth);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close(); 
		}
	}
	public static void main(String[] args) {
		DataSearchQuery selectSQL = new DataSearchQuery();
		selectSQL.execute();
	}
}
