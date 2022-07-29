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

public class prueba_report_bug {
    private AndroidDriver driver;
    private final Utility utility = new Utility();

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
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"View menu\"]",driver);
        utility.find_and_click_by_xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[9]/android.widget.TextView",driver);
        WebElement el1 = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Your message\"]"));
        el1.sendKeys("Falla el carrito");
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Send\"]",driver);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement el2 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView"));
        wait.until(ExpectedConditions.textToBePresentInElement(el2,"Thank you for your feedback"));
        Assert.assertEquals("Thank you for your feedback",el2.getText());
        Assert.assertTrue(el2.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
