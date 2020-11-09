package Excel.DataDrivenFramework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import resources.Base;
import resources.ExcelDataConfig;

public class loginValidation extends Base {
	WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
	}

	@Test(dataProvider = "loginData")
	public void login(String userName, String password) throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(userName);
		lp.getPassword().sendKeys(password);
		lp.getLoginButton().click();
		Assert.assertEquals(driver.findElement(By.className("subheader")).getText(),
				"Welcome to the Secure Area. When you are done click logout below.");
		System.out.println("Welcome to the Secure Area. When you are done click logout below.");
	}

	@DataProvider(name = "loginData")
	public Object[][] passData() {
		String path=System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\login credentials.xlsx";
		ExcelDataConfig ex = new ExcelDataConfig(path);
		int rows = ex.getRowCount(0);
		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			data[i][0]=ex.getData(0, i, 0);
			data[i][1]=ex.getData(0, i, 1);
		}
		return data;
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
