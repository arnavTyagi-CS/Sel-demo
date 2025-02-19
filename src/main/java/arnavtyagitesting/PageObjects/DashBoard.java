package arnavtyagitesting.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import arnavtyagitesting.AbstractComponents.AbstractComponent;


public class DashBoard extends AbstractComponent {
	WebDriver driver;
	public DashBoard(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".col-lg-4")
	List<WebElement> products;
	@FindBy(xpath="//*[@routerlink='/dashboard/cart']")
	WebElement clickCart;
	
	By findBy= By.cssSelector(".col-lg-4");
	By addCart = By.cssSelector("button:last-of-type");
	By ele = By.cssSelector("#toast-container");
	public List<WebElement> productsData()
	{
		waitTimeComponent(findBy);
		return products;
	}
	public WebElement getMyProduct(String productName)
	{
		
		WebElement prod = productsData().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	public void addTOCart(String productName) throws InterruptedException
	{
		WebElement prod = getMyProduct(productName);
		prod.findElement(addCart).click();
		waitTimeComponent(ele);
		Thread.sleep(2000);
		goToCart(clickCart);
	}
	

}
