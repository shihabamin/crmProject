package page;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddDepositPage extends BasePage{
	
	WebDriver driver;

	public AddDepositPage(WebDriver driver) {
		this.driver = driver;

	}

//Element library 7 total
	// @FindBy(how = How.XPATH, using =
	// "//select[@id='account']/option[@value='Syed']")
	// WebElement AccountDropDown;
	@FindBy(how = How.XPATH, using = "//select[@id='account']")
	WebElement AccountDropDown;
	@FindBy(how = How.ID, using = "description")
	WebElement DescriptionField;
	@FindBy(how = How.ID, using = "amount")
	WebElement AmountField;
	@FindBy(how = How.ID, using = "submit")
	WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "//button[@data-dismiss=\'alert\']")
	WebElement DepositSuccessMsg;
	@FindBy(how = How.XPATH, using = "//h5[text()='Add Deposit']")
	WebElement AddDepositPanelHeading;
	@FindBy(how = How.ID, using = "date")
	WebElement DateField;

	// methods to interact with the elements

	public void waitForPage() {
		//try{
		waitForElement(AddDepositPanelHeading, driver);
//} catch(NoSuchElementException e) (throw new RuntimeException ("Page Title did not display!);}
	}

	public void fillInTheAddDepositForm(String description, String amount) {

		AccountDropDown.click();
		DescriptionField.sendKeys(description);
		AmountField.sendKeys(amount);
		SubmitButton.click();
	}

	public void waitForSuccessMsg() {
		waitForElement(DepositSuccessMsg, driver);

	}

	public void selectFromDropDownForAccount(String string) {
		Select AcctDropDown = new Select(AccountDropDown);
		AcctDropDown.selectByVisibleText(string);
	}

	public void clearTheDateAndInputDate(String string) {
		// TODO Auto-generated method stub
		DateField.clear();
		DateField.sendKeys(string);
	}

	public void inputDescriptionAndAmount(String eDescription, String eAmount) {
		DescriptionField.sendKeys(eDescription);
		AmountField.sendKeys(eAmount);
	}

	public void clickAway() {
		AddDepositPanelHeading.click();
	}

	public void clickOnSubmitButton() {
		SubmitButton.click();
	}

	public boolean isSuccessMsgDisplayed() {

		try {
			return DepositSuccessMsg.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
			// catch (NoSuchElementException e){
			// throw new RuntimeException("I failed the test, not java!")
		}
		// if(DepositSuccessMsg.isDisplayed()==true) {
		// return true;}
		// else return false;
		// return DepositSuccessMsg.isDisplayed();
	}

}
