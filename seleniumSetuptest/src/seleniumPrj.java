

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.List;
import java.util.regex.Pattern;

public class seleniumPrj {
	private Selenium selenium;
	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.n11.com/");
		selenium.start();
	}

	@Test
	public void testSeleniumPrj() throws Exception {
		
		selenium.open("/");
		selenium.click("link=Giriş Yap");
		selenium.waitForPageToLoad("30000");
		
		//1
		selenium.click("xpath=/html/body/div[2]/div[2]/div/div[1]/div/div/div[1]/form/div[4]");
		selenium.waitForPageToLoad("30000");
		
		//2
		String url = selenium.getLocation();
		
			if("http://www.n11.com/".equals(url))
			{
				System.out.println("Anasayfa açıldı");
			}
			else
			{
				System.out.println("Anasayfa Açılmadı!!");
				System.exit(0);
			}
			
		//3	
			selenium.click("link=Çıkış");
			selenium.waitForPageToLoad("30000");
			selenium.click("link=Giriş Yap");
			selenium.waitForPageToLoad("30000");
			selenium.type("id=email", "seleniumtest@mynet.com");
			selenium.type("id=password", "a112358");
			selenium.click("id=loginButton");
			selenium.waitForPageToLoad("30000");
			
		//4
		selenium.click("id=contentWrapper");
		selenium.type("id=productSearchInput", "samsung");
		selenium.click("id=btnSearch");
		selenium.waitForPageToLoad("30000");
		
		//5
			try
			{
				assertTrue(selenium.isTextPresent("bulundu"));
				System.out.println("Samsung bulundu");
			}
				catch (Throwable e)
				{
					System.out.println("Samsung bulunamadı");
					System.exit(0);
				}
		//6
		selenium.click("link=2");
		selenium.waitForPageToLoad("30000");
		
		String pageNum=selenium.getValue("//*[@name='currentPage']");
		System.out.println(pageNum + ". Sayfa Şu An Gösterimde");
		
		//7
		selenium.click("xpath=/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/div[5]/div[2]/div[1]/div[3]/div");
		selenium.waitForPageToLoad("30000");

		String izleUrl = selenium.getLocation();
		
		selenium.click("link=İzlemeye Al");
		selenium.waitForPageToLoad("30000");
		
		//8
		selenium.click("link=İzlediklerim");
		selenium.waitForPageToLoad("30000");
		
		//9
		String productLink = selenium.getValue("xpath=/html/body/div[2]/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[3]/p/a/@href");
		
		if(productLink.equals(izleUrl))
		{
			System.out.println("izlenen ürün bulundu");
		}
		else
		{
			System.out.println("ürün bulunamadı!!");
			System.exit(0);
		}
		
		
		//10	
		selenium.click("name=itemSelected");
		selenium.click("link=Kaldır");
		selenium.waitForPageToLoad("30000");
		
		//11
		try
		{
			assertTrue(selenium.isTextPresent(izleUrl));
			System.out.println("izlenen ürün var");
		}
			catch (Throwable e)
			{
				System.out.println("ürün artık izlenmiyor");
			}

		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
