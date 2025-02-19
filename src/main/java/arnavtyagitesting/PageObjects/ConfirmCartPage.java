package arnavtyagitesting.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import arnavtyagitesting.AbstractComponents.AbstractComponent;

public class ConfirmCartPage extends AbstractComponent {
	WebDriver driver;
	public ConfirmCartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".infoWrap")
	List<WebElement> finalProducts;
	By finalList = By.cssSelector(".totalRow button");
	By productDataNames = By.cssSelector(".cartSection h3");
	@FindBy(css = ".totalRow button")
	WebElement checkout;
	public List<WebElement> getproductList()
	{
		waitTimeComponent(finalList);
		return finalProducts;
	}
	public void purchaseFinalProductList(String productName)
	{
	Boolean value = getproductList().stream().anyMatch(cartItem->cartItem.findElement(productDataNames).getText().equalsIgnoreCase(productName));
//    Assert.asserttrue(value);
	checkout.click();	
	}
	

}
