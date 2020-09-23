package JukinMedia.Grails;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginpage extends base {
	public WebDriver driver;
	loginPageObjects lpo;

	@Test(dataProvider = "getData")
	public void loginPage(String Username, String Password) throws IOException, InterruptedException {

		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		lpo = new loginPageObjects(driver);
		lpo.getUsername().sendKeys(Username);
		lpo.getPassword().sendKeys(Password);
		Thread.sleep(2000);
		lpo.getSubmit().click();

		String title = driver.getTitle();

		if (title.contains("Login Success")) {
			Assert.assertTrue(lpo.getheaderSuccess().isDisplayed());
			System.out.println("Login Successful");
		} else if (title.contains("Login Page")) {
			String error = lpo.getheaderfail().getText();
			Assert.assertEquals(error, "Incorrect email/password combination");
			System.out.println("Run class forgotPassword to change Password");
		}
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "quality@jukinmedia.com";
		data[0][1] = "Test1ng";

		data[1][0] = "ekansh.2711@gmail.com";
		data[1][1] = "jukinEmployee";

		return data;
	}
	
	@AfterMethod
	public void browserclose() {
		driver.close();
	}

}
