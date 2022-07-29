import io.appium.java_client.android.AndroidDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features/"},
        plugin = {"pretty", "summary",
                "junit:target/report_cucumber/xml_reports/cucumber.xml",
                "html:target/report_cucumber/html_reports",
                "json:target/report_cucumber/json-reports/cucumber.json"
        },
        tags = "@bug")




public class RunCucumber_Test {



        @AfterClass
        public static void tearDown() {
                StepsMovil.getAppium().driver.quit();
        }

}
