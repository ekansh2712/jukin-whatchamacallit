package JukinMedia.Grails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class forgotPasswordPO {

	public WebDriver driver;

	By forgotPassword = By.xpath("//a[contains(text(),'Forgot Password?')]");
	By email = By.cssSelector("input[id='fp.email']");
	By emailSubmit = By.id("forgotPasswordButton");
	By flashMsg = By.xpath("//div[@id='flashMsg']");
	By submitAlert = By.xpath("//button[@class='btn btn-primary']");
	By navBack = By.xpath("//a[contains(text(),'Back to Login')]");

	public forgotPasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getforgotPassword() {
		return driver.findElement(forgotPassword);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement emailSubmit() {
		return driver.findElement(emailSubmit);
	}

	public WebElement flashMsg() {
		return driver.findElement(flashMsg);
	}

	public WebElement submitAlert() {
		return driver.findElement(submitAlert);
	}

	public WebElement navigateBack() {
		return driver.findElement(navBack);
	}

}
