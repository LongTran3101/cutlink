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
			String profile="C:\\Users\\longhuong\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1";
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
	        options.addArguments("--disable-web-security");
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        options.addArguments("start-maximized"); 
	        //options.AddExcludedArgument("enable-automation");
	        //options.AddAdditionalCapability("useAutomationExtension", false);
			 driver= new ChromeDriver(options);
			
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
