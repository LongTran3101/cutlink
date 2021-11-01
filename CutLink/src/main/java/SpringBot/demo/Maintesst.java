package SpringBot.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maintesst {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper objectMapper = new ObjectMapper();
			/*Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			AccountMerch mech=gson.fromJson(req,AccountMerch.class);*/
			System.out.println("a");
			//System.out.println(mech.getDay());
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
			 driver= new ChromeDriver(options);
			driver.get("https://merch.amazon.com/dashboard");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector(".yesterday")));
			String yesterdaySale =driver.findElement(By.cssSelector(".yesterday .net-sales")).getText();
			String todaySale =driver.findElement(By.cssSelector(".odometer-value")).getText();
			String todayMoney= driver.findElement(By.cssSelector(".royalties .number")).getText();
			String yesterdayMoney= driver.findElement(By.cssSelector(".yesterday .number")).getText();
			String day= driver.findElement(By.cssSelector(".today .subtitle")).getText();
			System.out.println(yesterdaySale);
			System.out.println(yesterdayMoney);
			System.out.println(todaySale);
			System.out.println(todayMoney);
			DateFormat df = new SimpleDateFormat("MM/dd/yy"); 
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
			AccountMerch mech=new AccountMerch();
			mech.setEmail("long.tn3101@gmail.com");
			mech.setIp("192.16");
			mech.setName("Merch 17");
			mech.setPath("path");
			mech.setDayString(df2.format(df.parse(day)));
			mech.setDay(df.parse(day));
			mech.setSale(Integer.parseInt(todaySale));
			mech.setMoney(Double.parseDouble(todayMoney));
			
			CallAPi callApi =new CallAPi();
			String jsonString = objectMapper.writeValueAsString(mech);
			String rep =callApi.callAPIPost("http://80.240.28.138:8080/saveCheckSale", jsonString);
			if(rep!=null && rep.equalsIgnoreCase("00"))
			{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(driver!=null)
			{
				driver.quit();
				driver.close();
			}
		}
		
		
	}

}
