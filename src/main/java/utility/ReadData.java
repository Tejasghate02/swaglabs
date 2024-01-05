package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	//to read all the important data
	public static String readPropertyFile(String value) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("/Users/kalyanighate/eclipse-workspace/seleniumFramework/testData/config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	//to read exel data
	public static String readExelData(int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("/Users/kalyanighate/Downloads/seleniumFiles/sheet1.xlsx");
	    org.apache.poi.ss.usermodel.Sheet es = WorkbookFactory.create(file).getSheet("sheet1");
	    String value = ((org.apache.poi.ss.usermodel.Sheet) es).getRow(rowNum).getCell(colNum).getStringCellValue();
	    return value;
	}
}
