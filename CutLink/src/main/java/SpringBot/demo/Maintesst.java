package SpringBot.demo;

import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.util.UriEncoder;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maintesst {
	public static WebDriver driver;
	public static void main(String[] args) {
		try {String link2="http://45.32.101.196:8080/download2?username=longtn&imagename=Mama of both bleached Tees Glitter & Dirt Mama Of Both Camo.png";
        String encodedText = URLDecoder.decode(link2, "UTF-8");

        System.out.println(encodedText);
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
