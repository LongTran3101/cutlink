package SpringBot.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadFunction {
	
	
	public static void uploadSweat(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD Sweat");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement elembedit = driver.findElement(By.cssSelector(".STANDARD_SWEATSHIRT-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		System.out.println(mech.getMauSweat());
		Thread.sleep(4000);
		List<String> lstmau = Stream.of(mech.getMauSweat().split(",", -1)).collect(Collectors.toList());
		if (!lstmau.contains("1")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".asphalt-checkbox")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".black-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("2")) {
			/*
			 * System.out.println("Co click baby_blue-checkbox");
			 * driver.findElement(By.cssSelector(".baby_blue-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".heather_grey-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("3")) {
			/*
			 * System.out.println("Co click black-checkbox");
			 * driver.findElement(By.cssSelector(".black-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".navy-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("4")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".cranberry-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".royal-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("5")) {
			// System.out.println("Co click");
			WebElement check = driver.findElement(By.cssSelector(".dark_heather-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".heather_grey-checkbox")).click();

		}
		Thread.sleep(1000);

		Thread.sleep(1000);
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPriceSweat());
		Thread.sleep(2000);
	}
	public static void uploadRaglan(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD Raglan");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement elembedit = driver.findElement(By.cssSelector(".RAGLAN-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		Thread.sleep(4000);

		WebElement check = driver.findElement(By.cssSelector(".black_athletic_heather-checkbox"));
		jse.executeScript("arguments[0].click();", check);
		Thread.sleep(1000);
		check = driver.findElement(By.cssSelector(".black_white-checkbox"));
		jse.executeScript("arguments[0].click();", check);

		Thread.sleep(1000);
		check = driver.findElement(By.cssSelector(".dark_heather_white-checkbox"));
		jse.executeScript("arguments[0].click();", check);

		Thread.sleep(1000);
		check = driver.findElement(By.cssSelector(".navy_athletic_heather-checkbox"));
		jse.executeScript("arguments[0].click();", check);

		Thread.sleep(1000);

		check = driver.findElement(By.cssSelector(".navy_white-checkbox"));
		jse.executeScript("arguments[0].click();", check);

		Thread.sleep(1000);
		check = driver.findElement(By.cssSelector(".red_white-checkbox"));
		jse.executeScript("arguments[0].click();", check);
		Thread.sleep(1000);
		check = driver.findElement(By.cssSelector(".royal_blue_white-checkbox"));
		jse.executeScript("arguments[0].click();", check);
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPriceRaglan());
		Thread.sleep(2000);
	}

	public static void uploadLong(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD Long sleeve");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement elembedit = driver.findElement(By.cssSelector(".STANDARD_LONG_SLEEVE-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		System.out.println(mech.getMauLong());
		Thread.sleep(4000);
		List<String> lstmau = Stream.of(mech.getMauLong().split(",", -1)).collect(Collectors.toList());
		if (!lstmau.contains("1")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".asphalt-checkbox")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".black-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("2")) {
			/*
			 * System.out.println("Co click baby_blue-checkbox");
			 * driver.findElement(By.cssSelector(".baby_blue-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".heather_grey-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("3")) {
			/*
			 * System.out.println("Co click black-checkbox");
			 * driver.findElement(By.cssSelector(".black-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".navy-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("4")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".cranberry-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".royal-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("5")) {
			// System.out.println("Co click");
			WebElement check = driver.findElement(By.cssSelector(".dark_heather-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".heather_grey-checkbox")).click();

		}
		Thread.sleep(1000);

		Thread.sleep(1000);
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPriceLong());
		Thread.sleep(2000);
	}

	public static void uploadTank(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD Tank");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement elembedit = driver.findElement(By.cssSelector(".TANK_TOP-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		System.out.println(mech.getMauTank());
		Thread.sleep(4000);
		List<String> lstmau = Stream.of(mech.getMauTank().split(",", -1)).collect(Collectors.toList());
		if (!lstmau.contains("1")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".asphalt-checkbox")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".black-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("2")) {
			/*
			 * System.out.println("Co click baby_blue-checkbox");
			 * driver.findElement(By.cssSelector(".baby_blue-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".dark_heather-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("3")) {
			/*
			 * System.out.println("Co click black-checkbox");
			 * driver.findElement(By.cssSelector(".black-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".heather_grey-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("4")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".cranberry-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".navy-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("5")) {
			// System.out.println("Co click");
			WebElement check = driver.findElement(By.cssSelector(".neon_pink-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".heather_grey-checkbox")).click();

		}
		Thread.sleep(1000);

		if (lstmau.contains("6")) {

			WebElement check = driver.findElement(By.cssSelector(".purple-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".kelly_green-checkbox")).click();

		}

		Thread.sleep(1000);

		if (lstmau.contains("7")) {
			// System.out.println("Co click");
			// driver.findElement(By.cssSelector(".lemon-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".red-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}
		Thread.sleep(1000);

		if (lstmau.contains("8")) {
			WebElement check = driver.findElement(By.cssSelector(".royal-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}
		Thread.sleep(1000);

		if (lstmau.contains("9")) {

			// driver.findElement(By.cssSelector(".olive-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".sapphire-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("10")) {
			WebElement check = driver.findElement(By.cssSelector(".white-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		Thread.sleep(1000);
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPriceTank());
		Thread.sleep(2000);
	}

	public static void uploadVneck(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD Vneck");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement elembedit = driver.findElement(By.cssSelector(".VNECK-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		System.out.println(mech.getMauVneck());
		Thread.sleep(4000);
		List<String> lstmau = Stream.of(mech.getMauVneck().split(",", -1)).collect(Collectors.toList());
		if (lstmau.contains("1")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".asphalt-checkbox")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".baby_blue-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("2")) {
			/*
			 * System.out.println("Co click baby_blue-checkbox");
			 * driver.findElement(By.cssSelector(".baby_blue-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".black-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("3")) {
			/*
			 * System.out.println("Co click black-checkbox");
			 * driver.findElement(By.cssSelector(".black-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".dark_heather-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("4")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".cranberry-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".forest_green-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("5")) {
			// System.out.println("Co click");
			WebElement check = driver.findElement(By.cssSelector(".heather_grey-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".heather_grey-checkbox")).click();

		}
		Thread.sleep(1000);

		if (lstmau.contains("6")) {

			WebElement check = driver.findElement(By.cssSelector(".navy-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".kelly_green-checkbox")).click();

		}

		Thread.sleep(1000);

		if (lstmau.contains("7")) {
			// System.out.println("Co click");
			// driver.findElement(By.cssSelector(".lemon-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".pink-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}
		Thread.sleep(1000);

		if (lstmau.contains("8")) {
			WebElement check = driver.findElement(By.cssSelector(".purple-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}
		Thread.sleep(1000);

		if (lstmau.contains("9")) {

			// driver.findElement(By.cssSelector(".olive-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".red-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}
		Thread.sleep(1000);

		if (lstmau.contains("10")) {
			WebElement check = driver.findElement(By.cssSelector(".sapphire-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		Thread.sleep(1000);
		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPriceVneck());
		Thread.sleep(2000);
	}

	public static void uploadPreTshirt(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD FILE PRE");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(5000);
		WebElement elembedit = driver.findElement(By.cssSelector(".PREMIUM_TSHIRT-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		/* driver.findElement(By.cssSelector(".STANDARD_TSHIRT-edit-btn")).click(); */
		System.out.println("EDIT FILE");

		// System.out.println();
		System.out.println(mech.getTypeTshirtPre());
		List<String> typetshirt = Stream.of(mech.getTypeTshirt().split(",", -1)).collect(Collectors.toList());
		Thread.sleep(10000);
		System.out.println("Check men");

		if (!typetshirt.contains("1")) {
			/*
			 * System.out.println("k click");
			 * driver.findElement(By.cssSelector(".men-checkbox i")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".men-checkbox i"));

			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("Sau check men");

		Thread.sleep(1000);

		if (!typetshirt.contains("2")) {
			WebElement check = driver.findElement(By.cssSelector(".women-checkbox i"));

			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("trc check kid");
		Thread.sleep(1000);

		if (typetshirt.contains("3")) {
			/* System.out.println("kclick"); */
			/* driver.findElement(By.cssSelector(".youth-checkbox i")).click(); */
			WebElement check = driver.findElement(By.cssSelector(".youth-checkbox i"));

			jse.executeScript("arguments[0].click();", check);

		}
		System.out.println("sau check kid");
		System.out.println(mech.getMaupre());
		// select mau
		Thread.sleep(4000);
		List<String> lstmau = Stream.of(mech.getMaupre().split(",", -1)).collect(Collectors.toList());
		if (lstmau.contains("1")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".asphalt-checkbox")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".asphalt-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("2")) {
			/*
			 * System.out.println("Co click baby_blue-checkbox");
			 * driver.findElement(By.cssSelector(".baby_blue-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".baby_blue-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("3")) {
			/*
			 * System.out.println("Co click black-checkbox");
			 * driver.findElement(By.cssSelector(".black-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".black-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau blackcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("4")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".cranberry-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".cranberry-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau cranberrycheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("5")) {
			// System.out.println("Co click");
			WebElement check = driver.findElement(By.cssSelector(".heather_grey-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".heather_grey-checkbox")).click();

		}

		System.out.println("sau heathergreycheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("6")) {

			WebElement check = driver.findElement(By.cssSelector(".kelly_green-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".kelly_green-checkbox")).click();

		}

		System.out.println("sau kellygreencheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("7")) {
			// System.out.println("Co click");
			// driver.findElement(By.cssSelector(".lemon-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".lemon-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau lemoncheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("8")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".navy-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".navy-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau navycheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("9")) {

			// driver.findElement(By.cssSelector(".olive-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".olive-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau olivecheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("10")) {
			System.out.println("Co click");

			WebElement check = driver.findElement(By.cssSelector(".orange-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau orangecheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("11")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".pink-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".pink-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau pinkcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("12")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".purple-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".purple-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau purplecheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("13")) {
			// System.out.println("Co click");
			// driver.findElement(By.cssSelector(".red-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".red-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau redcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("14")) {
			System.out.println("Co click");
			/*
			 * driver.findElement(By.cssSelector(".royal-checkbox")).sendKeys(Keys.RETURN);
			 */
			WebElement check = driver.findElement(By.cssSelector(".royal-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau royalcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("15")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".white-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".white-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("16")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".brown-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".brown-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("17")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".dark_heather-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".dark_heather-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("18")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".grass-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".grass-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("19")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".heather_blue-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".heather_blue-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("20")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".silver-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".silver-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("21")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".slate-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".slate-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPricePre());
		Thread.sleep(2000);
	}

	public static void uploadTshirt(WebDriver driver, uploadFile mech) throws Exception {

		System.out.println("UPLOAD FILE");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(25000);
		WebElement elembedit = driver.findElement(By.cssSelector(".STANDARD_TSHIRT-edit-btn"));
		elembedit.sendKeys(Keys.ENTER);
		/* driver.findElement(By.cssSelector(".STANDARD_TSHIRT-edit-btn")).click(); */
		System.out.println("EDIT FILE");

		// System.out.println();
		System.out.println(mech.getTypeTshirt());
		List<String> typetshirt = Stream.of(mech.getTypeTshirt().split(",", -1)).collect(Collectors.toList());
		Thread.sleep(10000);
		System.out.println("Check men");

		if (!typetshirt.contains("1")) {
			/*
			 * System.out.println("k click");
			 * driver.findElement(By.cssSelector(".men-checkbox i")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".men-checkbox i"));

			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("Sau check men");

		Thread.sleep(1000);

		if (!typetshirt.contains("2")) {
			WebElement check = driver.findElement(By.cssSelector(".women-checkbox i"));

			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("trc check kid");
		Thread.sleep(1000);

		if (typetshirt.contains("3")) {
			/* System.out.println("kclick"); */
			/* driver.findElement(By.cssSelector(".youth-checkbox i")).click(); */
			WebElement check = driver.findElement(By.cssSelector(".youth-checkbox i"));

			jse.executeScript("arguments[0].click();", check);

		}
		System.out.println("sau check kid");
		// select mau
		Thread.sleep(4000);
		List<String> lstmau = Stream.of(mech.getMau().split(",", -1)).collect(Collectors.toList());
		if (lstmau.contains("1")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".asphalt-checkbox")).click();
			 */

			WebElement check = driver.findElement(By.cssSelector(".asphalt-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("2")) {
			/*
			 * System.out.println("Co click baby_blue-checkbox");
			 * driver.findElement(By.cssSelector(".baby_blue-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".baby_blue-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (!lstmau.contains("3")) {
			/*
			 * System.out.println("Co click black-checkbox");
			 * driver.findElement(By.cssSelector(".black-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".black-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau blackcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("4")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".cranberry-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".cranberry-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau cranberrycheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("5")) {
			// System.out.println("Co click");
			WebElement check = driver.findElement(By.cssSelector(".heather_grey-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".heather_grey-checkbox")).click();

		}

		System.out.println("sau heathergreycheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("6")) {

			WebElement check = driver.findElement(By.cssSelector(".kelly_green-checkbox"));
			jse.executeScript("arguments[0].click();", check);
			// driver.findElement(By.cssSelector(".kelly_green-checkbox")).click();

		}

		System.out.println("sau kellygreencheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("7")) {
			// System.out.println("Co click");
			// driver.findElement(By.cssSelector(".lemon-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".lemon-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau lemoncheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("8")) {
			/*
			 * System.out.println("Co click");
			 * driver.findElement(By.cssSelector(".navy-checkbox")).click();
			 */
			WebElement check = driver.findElement(By.cssSelector(".navy-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau navycheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("9")) {

			// driver.findElement(By.cssSelector(".olive-checkbox")).click();
			WebElement check = driver.findElement(By.cssSelector(".olive-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau olivecheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("10")) {
			System.out.println("Co click");

			WebElement check = driver.findElement(By.cssSelector(".orange-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau orangecheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("11")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".pink-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".pink-checkbox"));
			jse.executeScript("arguments[0].click();", check);
		}

		System.out.println("sau pinkcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("12")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".purple-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".purple-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau purplecheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("13")) {
			// System.out.println("Co click");
			// driver.findElement(By.cssSelector(".red-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".red-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau redcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("14")) {
			System.out.println("Co click");
			/*
			 * driver.findElement(By.cssSelector(".royal-checkbox")).sendKeys(Keys.RETURN);
			 */
			WebElement check = driver.findElement(By.cssSelector(".royal-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		System.out.println("sau royalcheckbox");
		Thread.sleep(1000);

		if (lstmau.contains("15")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".white-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".white-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("16")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".brown-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".brown-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("17")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".dark_heather-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".dark_heather-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("18")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".grass-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".grass-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("19")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".heather_blue-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".heather_blue-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("20")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".silver-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".silver-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(1000);

		if (lstmau.contains("21")) {
			System.out.println("Co click");
			// driver.findElement(By.cssSelector(".slate-checkbox")).sendKeys(Keys.RETURN);
			WebElement check = driver.findElement(By.cssSelector(".slate-checkbox"));
			jse.executeScript("arguments[0].click();", check);

		}

		Thread.sleep(2000);
		WebElement price = driver.findElement(By.cssSelector("input[formcontrolname='amount']"));
		price.sendKeys(Keys.CONTROL + "a");
		price.sendKeys(Keys.DELETE);
		price.sendKeys(mech.getPrice());
		Thread.sleep(2000);
	}
}
