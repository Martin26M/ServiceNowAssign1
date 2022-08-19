package ProFrameWork.ProFrameWork;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IncidentPage extends BasePage {

	public IncidentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean filternavbox() {

		return filternav.isDisplayed();

	}

	public void sendincidentText() {
		filternav.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('filter').value='Incident'");

		filternav.sendKeys(Keys.BACK_SPACE);
		Actions a = new Actions(driver);
		WebElement ele =driver.findElement(By.xpath(""));
		a.moveToElement(ele).keyDown(ele, Keys.SHIFT).sendKeys("Martin").keyUp(Keys.SHIFT).build().perform();
	}

	public void clickCreateNow() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(CreateNow));

		if (CreateNow.isDisplayed()) {
			CreateNow.click();
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("document.getElementById('concourse_module_14641d70c611228501114133b3cc88a1').click();");

		}

		else {

			throw new Exception("Not able to see CreateNow");
		}
	}

	public String giveincidentNumber() throws Exception {
		driver.switchTo().frame("gsft_main");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(incidentnumber));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String text = (String) js1.executeScript("return document.getElementById('incident.number').value;");

		if (text.contains("INC")) {

			return text;

		}

		else {

			throw new Exception("Not able to find INC  text");

		}

	}

	public void firstsearch() {

		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();

	}

	public boolean checkSearchField() {

		return searchField.isDisplayed();

	}

	public void sendtextinsearch() {

		searchField.sendKeys("Abel Tuter");

	}

	public void check() throws Exception {

		int rowcount = driver.findElements(By.xpath("//tbody[@class='list2_body']/tr")).size();
		int colcount = driver.findElements(By.xpath("//tbody[@class='list2_body']/tr[1]/td")).size();

		for (int i = 1; i < rowcount; i++) {

			for (int j = 1; j < colcount; j++) {

				WebElement data = driver
						.findElement(By.xpath("//tbody[@class='list2_body']/tr[" + i + "]/td[" + j + "]"));

				if (data.getText().equals("Abel Tuter")) {
					WebDriverWait w = new WebDriverWait(driver, 20);
					w.until(ExpectedConditions.visibilityOf(data));
				    Actions a = new Actions(driver);
				    a.moveToElement(driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a"))).click().build().perform();
				    

					System.out.println(data.getText());
					break;

				} else {

					continue;

				}
			}

		}
	}

	public void descriptionText() {

		WebDriverWait w = new WebDriverWait(driver, 50);
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='incident.short_description']"))));
		
		 driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("sdfsdfsd");
	}

	public void clickSubmit() {

		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();

	}

}
