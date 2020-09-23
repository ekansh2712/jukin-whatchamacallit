package JukinMedia.Grails;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class forgotPassword extends base {
	public WebDriver driver;
	forgotPasswordPO fpo;
	
	@Test
	public void fgtPwd1() throws IOException {
		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fpo = new forgotPasswordPO(driver);
		fpo.getforgotPassword().click();
		String Title= driver.getTitle();
		Assert.assertEquals("Forgot Password", Title);
		
	}

	@Test(dataProvider = "getData")
	public void fgtPwd2(String email) throws IOException, InterruptedException {
		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fpo = new forgotPasswordPO(driver);

		fpo.getforgotPassword().click();

		fpo.getEmail().sendKeys(email);
		fpo.emailSubmit().click();
		Thread.sleep(5000);
		if (fpo.submitAlert().isDisplayed()) {
			fpo.submitAlert().click();
			System.out.println("Password reset link sent to your email");
		} else if (!fpo.submitAlert().isDisplayed()) {
			String error = fpo.flashMsg().getText();
			Assert.assertEquals("Please enter a valid email", error);
			System.out.println("Give a valid email");
		}

	}

	@Test
	public void navigatetoLogin() throws IOException, InterruptedException {
		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fpo = new forgotPasswordPO(driver);
		fpo.getforgotPassword().click();
		Thread.sleep(2000);
		fpo.navigateBack().click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Login Page");
		
			
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][1];
		data[0][0] = "ekansh.2711@gmail.com";

		data[1][0] = "ekansh";

		return data;
	}
	
	@AfterMethod
	public void browserclose() {
		driver.close();
	}

}
