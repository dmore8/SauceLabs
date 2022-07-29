import io.appium.java_client.AppiumBy;
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

public class prueba_cesta {
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
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Mochila to reshu\"]",driver);
        utility.scroll_down(driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]",driver);
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]",driver);
        WebElement items = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(items,"1 Items"));
        Assert.assertEquals("1 Items",items.getText());
        System.out.println("TEST OK");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
