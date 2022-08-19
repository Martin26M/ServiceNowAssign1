package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ProFrameWork.ProFrameWork.BaseTest;

public class TestUtil extends BaseTest {

	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	public static XSSFWorkbook workbook;

	public void Takescreenshot(String picname) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+File.separator + "\\Screenshots" + picname + ".png"));

	}

	public ExtentReports reports() {

		reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports");

		reporter.config().getDocumentTitle();
		reporter.config().getReporter();

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		return extent;

	}

	public static String getData(String bookname, String sheetNAme, int rownum, int colnum) throws IOException {

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\HP\\new-workspace2\\ProFrameWork - FlipKart\\" + bookname + ".xlsx");
		workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetNAme);

		XSSFRow row = sheet.getRow(rownum);

		XSSFCell cell = row.getCell(colnum);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {

			data = formatter.formatCellValue(cell);

		} catch (Exception e) {

			data = "";
			e.printStackTrace();

		}

		workbook.close();
		return data;

	}

	public static void switchToChildWindow() {

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String Parent = it.next();
		String Child = it.next();
		driver.switchTo().window(Child);

	}

	public static void switchToParentWindow() {

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String Parent = it.next();
		String Child = it.next();
		driver.switchTo().window(Parent);

	}


public static void callExplicitWait (WebElement element) {
	
	
	WebDriverWait wait =  new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}


}




//
//	public static List<Map<String, String>> readanyDatafromExcel(String bookname, String sheetname) throws IOException {
//
//		File file = new File (System.getProperty("User.dir")+"\\pathname");
//		FileInputStream fis = new FileInputStream(
//				"C:\\Users\\HP\\new-workspace2\\ProFrameWork - FlipKart\\" + bookname + ".xlsx");
//		
//		workbook = new XSSFWorkbook(fis);
//
//		ArrayList<String> list = new ArrayList<String>();
//
//		List<Map<String, String>> allcelldata = new ArrayList<Map<String, String>>();
//
//		TreeMap<String, String> testdata = new TreeMap<String, String>();
//
//		XSSFSheet sheet = workbook.getSheet(sheetname);
//
//		int rowcount = sheet.getLastRowNum();
//		int colcount = sheet.getRow(0).getLastCellNum();
//
//		for (int i = 0; i < colcount; i++) {
//
//			Cell cell = sheet.getRow(0).getCell(i);
//
//			String headerdata = cell.getStringCellValue().trim();
//			list.add(headerdata);
//
//		}
//
//		for (int j = 1; j < rowcount; j++) {
//			
//		Row row= 	sheet.getRow(j);
//		
//		for (int k=0; k<colcount ; k++) {
//			
//		Cell cell =	row.getCell(k);
//	
//	
//	 allcelldata.add(testdata);
//		
//		}
//return allcelldata;
//	}
//
//}}