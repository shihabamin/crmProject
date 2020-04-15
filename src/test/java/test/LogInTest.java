package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LogInPage;
import util.BrowserFactory;


public class LogInTest {
	
	@Test
	public void logintest() {
		WebDriver driver = BrowserFactory.startBrowser("http://techfios.com/test/billing/?ng=admin/");
		//driver.get("http://techfios.com/test/billing/?ng=admin/");
		
		
		
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		
		
		Assert.assertEquals(loginPage.getPageTitle(), "Login - TechFios Test Application - Billing", "Wrong Page..");
		
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		
		
		DashboardPage dashBoardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		
		Assert.assertEquals(dashBoardPage.getPageTitle(), "Dashboard- TechFios Test Application - Billing", "Wrong Dashboard Page..");
		
		
		//Assert.assertEquals(loginPage.getPageTitle(), "Login - TechFios Test Application - Billing", "Page Title does not match");
		
		
		
		
		
		/*DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.waitForPage();*/
	}

}
