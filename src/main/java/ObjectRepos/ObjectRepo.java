package ObjectRepos;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ObjectRepo  {

	@FindBy(xpath="//input[@name='user_name']") public     WebElement userNAme;
	@FindBy(xpath="//input[@name='user_password']") protected  static  WebElement pname;	
	@FindBy (xpath="//div[@class='clearfix']/a") protected static WebElement fogpwd;
	@FindBy (xpath="//button[@id='sysverb_login']") protected static WebElement logbutton;
	@FindBy (xpath="//input[@placeholder='Filter navigator']") public   WebElement filternav;
	@FindBy (xpath="//ul[@id='concourse_application_tree']//li[@id='concourse_application_dead1309c611228701e2bda7b4252474']/ul/li[1]") protected static WebElement CreateNow;
	@FindBy (xpath="//input[@name='incident.number']") protected static WebElement incidentnumber;
	@FindBy(xpath="//input[@placeholder='Search' and @class='form-control']") protected static WebElement searchField;
	
}
