package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.AddDepositPage;
import page.DashboardPage;
import page.LogInPage;
import util.BrowserFactory;

public class AddDepositTest {
	
	@Test
	public void validateDeposits() throws InterruptedException {

		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=admin/");

		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		loginPage.login("techfiosdemo@gmail.com", "abc123");

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.waitForPage();

		// step: click on the add deposit button
		dashboardPage.clickOnAddDepositButton();

		// activate add deposit page
		AddDepositPage addDepositPage = PageFactory.initElements(driver, AddDepositPage.class);

		// validate Add deposit Page opened (waitForPage)
		addDepositPage.waitForPage();

		// a method to select a specific info from a drop down
		addDepositPage.selectFromDropDownForAccount("AutoAccount");

		addDepositPage.clearTheDateAndInputDate("2019-08-12");
		addDepositPage.clickAway();

		Thread.sleep(4000);

		// initiate random class
		Random random = new Random();
		// storage for description and amount
		String eDescription = "TestDescription" + String.valueOf(random.nextInt(999));
		String eAmount = String.valueOf(random.nextInt(99999));

		// method to input description and amount
		addDepositPage.inputDescriptionAndAmount(eDescription, eAmount);

		// click on submit button
		addDepositPage.clickOnSubmitButton();

		// Explicit wait validation
		addDepositPage.waitForSuccessMsg();

		// Assertion class to validate
		//Assert.assertTrue("Success Message did not show", addDepositPage.isSuccessMsgDisplayed());

		// call the fill in the form method
		// String description = "Lunch Money";
		// addDepositPage.fillInTheAddDepositForm(description, "55");

		// addDepositPage.waitForSuccessMsg();
		driver.close();
		driver.quit();

	}

}
