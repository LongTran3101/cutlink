package SpringBot.demo;

import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class Scheduler {
	public static WebDriver driver;
	@Scheduled(fixedRate=1000*60*180)
   public void cronJobSch() {
		try { 
			try {
				String status="";
				File myObj = new File("log.txt");
				 Scanner myReader = new Scanner(myObj);

	             while (myReader.hasNextLine()) {
	            	 status = myReader.nextLine();

	             }
	             myReader.close();
	             if (!status.isEmpty() && status.equalsIgnoreCase("1")) {
	            	 return;
	             }
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			CallAPi callApi =new CallAPi();
			FunctionCheckSale functionCheckSale=new FunctionCheckSale();
			String rep ="";
			 rep =callApi.callAPIPost("http://45.32.101.196:8080/getallaccfromip", "");
			 List<AccountMerch> mechlst = objectMapper.readValue(rep, new TypeReference<List<AccountMerch>>(){});
			 WebDriverManager.chromedriver().setup();
				ChromeOptions options2 = new ChromeOptions();
				options2.addArguments("--headless");
				 driver= new ChromeDriver(options2);
				 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
				 String browserName = caps.getBrowserName();
				 String browserVersion = caps.getVersion();
				 System.out.println(browserName+" "+browserVersion);
				 driver.close();
			System.out.println(mechlst.size());
			try {
				 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
				 p.waitFor();
				Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
				 p.waitFor();
			} catch (Exception e) {
				// TODO: handle exception
			} 
			Thread.sleep(1000);
			functionCheckSale.checkSaleListAccount(mechlst, driver, browserVersion);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
   }
}