package project1.ver09;

public class DataDeleteSQL extends IConnectImpl
{
	public DataDeleteSQL() {
		super(ORACLE_DRIVER, "kosmo", "1234");
	}
	
	@Override
	public void execute() {
		try {	
			
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			psmt = con.prepareStatement(query);
			
			psmt.setString(1, scanValue("삭제할 이름"));
			//4.쿼리실행 및 출력
			System.out.println(psmt.executeUpdate()+"행이 삭제되었습니다");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new DataDeleteSQL().execute();		
	}
}
