import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class prueba_compra {
    private AndroidDriver driver;
    private Utility utility = new Utility();


    @Before
    public  void setUp() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=TestApp.apk");
        caps.setCapability("appium:deviceName", "Samsung Galaxy S9");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "test");
        sauceOptions.setCapability("name", "testName");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://dmore8:5ca28e7b-e1d2-4a09-8a55-e4115f6f71c2@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        driver = new AndroidDriver(url, caps);
    }

    @Test
    public void sampleTest() {
        utility.scroll_down(driver);
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Sauce Lab Onesie\"]",driver);
        utility.scroll_down(driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]",driver);
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]",driver);
        WebElement items = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(items,"1 Items"));
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Confirms products for checkout\"]",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.widget.EditText","bod@example.com",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.EditText","10203040",driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText","Dani",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText","Calle Piruleta",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.EditText","Barcelona",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.EditText","08970",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText","Spain",driver);
        utility.scroll_down(driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Saves user info for checkout\"]",driver);
        WebElement payment = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.TextView[2]"));
        wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(payment,"Enter a payment method"));
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.widget.EditText","Dani",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.EditText","1234",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[3]/android.widget.EditText","03/25",driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[4]/android.widget.EditText","123",driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Saves payment info and launches screen to review checkout data\"]",driver);
        WebElement review = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.TextView[2]"));
        wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(review,"Review your order"));
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Completes the process of checkout\"]",driver);
        WebElement fin = driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.TextView[2]"));
        wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(fin,"Thank you for your order"));
        Assert.assertEquals("Thank you for your order",fin.getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
