import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class StepsMovil {

    public static Appium appium;
    private Utility utility = new Utility();

    public static Appium getAppium() {
        return appium;
    }

    @Given("Encender el movil")
    public void encender_movil() {
        System.out.println("Encendiendo el movil");
    }

    @And("Abrir la aplicacion")
    public void abrir_aplicacion() throws MalformedURLException {
        appium = new Appium();
    }

    @And("Se visualiza la aplicacion")
    public void se_visualiza_aplicacion() {
        WebElement el1 = appium.driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup/android.widget.TextView"));
        Assert.assertTrue(el1.isDisplayed());
    }

    @And("Hacer clic en la mochila")
    public void clic_en_mochila() {
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Mochila to reshu\"]",appium.driver);
    }

    @And("Incluir en el carrito")
    public void incluir_carrito() {
        utility.scroll_down(appium.driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]",appium.driver);
    }

    @And("Hacer clic en el carrito")
    public void clic_en_carrito() {
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]",appium.driver);
    }

    @Then("Comprobar que esta en el carrito")
    public void comprobar_carrito() {
        WebElement items = appium.driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[2]"));
        WebDriverWait wait= new WebDriverWait(appium.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(items,"1 Items"));
        Assert.assertEquals("1 Items",items.getText());
    }

    @And("Hacer clic en la camiseta")
    public void clic_camiseta() {
        utility.scroll_down(appium.driver);
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Sauce Lab Onesie\"]",appium.driver);
    }

    @And("Hacer clic en comprar")
    public void clic_en_comprar() {
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Confirms products for checkout\"]",appium.driver);
    }

    @And("Rellenar los datos")
    public void rellenar_datos() {
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText","Dani",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText","Calle Piruleta",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.EditText","Barcelona",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.EditText","08970",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText","Spain",appium.driver);

    }

    @And("Hacer login")
    public void hacer_login() {
        utility.find_and_send_keys_by_xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.widget.EditText","bod@example.com",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.EditText","10203040",appium.driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]",appium.driver);
    }

    @And("Ir a metodos de pago")
    public void ir_a_metodos_de_pago() {
        utility.scroll_down(appium.driver);
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Saves user info for checkout\"]",appium.driver);
    }

    @And("Rellenar metodo de pago")
    public void rellenar_metodos_de_pago() {
        WebElement payment = appium.driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.TextView[2]"));
        WebDriverWait wait= new WebDriverWait(appium.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(payment,"Enter a payment method"));
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[1]/android.widget.EditText","Dani",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[2]/android.widget.EditText","1234",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[3]/android.widget.EditText","03/25",appium.driver);
        utility.find_and_send_keys_by_xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.RelativeLayout[4]/android.widget.EditText","123",appium.driver);
    }

    @And("Hacer clic en revisar compra")
    public void clic_revisar_compra(){
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Saves payment info and launches screen to review checkout data\"]",appium.driver);

    }

    @And("Hacer clic en realizar compra")
    public void clic_realizar_compra(){
        WebElement review = appium.driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.TextView[2]"));
        WebDriverWait wait = new WebDriverWait(appium.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(review,"Review your order"));
        utility.find_and_click_by_xpath("//android.widget.Button[@content-desc=\"Completes the process of checkout\"]",appium.driver);
    }

    @Then("Comprobar que la compra se ha realizado")
    public void comprabar_compra_realizada(){
        WebElement fin = appium.driver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"Manages scrolling of views in given screen\"]/android.view.ViewGroup/android.widget.TextView[2]"));
        WebDriverWait wait= new WebDriverWait(appium.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBePresentInElement(fin,"Thank you for your order"));
        Assert.assertEquals("Thank you for your order",fin.getText());
    }

    @And("Hacer clic en el menu")
    public void clic_en_menu() {
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"View menu\"]",appium.driver);
    }

    @And("Hacer clic en la opcion Report a Bug")
    public void clic_en_report_bug() {
        utility.find_and_click_by_xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[9]/android.widget.TextView",appium.driver);
    }

    @And("Escribir el bug")
    public void escribir_bug() {
        utility.find_and_send_keys_by_xpath("//android.widget.EditText[@content-desc=\"Your message\"]","Falla el carrito",appium.driver);
    }

    @And("Hacer clic en enviar")
    public void clic_enviar() {
        utility.find_and_click_by_xpath("//android.widget.ImageView[@content-desc=\"Send\"]",appium.driver);
    }

    @Then("Comprobar que el mensaje se ha enviado")
    public void comprobar_mensaje_enviado() {
        WebDriverWait wait= new WebDriverWait(appium.driver, Duration.ofSeconds(30));
        WebElement el2 = appium.driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView"));
        wait.until(ExpectedConditions.textToBePresentInElement(el2,"Thank you for your feedback"));
        Assert.assertEquals("Thank you for your feedback",el2.getText());
        Assert.assertTrue(el2.isDisplayed());
    }


}
