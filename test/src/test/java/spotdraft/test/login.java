package spotdraft.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class login extends dataprovider {

	
	
	@Test(dataProvider="login")
	public void login(String Email, String password) throws InterruptedException
	{
		// MY Google Chrome Version 102.0.5005.63
		//Invoke webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ponkey121\\Documents\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(); 
		Actions act = new Actions(driver); 
		
		//Open the Website and maximize 
		driver.get("https://www.goodreads.com/");
		driver.manage().window().maximize();
		
		System.out.println("PAGE TITLE -"+driver.getTitle());
		
		
		//Wiat until the Signup text is found or not
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(8));
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".authSwitchFlow.u-marginTopLarge")));
		
		
		//Check weather the Signup text is Displayed or not
		System.out.println("Already a member? Signin = "+driver.findElement(By.cssSelector(".authSwitchFlow.u-marginTopLarge")).isDisplayed());
		
		
		//Check For SignIn Button
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Sign In')]")));
		
		System.out.println("SignIn Button  = "+driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).isDisplayed());
		
		// Click the Signin 
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		
		
		System.out.println("PAGE TITLE -"+driver.getTitle());
		
		//Validate Signup With Email
		
		// Check Signin with email is present
		
		System.out.println("SignIn with Email Button = "+driver.findElement(By.xpath("//button[contains(text(),'Sign in with email')]")).isDisplayed());
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Sign in with email')]")));
		
		
		// Click the Signup with Email button
		
		driver.findElement(By.xpath("//button[contains(text(),'Sign in with email')]")).click();
		
		System.out.println("PAGE TITLE -"+driver.getTitle());
		
		
		// Enter Credientials and Login 
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(Email);
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(password);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		System.out.println("PAGE TITLE -"+driver.getTitle());
		
		
		// Search Book and Enter 
		
		Thread.sleep(4000);
		
		driver.findElement(By.cssSelector(".searchBox__input.searchBox__input--navbar")).sendKeys("The Perfect Child");
		
		Thread.sleep(5000);
		
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("imagecol")));
		
		System.out.println("PAGE TITLE -"+driver.getTitle());
		
		// Click want to read
		
		driver.findElement(By.xpath("//body/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]/span[1]")).click();
		
		Thread.sleep(4000);
		
		//Navigate to my boos
		
		driver.findElement(By.xpath("//header/div[2]/div[1]/nav[1]/ul[1]/li[2]")).click();
		
		//Remove the Selected book
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector(".actionLinkLite.smallText.deleteLink")).click();
		
		Thread.sleep(2000);
		
		// Delete alert Confirmation when you remove the book 
		
		
		driver.switchTo().alert().accept();
		
		// logout Dropdown
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/ul[1]/li[5]/div[1]/a[1]/span[1]/img[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//header/div[2]/div[1]/div[3]/ul[1]/li[5]/div[1]/div[1]/div[1]/ul[1]/li[13]/a[1]"));
		
		// After logout 
		
		System.out.println("PAGE TITLE -"+driver.getTitle());
		
		driver.close();
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
