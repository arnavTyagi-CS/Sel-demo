package arnavtyagitesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;

import arnavtyagitesting.PageObjects.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String url = "https://rahulshettyacademy.com/client";
		driver.manage().window().maximize();
		driver.get(url);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginApplication();
		
		
		

	}

}
