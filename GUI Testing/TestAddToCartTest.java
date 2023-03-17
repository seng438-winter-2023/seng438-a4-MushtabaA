// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class TestAddToCartTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testAddToCart() {
    // Test name: testAddToCart
    // Step # | name | target | value
    // 1 | open | https://www.costco.com/ | 
    driver.get("https://www.costco.com/");
    // 2 | setWindowSize | 1936x1048 | 
    driver.manage().window().setSize(new Dimension(1936, 1048));
    // 3 | click | css=#media-cdn-set-30_ins_1 .col-xs-6:nth-child(2) .img-responsive | 
    driver.findElement(By.cssSelector("#media-cdn-set-30_ins_1 .col-xs-6:nth-child(2) .img-responsive")).click();
    // 4 | click | css=.col-xs-6:nth-child(13) .img-responsive | 
    driver.findElement(By.cssSelector(".col-xs-6:nth-child(13) .img-responsive")).click();
    // 5 | mouseOver | css=.product-h1-container-v2 .pill-style-promotions > span | 
    {
      WebElement element = driver.findElement(By.cssSelector(".product-h1-container-v2 .pill-style-promotions > span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 6 | runScript | window.scrollTo(0,0) | 
    js.executeScript("window.scrollTo(0,0)");
    // 7 | runScript | window.scrollTo(0,356) | 
    js.executeScript("window.scrollTo(0,356)");
    // 8 | click | id=add-to-cart-btn | 
    driver.findElement(By.id("add-to-cart-btn")).click();
    // 9 | click | css=a > .btn | 
    driver.findElement(By.cssSelector("a > .btn")).click();
  }
}