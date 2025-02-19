package arnavtyagitesting.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import arnavtyagitesting.AbstractComponents.AbstractComponent;

public class AddressDetail extends AbstractComponent {
	WebDriver driver;
	public AddressDetail(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement searchbox;
	@FindBy(css = ".ta-results button:nth-child(3)")
	WebElement userRegion;
	@FindBy(css = ".action__submit")
	WebElement submit;
	By records = By.cssSelector(".ta-results");
	
	public void addressDetail(String keyword)
	{
		 Actions action =  new Actions(driver);
		 action.sendKeys(searchbox, keyword).perform();
		 waitTimeComponent(records);
		 userRegion.click();
		 submit.click();
	}

}
