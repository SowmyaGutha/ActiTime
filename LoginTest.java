package TestCase;

import Actitime.LoginPage;
import Generic.ExcelRead;
import Generic.GenericMethods;

public class LoginTest {

	public static String xlpath = "C:\\Users\\sg830q\\Sudheer\\sample\\ActiTime\\Testdata.xlsx";
	public static String SheetName = "Sheet1";
	public static String URL ="https://online.actitime.com/abc7/login.do";

	public static void main(String[] args) throws InterruptedException {

		ExcelRead excel = new ExcelRead();
		int rowcount = excel.getExcelRowCount(xlpath, SheetName);
		System.out.println(rowcount);

		LoginPage p = new LoginPage();
		GenericMethods g = new GenericMethods();
		g.browserInitiate(URL);
		for (int i = 1; i <= rowcount; i++) {
			String username = excel.getExcelCellValue(xlpath, SheetName, i, 0);
			String password = excel.getExcelCellValue(xlpath, SheetName, i, 1);
			System.out.println(username + " " + password);
			p.login(username, password);
			// p.login();
			p.logout();
		}
		g.browserClose();

	}

}
