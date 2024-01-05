package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownList {

	public static void  handleSelectClass(WebElement ele, String value) throws IOException {
		
		Select s = new Select(ele);
 		s.selectByVisibleText(value);
	}
}
