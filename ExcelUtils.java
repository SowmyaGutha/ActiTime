package Mypackage;

import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelUtils {

	Workbook work_book;
	static Sheet sh_sheet;

	public void setExcelFile(String ExcelPath) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(ExcelPath);
			work_book = Workbook.getWorkbook(fis);
			sh_sheet = work_book.getSheet(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		return sh_sheet.getCell(RowNum, ColNum).getContents();
	}

	public static int getRowCount(String SheetName) {
		return sh_sheet.getRows();
	}

	public int getColCount() {
		return sh_sheet.getColumns();
	}

	public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int iRowNum = 0;
		try {
			// ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtils.getRowCount(SheetName);
			for (; iRowNum < rowCount; iRowNum++) {
				if (ExcelUtils.getCellData(iRowNum, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());

		}
		return iRowNum;
	}

	public static int getTestStepsCount(String SheetName, String sTestCaseID, int iTestCaseStart) throws Exception {
		try {
			for (int i = iTestCaseStart; i <= ExcelUtils.getRowCount(SheetName); i++) {
				if (!sTestCaseID.equals(ExcelUtils.getCellData(i, Constants.Col_TestCaseID, SheetName))) {
					int number = i;
					return number;
				}
			}
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int number = ExcelWSheet.getLastRowNum() + 1;
			return number;
		} catch (Exception e) {
			System.out.println("Class Utils | Method getRowContains | Exception desc : " + e.getMessage());
			DriverScript.bResult = false;
			return 0;
		}
	}

	@SuppressWarnings("static-access")
	public static void setCellData(String Result, int RowNum, int ColNum, String SheetName) throws Exception {
		try {

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}
			FileOutputStream fileOut = new FileOutputStream(Constants.Path_TestData);
			ExcelWBook.write(fileOut);
			// fileOut.flush();
			fileOut.close();
			ExcelWBook = new XSSFWorkbook(new FileInputStream(Constants.Path_TestData));
		} catch (Exception e) {
			DriverScript.bResult = false;

		}
	}

}
