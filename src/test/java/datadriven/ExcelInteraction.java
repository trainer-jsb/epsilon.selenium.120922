package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.Utilities;

public class ExcelInteraction {
	
	String filePath = "src/test/resources/TestExcel.xlsx";
	String sheetName = "Sheet1";
	
	@Test
	public void excelInteractionFromUtilTest() throws IOException {
		Utilities util = new Utilities();
		String cellValue = util.readfromExcel(filePath, sheetName, 2,2);
		System.out.println(cellValue);
	}
	
	@Test
	public void excelInteractionTest() throws IOException {
		FileInputStream oFile = new FileInputStream(new File("src/test/resources/TestExcel.xlsx"));
		DataFormatter df = new DataFormatter();
		String fileExtension = FilenameUtils.getExtension("src/test/resources/TestExcel.xlsx");
		Workbook workbook = null;
		if(fileExtension.equalsIgnoreCase( "xls"))
			workbook = new HSSFWorkbook(oFile);
		else if(fileExtension.equalsIgnoreCase("xlsx"))
			workbook = new XSSFWorkbook(oFile);
		else
			Assert.fail("Incorrect extension provided");
		Sheet oSheet = workbook.getSheet("Sheet1");
		Row oRow = oSheet.getRow(1);
		String cellvalue = df.formatCellValue(oRow.getCell(1));
		System.out.println(cellvalue);
		workbook.close();
	}
}
