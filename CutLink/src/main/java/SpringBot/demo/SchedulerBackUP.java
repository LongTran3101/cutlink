//package SpringBot.demo;
//
//import java.io.File;
//import java.math.BigDecimal;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Scanner;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Capabilities;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//@Component
//public class SchedulerBackUP {
//	public static WebDriver driver;
//	@Scheduled(fixedRate=1000*60*180)
//   public void cronJobSch() {
//		try { 
//			try {
//				String status="";
//				File myObj = new File("log.txt");
//				 Scanner myReader = new Scanner(myObj);
//
//	             while (myReader.hasNextLine()) {
//	            	 status = myReader.nextLine();
//
//	             }
//	             myReader.close();
//	             if (!status.isEmpty() && status.equalsIgnoreCase("1")) {
//	            	 return;
//	             }
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//			
//			ObjectMapper objectMapper = new ObjectMapper();
//			CallAPi callApi =new CallAPi();
//			String rep ="";
//			 rep =callApi.callAPIPost("http://45.32.101.196:8080/getallaccfromip", "");
//			 List<AccountMerch> mechlst = objectMapper.readValue(rep, new TypeReference<List<AccountMerch>>(){});
//			 WebDriverManager.chromedriver().setup();
//				ChromeOptions options2 = new ChromeOptions();
//				options2.addArguments("--headless");
//				 driver= new ChromeDriver(options2);
//				 Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//				 String browserName = caps.getBrowserName();
//				 String browserVersion = caps.getVersion();
//				 System.out.println(browserName+" "+browserVersion);
//				 driver.close();
//			System.out.println(mechlst.size());
//			try {
//				 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
//				 p.waitFor();
//				Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
//				 p.waitFor();
//			} catch (Exception e) {
//				// TODO: handle exception
//			} 
//			Thread.sleep(1000);
//			 for (AccountMerch mech : mechlst) {
//				 try {
//						//Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//						/*Gson gson = new GsonBuilder().disableHtmlEscaping().create();
//						AccountMerch mech=gson.fromJson(req,AccountMerch.class);*/
//						
//						Thread.sleep(10000);
//						//System.out.println("a");
//						//System.out.println(mech.getDay());
//						String profile=mech.getPath();
//						int b = profile.lastIndexOf("\\");
//						//System.out.println(b);
//						String nameProfile=profile.substring(b+1);
//						String urlDataur=profile.substring(0, b+1);
//						System.out.println("bat dau check acc "+ mech.getName());
//						ChromeOptions options = new ChromeOptions();
//						options.addArguments("--user-data-dir="+urlDataur);
//						options.addArguments("--profile-directory="+nameProfile);
//				        options.addArguments("--disable-notifications");
//				        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
//				        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/"+browserVersion+" Safari/537.36");
//				        options.addArguments("--no-sandbox");
//						options.addArguments("start-maximized");
//				        options.addArguments("--no-sandbox");
//				        options.addArguments("--disable-web-security");
//				        options.addArguments("--disable-blink-features=AutomationControlled");
//				        options.addArguments("start-maximized"); 
//						 driver= new ChromeDriver(options);
//						driver.get("https://merch.amazon.com/dashboard");
//						Thread.sleep(70000);
//						/*WebDriverWait wait = new WebDriverWait(driver, 20);
//						 wait.until(ExpectedConditions
//									.visibilityOfElementLocated(By.cssSelector(".today")));*/
//						String link =driver.getCurrentUrl();
//						if(link.equalsIgnoreCase("https://merch.amazon.com/terminated"))
//						{
//							DateFormat df = new SimpleDateFormat("MM/dd/yy"); 
//							DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
//							SaleMerch sale=new SaleMerch();
//							sale.setTier("");
//							sale.setCoutDesgin(0);
//							sale.setLimitslot("0");
//							sale.setTier("0");
//							sale.setLast7dayMoney(new Double("0"));
//							sale.setThismonthMoney(new Double("0"));
//							sale.setPreviousmonthMoney(new Double("0"));
//							sale.setAlltimeMoney(new Double("0"));
//							sale.setLast7daySale(0);
//							sale.setThismonthSale(0);
//							sale.setPreviousmonthSale(0);
//							sale.setAlltimeSale(0);
//							sale.setDayString(df2.format(new Date()));
//							sale.setDay(new Date());
//							sale.setSale(0);
//							sale.setMoney(0);
//							sale.setEmail(mech.getEmail());
//							//sale.setId(mech.getId());
//							sale.setIp(mech.getIp());
//							sale.setMoneyyesterday(new Double("0"));
//							sale.setName(mech.getName());
//							sale.setPath(mech.getPath());
//							sale.setUsername(mech.getUsername());
//							sale.setYesterday(0);
//							sale.setStatus("5");
//							String jsonString = objectMapper.writeValueAsString(sale);
//							 rep =callApi.callAPIPost("http://45.32.101.196:8080/saveCheckSale", jsonString);
//							System.out.println("Tèo cmnr");
//							continue;
//						}
//						 String day= driver.findElement(By.cssSelector(".today .subtitle")).getText();
//							String used= driver.findElement(By.cssSelector(".uploads .used")).getText();
//							String limit= driver.findElement(By.cssSelector(".uploads .limit")).getText();
//							String rj = driver.findElement(By.cssSelector(".rejected .number")).getText();
//						
//						String todaySale = driver.findElement(By.cssSelector(".today-card .total-sales")).getText();
//						String todayMoney= driver.findElement(By.cssSelector(".royalties .number")).getText();
//						String yesterdayMoney= driver.findElement(By.cssSelector(".yesterday .number")).getText();
//						String tier=driver.findElement(By.cssSelector(".tier-text .number")).getText();
//						String coutDesgin=driver.findElement(By.cssSelector(".published-designs .used")).getText();
//						String last7dayMoney= driver.findElement(By.cssSelector(".last-seven-days .number")).getText();
//						String last7daySale =driver.findElement(By.cssSelector(".last-seven-days .net-sales")).getText();
//						String thismonthMoney= driver.findElement(By.cssSelector(".this-month .number")).getText();
//						String thismonthSale =driver.findElement(By.cssSelector(".this-month .net-sales")).getText();
//						String previousmonthMoney= driver.findElement(By.cssSelector(".previous-month .number")).getText();
//						String previousmonthSale =driver.findElement(By.cssSelector(".previous-month .net-sales")).getText();
//						String yesterdaySale =driver.findElement(By.cssSelector(".yesterday .net-sales")).getText();
//						String alltimeMoney= driver.findElement(By.cssSelector(".all-time .number")).getText();
//						String alltimeSale =driver.findElement(By.cssSelector(".all-time .net-sales")).getText();
//					
//						DateFormat df = new SimpleDateFormat("MM/dd/yy"); 
//						DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
//						SaleMerch sale=new SaleMerch();
//						sale.setUsed(used);
//						sale.setLimitslot(limit);
//						sale.setTier(tier);
//						sale.setCoutDesgin(Integer.parseInt(coutDesgin));
//						sale.setParam1(rj);
//						sale.setLast7dayMoney(Double.parseDouble(last7dayMoney));
//						sale.setThismonthMoney(Double.parseDouble(thismonthMoney));
//						sale.setPreviousmonthMoney(Double.parseDouble(previousmonthMoney));
//						sale.setAlltimeMoney(Double.parseDouble(alltimeMoney));
//						sale.setLast7daySale(Integer.parseInt(last7daySale));
//						sale.setThismonthSale(Integer.parseInt(thismonthSale));
//						sale.setPreviousmonthSale(Integer.parseInt(previousmonthSale));
//						sale.setAlltimeSale(Integer.parseInt(alltimeSale));
//						sale.setDayString(df2.format(df.parse(day)));
//						sale.setDay(df.parse(day));
//						sale.setSale(Integer.parseInt(todaySale));
//						sale.setMoney(Double.parseDouble(todayMoney));
//						sale.setEmail(mech.getEmail());
//						//sale.setId(mech.getId());
//						sale.setIp(mech.getIp());
//						sale.setMoneyyesterday((Double.parseDouble(yesterdayMoney)));
//						sale.setName(mech.getName());
//						sale.setPath(mech.getPath());
//						sale.setUsername(mech.getUsername());
//						sale.setYesterday(Integer.parseInt(yesterdaySale));
//						sale.setStatus("1");
//						try {
//							List<ImageMerch> lst=new ArrayList<>();
//							 List<WebElement> listelement = driver.findElements(By.cssSelector(".todays-shirts-list a"));
//							 List<WebElement> listeSale = driver.findElements(By.cssSelector(".todays-shirts-list .latest-sale-circle"));
//							 List<WebElement> listeRoyalties = driver.findElements(By.cssSelector(".todays-shirts-list .royalties"));
//							 for (int i = 0; i < listelement.size(); i++) {
//								 try {
//									 ImageMerch a=new ImageMerch();
//									 a.setName(listelement.get(i).getAttribute("title"));
//									 a.setUrl(listelement.get(i).getAttribute("href"));
//									 a.setAcc(mech.getName());
//									 a.setSold(Integer.parseInt(listeSale.get(i).getText()));
//									 a.setRoyaltie(new BigDecimal(listeRoyalties.get(i).getText()));
//									 lst.add(a);
//								} catch (Exception e) {
//									System.out.println("loi lay ao sale");
//									continue;
//								}
//								 
//							}
//							
//							 sale.setLstimageMerch(lst);
//							 
//						} catch (Exception e) {
//							//e.printStackTrace();
//						}
//						String jsonString = objectMapper.writeValueAsString(sale);
//						 rep =callApi.callAPIPost("http://45.32.101.196:8080/saveCheckSale", jsonString);
//						 
//						 System.out.println("Thành công");
//					
//					} catch (Exception e) {
//						
//						DateFormat df = new SimpleDateFormat("MM/dd/yy"); 
//						DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); 
//						SaleMerch sale=new SaleMerch();
//						sale.setTier("");
//						sale.setCoutDesgin(0);
//						sale.setLimitslot("0");
//						sale.setTier("0");
//						sale.setLast7dayMoney(new Double("0"));
//						sale.setThismonthMoney(new Double("0"));
//						sale.setPreviousmonthMoney(new Double("0"));
//						sale.setAlltimeMoney(new Double("0"));
//						sale.setLast7daySale(0);
//						sale.setThismonthSale(0);
//						sale.setPreviousmonthSale(0);
//						sale.setAlltimeSale(0);
//						sale.setDayString(df2.format(new Date()));
//						sale.setDay(new Date());
//						sale.setSale(0);
//						sale.setMoney(0);
//						sale.setEmail(mech.getEmail());
//						//sale.setId(mech.getId());
//						sale.setIp(mech.getIp());
//						sale.setMoneyyesterday(new Double("0"));
//						sale.setName(mech.getName());
//						sale.setPath(mech.getPath());
//						sale.setUsername(mech.getUsername());
//						sale.setYesterday(0);
//						sale.setStatus("0");
//						String jsonString = objectMapper.writeValueAsString(sale);
//						 rep =callApi.callAPIPost("http://45.32.101.196:8080/saveCheckSale", jsonString);
//						e.printStackTrace();
//						System.out.println("loi");
//						continue;
//						//e.printStackTrace();
//						
//					}finally {
//						if(driver!=null)
//						{
//							try {
//								driver.quit();
//							} catch (Exception e2) {
//								// TODO: handle exception
//							}
//							
//							//driver.close();
//						}
//						 try {
//							 Process p = Runtime.getRuntime().exec("taskkill /F /IM ChromeDriver.exe");
//							 p.waitFor();
//							Runtime.getRuntime().exec("taskkill /F /IM CHROME.exe");
//							 p.waitFor();
//						} catch (Exception e) {
//							// TODO: handle exception
//						}
//					}
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	
//   }
//}