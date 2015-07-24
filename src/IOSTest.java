import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by madinen on 21/07/2015.
 */
@RunWith(JUnit4.class)
public class IOSTest
{
    IOSDriver driver;

    @BeforeTest
    public  void SetUp() throws MalformedURLException {
        Capabilitity c=new Capabilitity("iPad mini 2 -8.0","iOS","8.0.2",
                "/Users/madinen/Pluto/automationTest/apps/CommBankTabletMock.app",
                "au.com.commbank.netbank.mock","a009809586a16563ee3d60f6ee85c3a74d951780");
        //Capabilitity c=new Capabilitity("iPad Air","iOS","8.0",
          //      "/Users/madinen/Pluto/automationTest/apps/CommBankTabletMock.app",
            //    "","");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", c.DeviceName);
        capabilities.setCapability("appium-version", c.AppiumVersion);
        capabilities.setCapability("platformName", c.PlatformName);
        capabilities.setCapability("platformVersion", c.PlatformVersion);
        capabilities.setCapability("app", c.AppPath);
        capabilities.setCapability("udid", c.UDID);
        capabilities.setCapability("bundleId", c.BundleID);
        
        URL url;
        url = new URL("http://127.0.0.1:4888/wd/hub");
        driver = new IOSDriver(url, capabilities);


    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }

    @Test
    public  void MyTest() throws InterruptedException {
       WebElement getStart =  (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
        getStart.click();
        WebElement clientID = driver.findElement(By.className("UIATextField"));
        clientID.sendKeys("98765432");
        WebElement clienPwd = driver.findElement(By.className("UIASecureTextField"));
        clienPwd.sendKeys("12345678");
        WebElement next = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
        next.click();

        Thread.sleep(2000);
        WebElement SendCode =  (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")));
        SendCode.click();

        WebElement code = (new WebDriverWait(driver,60))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("UIATextField")));
        code.sendKeys("123456");
        WebElement ne = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
        ne.click();
        Thread.sleep(2000);
        WebElement n = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"));
        n.click();
        Thread.sleep(2000);
         n = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]"));
        n.click();
        Thread.sleep(3000);
        n = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]"));
        Keyboard kb=driver.getKeyboard();
        kb.pressKey("1");
       kb.pressKey("2");
        kb.pressKey("1");
        kb.pressKey("2");
        Thread.sleep(2000);
        n = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]"));
        kb=driver.getKeyboard();
        kb.pressKey("1");
        kb.pressKey("2");
        kb.pressKey("1");
        kb.pressKey("2");
        Thread.sleep(3000);
        n = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[4]"));
        n.click();

WebElement ele = (new WebDriverWait(driver,60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAImage[1]")));

    }
}
