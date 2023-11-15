package automationpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoClass1 {
	
	WebDriver driver;
	
	@BeforeTest

	public void init() {
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	
	public void TestTitle() {
		String ExpectedTitle ="Swag Labs";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, ExpectedTitle, "title");
	}
	
	@Test(priority=1)
	
	public void TestUrl() {
		String ExpectedUrl ="https://www.saucedemo.com/";
		String ActualUrl = driver.getCurrentUrl();
		System.out.println(ActualUrl);
		Assert.assertEquals(ActualUrl, ExpectedUrl, "url");
	}
	
	@Test(priority=3)
	
	public void TestLogin() throws InterruptedException {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void TestChooseItem() throws InterruptedException {
		driver.findElement(By.className("inventory_item_name")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=5)
	public void AddCart() throws InterruptedException {
		driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=6)
	public void GotoCart() throws InterruptedException {
		driver.findElement(By.cssSelector("div#shopping_cart_container")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=7)
	public void CheckOut() throws InterruptedException {
		//checkout
		driver.findElement(By.cssSelector("button#checkout")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=8)
	public void CheckoutInfo() throws InterruptedException {
		//checkout information input
		driver.findElement(By.id("first-name")).sendKeys("standard");
		driver.findElement(By.id("last-name")).sendKeys("user");
		driver.findElement(By.id("postal-code")).sendKeys("1208");
		Thread.sleep(3000);
		
	}
	
	@Test(priority=9)
	public void ContinueBtn() throws InterruptedException {
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority=10)
	public void FinishBtn() throws InterruptedException {
		driver.findElement(By.cssSelector("button#finish")).click();
		Thread.sleep(2000);
	}

}
