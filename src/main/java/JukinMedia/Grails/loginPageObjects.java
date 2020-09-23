package JukinMedia.Grails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects {

	public WebDriver driver;

	By username = By.xpath("//input[@id='username']");
	By password = By.cssSelector("input[id='creds.password']");
	By submit = By.cssSelector("#loginButton");
	By headerSuccess = By.xpath("//h3[contains(text(),'You have successfully logged in.')]");
	By headerfail = By.xpath("//div[contains(text(),'Incorrect email')]");

	public loginPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getSubmit() {
		return driver.findElement(submit);
	}

	public WebElement getheaderfail() {
		return driver.findElement(headerfail);
	}

	public WebElement getheaderSuccess() {
		return driver.findElement(headerSuccess);
	}

}
