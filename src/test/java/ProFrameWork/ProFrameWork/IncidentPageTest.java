package ProFrameWork.ProFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepos.ObjectRepo;
import Utils.TestUtil;

public class IncidentPageTest extends BaseTest {
	protected IncidentPage ip;
	protected ServiceNowLoginPage lp;
	protected ObjectRepo objrep;

	@Test

	public void incidentCheck() throws Exception {

		ip = new IncidentPage(driver);
		lp = new ServiceNowLoginPage(driver);
		
		driver.switchTo().frame("gsft_main");

		lp.login();

		Assert.assertTrue(ip.filternavbox());

		ip.sendincidentText();
		driver.switchTo().defaultContent();
		
		ip.clickCreateNow();

		ip.giveincidentNumber();
		ip.firstsearch();
		TestUtil.switchToChildWindow();
		driver.manage().window().maximize();
		Assert.assertTrue(ip.checkSearchField());
		ip.sendtextinsearch();
		ip.check();
		TestUtil.switchToParentWindow();
		System.out.println(driver.getTitle());
		driver.switchTo().frame("gsft_main");
		ip.descriptionText();
		
	
	
	 }

}
