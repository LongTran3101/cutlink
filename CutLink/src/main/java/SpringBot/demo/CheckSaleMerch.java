package SpringBot.demo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
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

	@RequestMapping(value = "/uploadMerch")
	private String hello( HttpServletRequest request, HttpServletResponse resp) {
		try {WebDriverManager.chromedriver().setup();
		ChromeOptions options2 = new ChromeOptions();
		options2.addArguments("--headless");
		 driver= new ChromeDriver(options2);
		 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		 String browserName = caps.getBrowserName();
		 String browserVersion = caps.getVersion();
		 System.out.println(browserName+" "+browserVersion);
		 driver.close();
		 ChromeOptions options = new ChromeOptions();
			
			//options.addArguments("--user-data-dir="+urlDataur);
			//options.addArguments("--profile-directory="+nameProfile);
	        options.addArguments("--disable-notifications");
	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
	        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+browserVersion+" Safari/537.36");
	        //options.addArguments("disable-extensions");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-web-security");
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        options.addArguments("start-maximized"); 
	        //options.AddExcludedArgument("enable-automation");
	        //options.AddAdditionalCapability("useAutomationExtension", false);
			 driver= new ChromeDriver(options);
			driver.get("https://merch.amazon.com/dashboard");
		///driver.get("https://merch.amazon.com/dashboard");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "notok";
		}

		return "ok";

	}
	
	
	@RequestMapping(value = "/deleteproduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String deleteproduct(@RequestBody String req, HttpServletRequest request, HttpServletResponse resp) {
		try {

			// String filename = PathLocal + "./key.txt";
			FileWriter fw = new FileWriter("log.txt"); // the true will append the new data
			fw.write("");// appends the string to the file
			fw.close();
			FileWriter fw2 = new FileWriter("log.txt"); // the true will append the new data
			fw2.write("1");// appends the string to the file
			fw2.close();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options2 = new ChromeOptions();
			options2.addArguments("--headless");
			 driver= new ChromeDriver(options2);
			 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			 String browserName = caps.getBrowserName();
			 String browserVersion = caps.getVersion();
			 System.out.println(browserName+" "+browserVersion);
			 driver.close();
			//WebDriverManager.chromedriver().
			ObjectMapper objectMapper = new ObjectMapper();
			List<Product> mechlst = objectMapper.readValue(req, new TypeReference<List<Product>>() {
			});
			try {
				 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
				 p.waitFor();
				Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
				 p.waitFor();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(1000);
			String nameacc = "";
			Product uploadold=new Product();
			for (Product mech : mechlst) {
				try {
					String home = System.getProperty("user.home");
					
					if (driver == null) {
						nameacc = mech.getAccName();
						uploadold=mech;
						String profile = mech.getPathProfile();
						int b = profile.lastIndexOf("\\");
						// System.out.println(b);
						String nameProfile = profile.substring(b + 1);
						String urlDataur = profile.substring(0, b + 1);
						// System.out.println(nameProfile);
						// System.out.println(urlDataur);

						ChromeOptions options = new ChromeOptions();

						options.addArguments("--user-data-dir=" + urlDataur);
						options.addArguments("--profile-directory=" + nameProfile);
						options.addArguments("--disable-notifications");
						options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
						 options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+browserVersion+" Safari/537.36");
						
						options.addArguments("--no-sandbox");
						options.addArguments("--disable-web-security");
						options.addArguments("--disable-blink-features=AutomationControlled");
						options.addArguments("start-maximized");
						driver = new ChromeDriver(options);
						driver.get("https://merch.amazon.com/manage/designs");
						Thread.sleep(20000);
						driver.findElement(By.cssSelector("#page-size-selector")).click();
						Thread.sleep(2000);
						driver.findElement(By.cssSelector("#page-size-250")).click();
						Thread.sleep(6000);
						
					}
					if (!mech.getAccName().toLowerCase().equalsIgnoreCase(nameacc.toLowerCase()) ) {
						System.out.println("So Sanh khac name accout tao lại");
						System.out.println(mech.getAccName() +"   name accout");
						System.out.println(nameacc +"   nameacc");
						
						
						System.out.println("check sale trc khi doi acc");
						FunctionCheckSale functionCheckSale=new FunctionCheckSale();
						//functionCheckSale.checkDesign(driver, mech, browserVersion);
						 
						// end
						nameacc = mech.getAccName();
						uploadold=mech;
						try {
							if (driver != null) {
								driver.quit();
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
						String profile = mech.getPathProfile();
						int b = profile.lastIndexOf("\\");
						// System.out.println(b);
						String nameProfile = profile.substring(b + 1);
						String urlDataur = profile.substring(0, b + 1);
						// System.out.println(nameProfile);
						// System.out.println(urlDataur);

						ChromeOptions options = new ChromeOptions();

						options.addArguments("--user-data-dir=" + urlDataur);
						options.addArguments("--profile-directory=" + nameProfile);
						options.addArguments("--disable-notifications");
						options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
						 options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+browserVersion+" Safari/537.36");
						options.addArguments("--no-sandbox");
						options.addArguments("start-maximized");
						options.addArguments("--no-sandbox");
						options.addArguments("--disable-web-security");
						options.addArguments("--disable-blink-features=AutomationControlled");
						options.addArguments("start-maximized");
						// options.AddExcludedArgument("enable-automation");
						// options.AddAdditionalCapability("useAutomationExtension", false);
						driver = new ChromeDriver(options);
						driver.get("https://merch.amazon.com/manage/designs");
						Thread.sleep(20000);
						driver.findElement(By.cssSelector("#page-size-selector")).click();
						Thread.sleep(2000);
						driver.findElement(By.cssSelector("#page-size-250")).click();
						Thread.sleep(6000);
					}
					
					
					FunctionCheckSale functionCheckSale=new FunctionCheckSale();
					functionCheckSale.deleteProduct(driver, mech);
					
					
				} catch (Exception e) {
					
					if (driver != null) {
						try {
							driver.quit();
						} catch (Exception e2) {
							// TODO: handle exception
						}

						// driver.close();
					}

					e.printStackTrace();
					continue;
					// return "notok";

				} finally {

					
				}

			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "notok";
		} finally {
			if (driver != null) {
				try {
					driver.quit();
				} catch (Exception e2) {
					// TODO: handle exception
				}

				// driver.close();
			}
			try {
				FileWriter fw = new FileWriter("log.txt"); // the true will append the new data
				fw.write("");// appends the string to the file
				fw.close();
				FileWriter fw2 = new FileWriter("log.txt"); // the true will append the new data
				fw2.write("0");// appends the string to the file
				fw2.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return "ok";

	}

	
	
	

	@RequestMapping(value = "/uploadMerchMulti", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String uploadMulti(@RequestBody String req, HttpServletRequest request, HttpServletResponse resp) {
		try {

			// String filename = PathLocal + "./key.txt";
			FileWriter fw = new FileWriter("log.txt"); // the true will append the new data
			fw.write("");// appends the string to the file
			fw.close();
			FileWriter fw2 = new FileWriter("log.txt"); // the true will append the new data
			fw2.write("1");// appends the string to the file
			fw2.close();
			WebDriverManager.chromedriver().setup();
			ChromeOptions options2 = new ChromeOptions();
			options2.addArguments("--headless");
			 driver= new ChromeDriver(options2);
			 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			 String browserName = caps.getBrowserName();
			 String browserVersion = caps.getVersion();
			 System.out.println(browserName+" "+browserVersion);
			 driver.close();
			//WebDriverManager.chromedriver().
			ObjectMapper objectMapper = new ObjectMapper();
			List<uploadFile> mechlst = objectMapper.readValue(req, new TypeReference<List<uploadFile>>() {
			});
			try {
				 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
				 p.waitFor();
				Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
				 p.waitFor();
			} catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(1000);
			String nameacc = "";
			uploadFile uploadold=new uploadFile();
			for (uploadFile mech : mechlst) {
				try {
					String home = System.getProperty("user.home");
					if(mech.getNameuser()!=null && mech.getNameuser().equalsIgnoreCase("1"))
					{
						try {
							String link = "http://45.32.101.196:8080/download2?imageid=" + mech.getId();
							System.out.println("Link : "+ link);
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

							// File file = new File(home+"/Downloads/" + fileName + ".txt");
							FileOutputStream fos = new FileOutputStream(home + "/Downloads/" + mech.getName());
							fos.write(response);
							fos.close();
						} catch (Exception e) {
							try {
								mech.setStatus("5" );
								String jsonString = objectMapper.writeValueAsString(mech);
								CallAPi callApi = new CallAPi();
								String rep = callApi.callAPIPost("http://45.32.101.196:8080/saveImageUpLoad", jsonString);
							} catch (Exception e2) {
								// TODO: handle exception
							}
							continue;
						}
					} 
					

					// System.out.println("a");
					// System.out.println(mech.getDay());
					if (driver == null) {
						nameacc = mech.getNameAccount();
						uploadold=mech;
						String profile = mech.getProfile();
						int b = profile.lastIndexOf("\\");
						// System.out.println(b);
						String nameProfile = profile.substring(b + 1);
						String urlDataur = profile.substring(0, b + 1);
						// System.out.println(nameProfile);
						// System.out.println(urlDataur);

						ChromeOptions options = new ChromeOptions();

						options.addArguments("--user-data-dir=" + urlDataur);
						options.addArguments("--profile-directory=" + nameProfile);
						options.addArguments("--disable-notifications");
						options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
						 options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+browserVersion+" Safari/537.36");
						
						options.addArguments("--no-sandbox");
						options.addArguments("--disable-web-security");
						options.addArguments("--disable-blink-features=AutomationControlled");
						options.addArguments("start-maximized");
						driver = new ChromeDriver(options);
						
					}
					if (!mech.getNameAccount().toLowerCase().equalsIgnoreCase(nameacc.toLowerCase()) ) {
						System.out.println("So Sanh khac name accout tao lại");
						System.out.println(mech.getNameAccount() +"   name accout");
						System.out.println(nameacc +"   nameacc");
						
						
						System.out.println("check sale trc khi doi acc");
						FunctionCheckSale functionCheckSale=new FunctionCheckSale();
						functionCheckSale.checkSaleAccount(mech, driver);
						 
						// end
						nameacc = mech.getNameAccount();
						uploadold=mech;
						try {
							if (driver != null) {
								driver.quit();
							}
							
						} catch (Exception e2) {
							// TODO: handle exception
						}
						String profile = mech.getProfile();
						int b = profile.lastIndexOf("\\");
						// System.out.println(b);
						String nameProfile = profile.substring(b + 1);
						String urlDataur = profile.substring(0, b + 1);
						// System.out.println(nameProfile);
						// System.out.println(urlDataur);

						ChromeOptions options = new ChromeOptions();

						options.addArguments("--user-data-dir=" + urlDataur);
						options.addArguments("--profile-directory=" + nameProfile);
						options.addArguments("--disable-notifications");
						options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
						 options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+browserVersion+" Safari/537.36");
						options.addArguments("--no-sandbox");
						options.addArguments("start-maximized");
						options.addArguments("--no-sandbox");
						options.addArguments("--disable-web-security");
						options.addArguments("--disable-blink-features=AutomationControlled");
						options.addArguments("start-maximized");
						// options.AddExcludedArgument("enable-automation");
						// options.AddAdditionalCapability("useAutomationExtension", false);
						driver = new ChromeDriver(options);
						

					}

					
					WebDriverWait wait = new WebDriverWait(driver, 20);
					driver.get("https://merch.amazon.com/designs/new");
					Thread.sleep(20000);
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select-marketplace-button-original")));
					WebElement elembtn =driver.findElement(By.cssSelector("#select-marketplace-button-original"));
					elembtn.sendKeys(Keys.ENTER);
					//driver.findElement(By.cssSelector("#select-marketplace-button-original")).click();
					System.out.println("sua click 2 lan");
					Thread.sleep(4000);
					
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#select-none")));
					//driver.findElement(By.cssSelector("#select-none")).click();
					WebElement check2 =driver.findElement(By.cssSelector("#select-none"));

					JavascriptExecutor jse = (JavascriptExecutor)driver;
					jse.executeScript("arguments[0].click();", check2);
					Thread.sleep(2000);
					//driver.findElement(By.cssSelector(".STANDARD_TSHIRT-US")).click();
					if(mech.getTypeShirtUpLoad().contains("1"))
					{
						check2 =driver.findElement(By.cssSelector(".STANDARD_TSHIRT-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					
					if(mech.getTypeShirtUpLoad().contains("2"))
					{
						check2 =driver.findElement(By.cssSelector(".PREMIUM_TSHIRT-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					
					if(mech.getTypeShirtUpLoad().contains("3"))
					{
						check2 =driver.findElement(By.cssSelector(".VNECK-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					if(mech.getTypeShirtUpLoad().contains("4"))
					{
						check2 =driver.findElement(By.cssSelector(".TANK_TOP-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					if(mech.getTypeShirtUpLoad().contains("5"))
					{
						check2 =driver.findElement(By.cssSelector(".STANDARD_LONG_SLEEVE-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					if(mech.getTypeShirtUpLoad().contains("6"))
					{
						check2 =driver.findElement(By.cssSelector(".RAGLAN-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					if(mech.getTypeShirtUpLoad().contains("7"))
					{
						check2 =driver.findElement(By.cssSelector(".STANDARD_SWEATSHIRT-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					
					if(mech.getTypeShirtUpLoad().contains("8"))
					{
						check2 =driver.findElement(By.cssSelector(".STANDARD_PULLOVER_HOODIE-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					
					if(mech.getTypeShirtUpLoad().contains("9"))
					{
						check2 =driver.findElement(By.cssSelector(".ZIP_HOODIE-US"));
						jse.executeScript("arguments[0].click();", check2);
						Thread.sleep(2000);
					}
					
					
					
					
					driver.findElement(By.cssSelector(".btn-submit")).click();
					Thread.sleep(4000);

					System.out.println("path " + home + "/Downloads/" + mech.getName());
					File f = new File(home + "/Downloads/" + mech.getName());
					if (f.exists() && !f.isDirectory()) {
						System.out.println("file có tồn tại");
					} else {
						System.out.println("file k tồn tại");
						continue;
					}

					if (isElementCss(By.cssSelector("#STANDARD_TSHIRT-FRONT"), driver)) {
						WebElement elem = driver.findElement(By.cssSelector("#STANDARD_TSHIRT-FRONT"));

						elem.sendKeys(home + "/Downloads/" + mech.getName());
					}else
					if (isElementCss(By.cssSelector(".file-upload-input"), driver)) {
						WebElement elem = driver.findElement(By.cssSelector(".file-upload-input"));

						elem.sendKeys(home + "/Downloads/" + mech.getName());
					}
					
					//upload t-shirt
					if(mech.getTypeShirtUpLoad().contains("1"))
					{
						UploadFunction.uploadTshirt(driver, mech);
					}
					//upload Preshirt
					if(mech.getTypeShirtUpLoad().contains("2"))
					{
						UploadFunction.uploadPreTshirt(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("3"))
					{
						UploadFunction.uploadVneck(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("4"))
					{
						UploadFunction.uploadTank(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("5"))
					{
						UploadFunction.uploadLong(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("6"))
					{
						UploadFunction.uploadRaglan(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("7"))
					{
						UploadFunction.uploadSweat(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("8"))
					{
						UploadFunction.uploadPullover(driver, mech);
					}
					if(mech.getTypeShirtUpLoad().contains("9"))
					{
						UploadFunction.uploadZip(driver, mech);
					}
					
					
					Thread.sleep(2000);
					WebElement title = driver.findElement(By.cssSelector("#designCreator-productEditor-title"));
					title.sendKeys(Keys.CONTROL + "a");
					title.sendKeys(Keys.DELETE);
					title.sendKeys(mech.getTitle());
					Thread.sleep(2000);
					WebElement brand = driver.findElement(By.cssSelector("#designCreator-productEditor-brandName"));
					brand.sendKeys(Keys.CONTROL + "a");
					brand.sendKeys(Keys.DELETE);
					brand.sendKeys(mech.getBrand());
					Thread.sleep(2000);
					WebElement des1 = driver.findElement(By.cssSelector("#designCreator-productEditor-featureBullet1"));
					des1.sendKeys(Keys.CONTROL + "a");
					des1.sendKeys(Keys.DELETE);
					if (mech.getDes1() != null && !mech.getDes1().isEmpty()) {

						des1.sendKeys(mech.getDes1());
						Thread.sleep(2000);
					} else {
						des1.sendKeys("");
						Thread.sleep(2000);
					}
					WebElement des2 = driver.findElement(By.cssSelector("#designCreator-productEditor-featureBullet2"));
					des2.sendKeys(Keys.CONTROL + "a");
					des2.sendKeys(Keys.DELETE);
					if (mech.getDes2() != null && !mech.getDes2().isEmpty()) {

						des2.sendKeys(mech.getDes2());
						Thread.sleep(2000);
					} else {
						des2.sendKeys("");
						Thread.sleep(2000);
					}
					driver.findElement(By.cssSelector("#submit-button")).sendKeys(Keys.ENTER);
					Thread.sleep(3000);
					driver.findElement(By.cssSelector(".btn-submit")).sendKeys(Keys.ENTER);
					Thread.sleep(10000);

					if (isElementCss(By.cssSelector("#redirect-designs-new"), driver)) {
						try {
							mech.setStatus("2");
							String jsonString = objectMapper.writeValueAsString(mech);
							CallAPi callApi = new CallAPi();
							String rep = callApi.callAPIPost("http://45.32.101.196:8080/saveImageUpLoad", jsonString);
						} catch (Exception e2) {
							// TODO: handle exception
						}
						//driver.findElement(By.cssSelector("#redirect-designs-new")).click();
					}

					
					// men-checkbox
				} catch (Exception e) {
					try {
						mech.setStatus("6");
						String jsonString = objectMapper.writeValueAsString(mech);
						CallAPi callApi = new CallAPi();
						String rep = callApi.callAPIPost("http://45.32.101.196:8080/saveImageUpLoad", jsonString);
					} catch (Exception e2) {
						// TODO: handle exception
					}
					if (driver != null) {
						try {
							driver.quit();
						} catch (Exception e2) {
							// TODO: handle exception
						}

						// driver.close();
					}

					e.printStackTrace();
					continue;
					// return "notok";

				} finally {

					
				}

			}
			System.out.println("check sale sau khi xong acc");
			FunctionCheckSale functionCheckSale= new FunctionCheckSale();
			functionCheckSale.checkSaleAccount(uploadold, driver);
			 
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "notok";
		} finally {
			if (driver != null) {
				try {
					driver.quit();
				} catch (Exception e2) {
					// TODO: handle exception
				}

				// driver.close();
			}
			try {
				FileWriter fw = new FileWriter("log.txt"); // the true will append the new data
				fw.write("");// appends the string to the file
				fw.close();
				FileWriter fw2 = new FileWriter("log.txt"); // the true will append the new data
				fw2.write("0");// appends the string to the file
				fw2.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return "ok";

	}

	@RequestMapping(value = "/checksalemerchtest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String test(@RequestBody String req, HttpServletRequest request, HttpServletResponse resp) {

		String rep = "";
		try {
			// Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper objectMapper = new ObjectMapper();
			AccountMerch mech = objectMapper.readValue(req, AccountMerch.class);
			
			try { 
			
				CallAPi callApi =new CallAPi();
				FunctionCheckSale functionCheckSale=new FunctionCheckSale();
				 rep =callApi.callAPIPost("http://45.32.101.196:8080/getallaccfromip", "");
				
				 WebDriverManager.chromedriver().setup();
					ChromeOptions options2 = new ChromeOptions();
					options2.addArguments("--headless");
					 driver= new ChromeDriver(options2);
					 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
					 String browserName = caps.getBrowserName();
					 String browserVersion = caps.getVersion();
					 System.out.println(browserName+" "+browserVersion);
					 driver.close();
				try {
					 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
					 p.waitFor();
					Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
					 p.waitFor();
				} catch (Exception e) {
					// TODO: handle exception
				} 
				Thread.sleep(1000);
				rep=functionCheckSale.checkSaleListAccountString(mech, driver, browserVersion);
				if (rep != null && rep.equalsIgnoreCase("00")) {
					return "00";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
			 
		return "01";

	}
	
	@RequestMapping(value = "/checkProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private String checkProduct(@RequestBody String req, HttpServletRequest request, HttpServletResponse resp) {

		String rep = "";
		try {
			// Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ObjectMapper objectMapper = new ObjectMapper();
			AccountMerch mech = objectMapper.readValue(req, AccountMerch.class);
			
			try { 
			
				CallAPi callApi =new CallAPi();
				FunctionCheckSale functionCheckSale=new FunctionCheckSale();
				 rep =callApi.callAPIPost("http://45.32.101.196:8080/getallaccfromip", "");
				
				 WebDriverManager.chromedriver().setup();
					ChromeOptions options2 = new ChromeOptions();
					options2.addArguments("--headless");
					 driver= new ChromeDriver(options2);
					 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
					 String browserName = caps.getBrowserName();
					 String browserVersion = caps.getVersion();
					 System.out.println(browserName+" "+browserVersion);
					 driver.close();
				try {
					 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
					 p.waitFor();
					Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
					 p.waitFor();
				} catch (Exception e) {
					// TODO: handle exception
				} 
				Thread.sleep(1000);
				rep=functionCheckSale.checkDesign(driver,mech,  browserVersion);
				if (rep != null && rep.equalsIgnoreCase("00")) {
					return "00";
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
			 
		return "01";

	}
	
	protected static Boolean isElementCss(By by, WebDriver driver2) {
		try {
			driver2.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
