import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility {
    public Utility() {
    }

    void find_and_click_by_xpath(String xpath, AndroidDriver driver) {
        WebElement el1 = driver.findElement(By.xpath(xpath));
        el1.click();
    }

    void scroll_down(AndroidDriver driver) {
        try {
            driver.findElements(new AppiumBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector()).setAsVerticalList().flingToEnd(20)"));
        } catch (Exception e) {
            // ignore
        }
    }

    void find_and_send_keys_by_xpath(String xpath, String keys, AndroidDriver driver) {
        WebElement el1 = driver.findElement(By.xpath(xpath));
        el1.sendKeys(keys);
    }
}