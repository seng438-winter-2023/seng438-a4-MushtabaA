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
public class LoginInvalidEmailAndPasswordTest {
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
  public void loginInvalidEmailAndPassword() {
    // Test name: Login Invalid Email And Password
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://www.costco.com/");
    // 2 | setWindowSize | 1600x761 | 
    driver.manage().window().setSize(new Dimension(1600, 761));
    // 3 | mouseOver | id=header_sign_in | 
    {
      WebElement element = driver.findElement(By.id("header_sign_in"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 4 | click | id=header_sign_in | 
    driver.findElement(By.id("header_sign_in")).click();
    // 5 | type | id=signInName | seng401g23@gmail.com
    driver.findElement(By.id("signInName")).sendKeys("seng401g23@gmail.com");
    // 6 | type | id=password | SENG401Group#23
    driver.findElement(By.id("password")).sendKeys("SENG401Group#23");
    // 7 | click | id=signInName | 
    driver.findElement(By.id("signInName")).click();
    // 8 | type | id=signInName | seng401g23@gmail.comff
    driver.findElement(By.id("signInName")).sendKeys("seng401g23@gmail.comff");
    // 9 | type | id=password | password
    driver.findElement(By.id("password")).sendKeys("password");
    // 10 | click | id=next | 
    driver.findElement(By.id("next")).click();
    // 11 | click | css=.pageLevel > p | 
    driver.findElement(By.cssSelector(".pageLevel > p")).click();
    // 12 | click | css=.pageLevel > p | 
    driver.findElement(By.cssSelector(".pageLevel > p")).click();
    // 13 | doubleClick | css=.pageLevel > p | 
    {
      WebElement element = driver.findElement(By.cssSelector(".pageLevel > p"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    // 14 | click | css=.pageLevel > p | 
    driver.findElement(By.cssSelector(".pageLevel > p")).click();
  }
}