import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium {
    public AndroidDriver driver;

    public Appium() throws MalformedURLException {
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
}
