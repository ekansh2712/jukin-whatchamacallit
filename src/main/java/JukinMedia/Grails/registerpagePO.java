package JukinMedia.Grails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class registerpagePO {

	public WebDriver driver;

	By register = By.xpath("//a[contains(text(),'Register')]");
	By newEmail = By.xpath("//input[@id='reg.email']");
	By newPassword = By.xpath("//input[@id='reg.password']");
	By newConfPassword = By.xpath("//input[@id='reg.confirmPassword']");
	By newSubmit = By.xpath("//input[@name='_action_doRegister']");
	By newSuccess = By.xpath("//h3[contains(text(),'Check your email for account verification instruct')]");
	By invalid = By.xpath("//div[@id='failedMessage']");
	By logBack = By.xpath("//input[@name='_action_index']");
	By regSuccess = By.xpath("//h3[contains(text(),'Fill out the form to create your account.')]");

	public registerpagePO(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement registerPageSuccess() {
		return driver.findElement(regSuccess);
	}

	public WebElement registerNew() {
		return driver.findElement(register);
	}

	public WebElement registerNewEmail() {
		return driver.findElement(newEmail);
	}

	public WebElement registerNewPassword() {
		return driver.findElement(newPassword);
	}

	public WebElement registerConfPassword() {
		return driver.findElement(newConfPassword);
	}

	public WebElement registernewSubmit() {
		return driver.findElement(newSubmit);
	}

	public WebElement registernewSuccess() {
		return driver.findElement(newSuccess);
	}

	public WebElement registernewFail() {
		return driver.findElement(invalid);
	}

	public WebElement backtoLogin() {
		return driver.findElement(logBack);
	}

}
