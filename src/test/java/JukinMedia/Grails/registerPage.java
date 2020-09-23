package JukinMedia.Grails;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class registerPage extends base {
	public WebDriver driver;
	registerpagePO rpo;

	@Test
	public void M1registerNavigate() throws IOException, InterruptedException {
		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rpo = new registerpagePO(driver);
		rpo.registerNew().click();
		Thread.sleep(3000);
		Assert.assertTrue(rpo.registerPageSuccess().isDisplayed());
			
	}

	@Test(dataProvider = "getData")
	public void M2registerNew(String email, String password, String confPassword)
			throws IOException, InterruptedException {

		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rpo = new registerpagePO(driver);
		rpo.registerNew().click();
		Thread.sleep(3000);
		rpo.registerNewEmail().sendKeys(email);
		rpo.registerNewPassword().sendKeys(password);
		rpo.registerConfPassword().sendKeys(confPassword);
		rpo.registernewSubmit().click();
		String title = driver.getTitle();
		if (title.contains("Registration Successful")) {
			if(password.contains("Ekansh.2711@gmail")) {
			System.out.println(rpo.registernewSuccess().getText());
			System.out.println("New User Successfully Registered");
			}
			else if (password.contains("techM"))
			{
				Assert.assertEquals("Script passed without giving any error","Script should fail");
			}
		}
		 else {
			 Thread.sleep(3000);
			String Error = rpo.registernewFail().getText();
			if (email.contains("ekanshTechM")) {
				Assert.assertEquals(Error, "Please enter a valid Email.");
			}
			
			else if (confPassword.contains("ekansh2")) {
				Assert.assertEquals(Error, "Password confirmation must must match Password");
			}
			
			else if (confPassword==" ") {
				Assert.assertEquals(Error, "Please fill out all fields");
			}
			

			System.out.println("Error with data provided");
		}

	}

	@Test
	public void M3NavigateToMain() throws IOException, InterruptedException {
		driver = initializeBrowser();
		driver.get(pro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rpo = new registerpagePO(driver);
		rpo.registerNew().click();
		rpo.backtoLogin().click();
		Thread.sleep(5000);
		String title = driver.getTitle();
		Assert.assertEquals("Login Page", title);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[5][3];
		
		data[0][0] = "ekansh.2711@gmail.com";
		data[0][1] = "Ekansh.2711@gmail";
		data[0][2] = "Ekansh.2711@gmail";

		data[1][0] = "ekansh.2711@gmail.com";
		data[1][1] = "techM";
		data[1][2] = "techM";

		data[2][0] = "ekanshTechM";
		data[2][1] = "ekansh";
		data[2][2] = "ekansh";

		data[3][0] = "ekansh.2711@gmail.com";
		data[3][1] = "ekansh";
		data[3][2] = "ekansh2";
		
		data[4][0] = "ekansh.2711@gmail.com";
		data[4][1] = " ";
		data[4][2] = " ";

		return data;
	}

	@AfterMethod
	public void browserclose() {
		driver.close();
	}

}
