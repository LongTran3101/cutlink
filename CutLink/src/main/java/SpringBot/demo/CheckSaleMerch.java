package SpringBot.demo;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

@RestController
public class CheckSaleMerch {
	public static WebDriver driver;
	@RequestMapping(value = "/checksalemerch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String hello( HttpServletRequest request, HttpServletResponse resp) {
		System.out.println("a");
		return "ok";

	}
	@RequestMapping(value = "/checksalemerchtest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String test( @RequestBody String req,HttpServletRequest request, HttpServletResponse resp) {
		try {
			//Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper objectMapper = new ObjectMapper();
			AccountMerch mech=objectMapper.readValue(req, AccountMerch.class);

			/*Gson gson = new GsonBuilder().disableHtmlEscaping().create();
			AccountMerch mech=gson.fromJson(req,AccountMerch.class);*/
			System.out.println("a");
			System.out.println(mech.getDay());
			String profile=mech.getPath();
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
			mech.setDayString(df2.format(df.parse(day)));
			mech.setDay(df.parse(day));
			mech.setSale(Integer.parseInt(todaySale));
			mech.setMoney(Double.parseDouble(todayMoney));
			
			CallAPi callApi =new CallAPi();
			String jsonString = objectMapper.writeValueAsString(mech);
			String rep =callApi.callAPIPost("http://80.240.28.138:8080/saveCheckSale", jsonString);
			if(rep!=null && rep.equalsIgnoreCase("00"))
			{
				return "00";
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
		
		return "01";
		

	}

	
}
