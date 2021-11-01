package SpringBot.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maintesst {

	public static void main(String[] args) {
		try {
			System.out.println("a");
			String profile="C:\\Users\\haile0879\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";
			int b = profile.lastIndexOf("\\");
			System.out.println(b);
			String nameProfile=profile.substring(b+1);
			String urlDataur=profile.substring(0, b+1); 
			System.out.println(nameProfile);
			System.out.println(urlDataur);
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--user-data-dir="+urlDataur);
			options.addArguments("--profile-directory="+nameProfile);
	        options.addArguments("--disable-notifications");
	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
	        //options.addArguments("disable-extensions");
	        options.addArguments("--no-sandbox");
	        options.addArguments("start-maximized");
	        //options.AddExcludedArgument("enable-automation");
	        //options.AddAdditionalCapability("useAutomationExtension", false);
			WebDriver driver= new ChromeDriver(options);
			driver.get("https://merch.amazon.com/dashboard");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector(".yesterday")));
			String yesterdaySale =driver.findElement(By.cssSelector(".yesterday .net-sales")).getText();
			String todaySale =driver.findElement(By.cssSelector(".odometer-value")).getText();
			String todayMoney= driver.findElement(By.cssSelector(".royalties .number")).getText();
			String yesterdayMoney= driver.findElement(By.cssSelector(".yesterday .number")).getText();
			System.out.println(yesterdaySale);
			System.out.println(yesterdayMoney);
			System.out.println(todaySale);
			System.out.println(todayMoney);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
