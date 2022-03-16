package SpringBot.demo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
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
import org.openqa.selenium.WebElement;
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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.github.bonigarcia.wdm.WebDriverManager;

@RestController
public class CheckSaleMerch {
	public static WebDriver driver;
	@RequestMapping(value = "/uploadMerch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String hello( @RequestBody String req, HttpServletRequest request, HttpServletResponse resp) {
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			uploadFile mech=objectMapper.readValue(req, uploadFile.class);
			String link = "http://45.32.101.196:8080/download2?username="+ mech.getUsername() + "&imagename="+mech.getName();
			URL url = new URL(link);
	          InputStream in = new BufferedInputStream(url.openStream());
	          ByteArrayOutputStream out = new ByteArrayOutputStream();
	          byte[] buf = new byte[1024];
	          int n = 0;
	          while (-1 != (n = in.read(buf))) {
	              out.write(buf, 0, n);
	          }
	          out.close();
	          in.close();
	          byte[] response = out.toByteArray();
	          String home = System.getProperty("user.home");
	          //File file = new File(home+"/Downloads/" + fileName + ".txt"); 
	          FileOutputStream fos = new FileOutputStream(home+"/Downloads/" +mech.getName());
	          fos.write(response);
	          fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			return "notok";
		}
		  
		return "ok";

	}
	
	@RequestMapping(value = "/uploadMerchMulti", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String uploadMulti( @RequestBody String req, HttpServletRequest request, HttpServletResponse resp) {
		try {
			WebDriverManager.chromedriver().setup();
			ObjectMapper objectMapper = new ObjectMapper();
			List<uploadFile> mechlst = objectMapper.readValue(req, new TypeReference<List<uploadFile>>(){});
			String pathProfile="";
		
				for (uploadFile mech : mechlst) {
					try {
						//System.out.println("a");
						//System.out.println(mech.getDay());
						if(mech.getProfile().equalsIgnoreCase(pathProfile)) {
							pathProfile=mech.getProfile();
							driver.close();
							String profile=mech.getProfile();
							int b = profile.lastIndexOf("\\");
							//System.out.println(b);
							String nameProfile=profile.substring(b+1);
							String urlDataur=profile.substring(0, b+1);
							//System.out.println(nameProfile);
							//System.out.println(urlDataur);
							
							ChromeOptions options = new ChromeOptions();
							
							options.addArguments("--user-data-dir="+urlDataur);
							options.addArguments("--profile-directory="+nameProfile);
					        options.addArguments("--disable-notifications");
					        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
					        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36");
					        options.addArguments("--no-sandbox");
					        options.addArguments("start-maximized"); 
					        options.addArguments("--no-sandbox");
					        options.addArguments("--disable-web-security");
					        options.addArguments("--disable-blink-features=AutomationControlled");
					        options.addArguments("start-maximized"); 
					        //options.AddExcludedArgument("enable-automation");
					        //options.AddAdditionalCapability("useAutomationExtension", false);
							 driver= new ChromeDriver(options);
							
						}
						
						
						
						 driver.get("https://merch.amazon.com/dashboard");
						 
						 Thread.sleep(20000);
						 driver.get("https://merch.amazon.com/designs/new");
						 Thread.sleep(10000);
						 driver.findElement(By.cssSelector("#select-marketplace-button")).click();
						 Thread.sleep(2000);
						 driver.findElement(By.cssSelector("#select-none")).click();
						 Thread.sleep(1000);
						 driver.findElement(By.cssSelector("#select-none")).click();
						 Thread.sleep(1000);
						 driver.findElement(By.cssSelector(".STANDARD_TSHIRT-US input")).click();
						 Thread.sleep(1000);
						 driver.findElement(By.cssSelector(".btn-submit")).click();
						 String home = System.getProperty("user.home");
							File f = new File(home+"/Downloads/" +mech.getName());
							if (f.exists() && !f.isDirectory()) {

							} else {

								
								continue;
							}
							
							WebElement elem = driver.findElement(By.cssSelector("#STANDARD_TSHIRT-FRONT"));
							
							elem.sendKeys(home+"/Downloads/" +mech.getName());
							
				          
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					}
				
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return "notok";
		}
		  
		return "ok";

	}
	
	
	
	@RequestMapping(value = "/checksalemerchtest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String test( @RequestBody String req,HttpServletRequest request, HttpServletResponse resp) {
		
		String rep ="";
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
			Thread.sleep(10000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			 wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector(".yesterday")));
			String yesterdaySale =driver.findElement(By.cssSelector(".yesterday .net-sales")).getText();
			String todaySale =driver.findElement(By.cssSelector(".odometer-value")).getText();
			String todayMoney= driver.findElement(By.cssSelector(".royalties .number")).getText();
			String yesterdayMoney= driver.findElement(By.cssSelector(".yesterday .number")).getText();
			String tier=driver.findElement(By.cssSelector(".tier-text .number")).getText();
			String coutDesgin=driver.findElement(By.cssSelector(".published-designs .used")).getText();
			String last7dayMoney= driver.findElement(By.cssSelector(".last-seven-days .number")).getText();
			String last7daySale =driver.findElement(By.cssSelector(".last-seven-days .net-sales")).getText();
			String thismonthMoney= driver.findElement(By.cssSelector(".this-month .number")).getText();
			String thismonthSale =driver.findElement(By.cssSelector(".this-month .net-sales")).getText();
			String previousmonthMoney= driver.findElement(By.cssSelector(".previous-month .number")).getText();
			String previousmonthSale =driver.findElement(By.cssSelector(".previous-month .net-sales")).getText();
			String alltimeMoney= driver.findElement(By.cssSelector(".all-time .number")).getText();
			String alltimeSale =driver.findElement(By.cssSelector(".all-time .net-sales")).getText();
			String day= driver.findElement(By.cssSelector(".today .subtitle")).getText();
			System.out.println(yesterdaySale);
			System.out.println(yesterdayMoney);
			System.out.println(todaySale);
			System.out.println(todayMoney);
			DateFormat df = new SimpleDateFormat("MM/dd/yy"); 
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
			SaleMerch sale=new SaleMerch();
			sale.setTier(tier);
			sale.setCoutDesgin(Integer.parseInt(coutDesgin));
			sale.setLast7dayMoney(Double.parseDouble(last7dayMoney));
			sale.setThismonthMoney(Double.parseDouble(thismonthMoney));
			sale.setPreviousmonthMoney(Double.parseDouble(previousmonthMoney));
			sale.setAlltimeMoney(Double.parseDouble(alltimeMoney));
			sale.setLast7daySale(Integer.parseInt(last7daySale));
			sale.setThismonthSale(Integer.parseInt(thismonthSale));
			sale.setPreviousmonthSale(Integer.parseInt(previousmonthSale));
			sale.setAlltimeSale(Integer.parseInt(alltimeSale));
			sale.setDayString(df2.format(df.parse(day)));
			sale.setDay(df.parse(day));
			sale.setSale(Integer.parseInt(todaySale));
			sale.setMoney(Double.parseDouble(todayMoney));
			sale.setEmail(mech.getEmail());
			//sale.setId(mech.getId());
			sale.setIp(mech.getIp());
			sale.setMoneyyesterday((Double.parseDouble(yesterdayMoney)));
			sale.setName(mech.getName());
			sale.setPath(mech.getPath());
			sale.setUsername(mech.getUsername());
			sale.setYesterday(Integer.parseInt(yesterdaySale));
			sale.setStatus("1");
			try {
				List<ImageMerch> lst=new ArrayList<>();
				 List<WebElement> listelement = driver.findElements(By.cssSelector(".todays-shirts-list a"));
				 for (WebElement webElement : listelement) {
					 ImageMerch a=new ImageMerch();
					 a.setName(webElement.getAttribute("title"));
					 a.setUrl(webElement.getAttribute("href"));
					 a.setAcc(mech.getName());
					 lst.add(a);
				}
				 sale.setLstimageMerch(lst);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			CallAPi callApi =new CallAPi();
			String jsonString = objectMapper.writeValueAsString(sale);
			 rep =callApi.callAPIPost("http://45.32.101.196:8080/saveCheckSale", jsonString);
			
		} catch (Exception e) {
			System.out.println("loi");
			//e.printStackTrace();
		}finally {
			if(driver!=null)
			{
				try {
					driver.quit();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				//driver.close();
			}
		}
		if(rep!=null && rep.equalsIgnoreCase("00"))
		{
			return "00";
		}
		
		return "01";
		

	}

	
}
