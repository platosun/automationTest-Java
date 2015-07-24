import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.james.mime4j.field.datetime.DateTime;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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


import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by madinen on 21/07/2015.
 */
@RunWith(JUnit4.class)
public class Test1 {
    AppiumDriver driver;
    int sessionCounter = 4;

    @BeforeTest
    public void SetUp() throws Exception {
        Capabilitity c = new Capabilitity("Commbank Tablet (SM-T5","Android","4.4",
                "/Users/madinen/Documents/Tablet/And-build-apk/TabletApp-debug.apk","com.cba.android.netbank.debug","");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", c.DeviceName);
        capabilities.setCapability("app", c.AppPath);
        capabilities.setCapability("appium-version", c.AppiumVersion);
        capabilities.setCapability("platformName", c.PlatformName);
        capabilities.setCapability("platformVersion", c.PlatformVersion);
        capabilities.setCapability("appPackage", c.BundleID);
        capabilities.setCapability("appActivity", "com.commbank.netbank.tablet.feature.main.view.activity.MainActivity");
        URL url;
        url = new URL("http://127.0.0.1:4888/wd/hub");
        driver = new AndroidDriver(url, capabilities);


    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }

public void Registration() throws Exception {
    WebElement start = driver.findElement(By.id("welcomeButtonGetStarted"));
    start.click();
    WebElement header = driver.findElement(By.id("welcomeInfoHeader"));
    driver.tap(1, header, 4000);
    driver.findElement(By.id("btn_continue")).click();

    Thread.sleep(3000);
    WebElement SendCode = driver.findElement(By.id("btn_send_netcode"));
    SendCode.click();

    WebElement code = (new WebDriverWait(driver, 60))
            .until(ExpectedConditions.presenceOfElementLocated(By.id("edt_enter_netCode")));
    code.sendKeys("123456");
    WebElement ne = driver.findElement(By.id("btn_continue"));
    ne.click();
    Thread.sleep(2000);
    WebElement one = driver.findElement(By.id("buttonDigit1"));
    one.click();
    WebElement two = driver.findElement(By.id("buttonDigit2"));
    two.click();
    one.click();
    two.click();
    Thread.sleep(2000);
    one.click();
    two.click();
    one.click();
    two.click();
    Thread.sleep(2000);
    WebElement accept = driver.findElement(By.id("btn_accept"));

    accept.click();
    WebElement ele = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("btn_home")));


}
    public void SetTestEnvironment() {
        WebElement one = driver.findElement(By.id("welcomeButtonGetStarted"));
        one.click();
        driver.tap(4, 100, 100, 5);
        WebElement btn_features = driver.findElement(By.id("btn_features"));
        btn_features.click();
        WebElement che = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.RelativeLayout[1]/android.widget.CheckBox[1]"));
        che.click();
        driver.navigate().back();

        WebElement two = driver.findElement(By.id("btn_edit_environment"));
        two.click();
        WebElement anywhereEnvs = driver.findElement(By.id("anywhereEnvs"));
        anywhereEnvs.click();
        List<WebElement> opt = driver.findElementsByClassName("android.widget.TextView");

        opt.get(0).click();
        WebElement btn_save = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("btn_save")));
        btn_save.click();
        System.out.println("Registration is DONE.......");


    }

    public WebElement Login() throws Exception{

        WebElement one = driver.findElement(By.id("buttonDigit1"));

        one.click();

        WebElement two = driver.findElement(By.id("buttonDigit2"));

        two.click();

        one.click();

        two.click();
Thread.sleep(3000);
        return null;
    }


    public WebElement OpenAcountDetail(WebElement accountList) {
        if (accountList != null && accountList.findElements(By.id("imageViewAccountIcon")) != null) {

            accountList.findElements(By.id("imageViewAccountIcon")).get(0).click();
            return null;

        }

        return null;
    }


    public WebElement LogOff() {

        List<WebElement> closeButton = driver.findElements(By.id("btn_close"));
        if(closeButton.size()>0)
            closeButton.get(0).click();
        WebElement home = driver.findElement(By.id("btn_home"));

        home.click();

        WebElement logoff = driver.findElement(By.id("img_log_off"));

        logoff.click();

        driver.findElement(By.id("button1")).click();
        return (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("buttonDigit1")));
    }

    private void DoQuestionaire(int counter) throws Exception{
        List<WebElement> fbbtn = driver.findElements(By.id("feedbackLinkImage"));

        if (counter == sessionCounter) {
            Assert.assertTrue(fbbtn.size() > 0);
            fbbtn.get(0).click();
            driver.findElement(By.id("doItNowButton")).click();
            AnwserQuestionaire();
            WebElement submit = driver.findElement(By.id("done_button"));
            if (submit != null) {
                submit.click();
                WebElement close = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("btn_close")));
                fbbtn = driver.findElements(By.id("feedbackLinkImage"));
                Assert.assertTrue(fbbtn.size() == 0);

            }
        } else if (counter == sessionCounter - 1) {
            List<WebElement> l = driver.findElements(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.ScrollView[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]"));
            Assert.assertTrue(l.size() > 0);
            l.get(0).click();
            WebElement close = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("btn_close")));

            fbbtn = driver.findElements(By.id("feedbackLinkImage"));

            Assert.assertTrue(fbbtn.size() > 0);

        } else
            Assert.assertTrue(fbbtn.size() == 0);
    }

    private void AnwserQuestionaire() throws Exception {
        Thread.sleep(1000);
        List<WebElement> ans = driver.findElements(By.id("answerOption"));

        List<WebElement> comment = driver.findElements(By.id("comment_text_box"));

        if (ans != null && ans.size() > 0 && comment.size() == 0) {
            Random r = new Random();
            int ai = r.nextInt(ans.size() - 1);
            ans.get(ai).click();
            AnwserQuestionaire();
        } else {
            comment.get(0).click();

            Thread.sleep(1000);

            Date d = new Date();
            SimpleDateFormat form = new SimpleDateFormat("yyyy.MM.dd");
            String str = form.format(d);
            comment.get(0).sendKeys("Automation Test Questionaire is awesome " + str);
            driver.hideKeyboard();

        }

    }


    @Test
    public void TestLoadRunningTableQuestionaireBySessionCounter() throws Exception
    {
        SetTestEnvironment();
        Registration();
        for (int i = 0; i <= sessionCounter; i++)
        {
            if(i>0)
                Login();
            WebElement accountsList = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id("accountsList")));
            OpenAcountDetail(accountsList);
            DoQuestionaire(i);
            LogOff();
        }
    }


}
