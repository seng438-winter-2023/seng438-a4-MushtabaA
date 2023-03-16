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
public class RegisterPreexistingUserTest {
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
  public void registerPreexistingUser() {
    // Test name: Register Pre-existing User
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
    // 7 | click | id=createAccount | 
    driver.findElement(By.id("createAccount")).click();
    // 8 | click | id=email | 
    driver.findElement(By.id("email")).click();
    // 9 | type | id=email | seng401g23@gmail.com
    driver.findElement(By.id("email")).sendKeys("seng401g23@gmail.com");
    // 10 | type | id=newPassword | SENG401Group#23
    driver.findElement(By.id("newPassword")).sendKeys("SENG401Group#23");
    // 11 | click | css=.Password:nth-child(3) .material-icons | 
    driver.findElement(By.cssSelector(".Password:nth-child(3) .material-icons")).click();
    // 12 | click | id=reenterPassword | 
    driver.findElement(By.id("reenterPassword")).click();
    // 13 | type | id=reenterPassword | SENG401Group#23
    driver.findElement(By.id("reenterPassword")).sendKeys("SENG401Group#23");
    // 14 | click | css=.Password:nth-child(4) .material-icons | 
    driver.findElement(By.cssSelector(".Password:nth-child(4) .material-icons")).click();
    // 15 | click | id=continue | 
    driver.findElement(By.id("continue")).click();
    // 16 | click | id=claimVerificationServerError | 
    driver.findElement(By.id("claimVerificationServerError")).click();
    // 17 | click | id=claimVerificationServerError | 
    driver.findElement(By.id("claimVerificationServerError")).click();
  }
}