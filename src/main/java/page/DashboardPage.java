package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage{
	
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(), 'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit") WebElement AddDepositButton;
	
	
	public void waitForPage() {
		
		waitForElement(PageTitle, driver);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(PageTitle));
		
	}
		public void clickOnAddDepositButton() {
			AddDepositButton.click();
		}
	/*public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}*/
		public String getPageTitle() {
			driver.getTitle();
			return null;
		}

}
