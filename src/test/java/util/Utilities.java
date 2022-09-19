package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Utilities {
	
	public String readfromExcel(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
		FileInputStream oFile = new FileInputStream(new File(filePath));
		DataFormatter df = new DataFormatter();
		String fileExtension = FilenameUtils.getExtension(filePath);
		Workbook workbook = null;
		if(fileExtension.equalsIgnoreCase( "xls"))
			workbook = new HSSFWorkbook(oFile);
		else if(fileExtension.equalsIgnoreCase("xlsx"))
			workbook = new XSSFWorkbook(oFile);
		else
			Assert.fail("Incorrect extension provided");
		Sheet oSheet = workbook.getSheet(sheetName);
		Row oRow = oSheet.getRow(rowNum-1);
		String cellvalue = df.formatCellValue(oRow.getCell(colNum-1));
		workbook.close();
		return cellvalue;
	}

	public String getPropertyValue(String filePath, String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		return prop.getProperty(key);
	}

	public String timestamp() {
		DateFormat dateFormat = new SimpleDateFormat("_yyyyMMdd_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}