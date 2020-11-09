package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}

	private By userName = By.cssSelector("#username");
	private By password = By.cssSelector("#password");
	private By loginButton = By.xpath("//button[@type='submit']");

	public WebElement getUserName() {
		return driver.findElement(userName);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

}
