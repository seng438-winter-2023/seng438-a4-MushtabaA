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
public class LoginValidEmailAndPasswordTest {
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
  public void loginValidEmailAndPassword() {
    // Test name: Login Valid Email And Password
    // Step # | name | target | value
    // 1 | open | / | 
    driver.get("https://www.costco.com/");
    // 2 | setWindowSize | 1600x761 | 
    driver.manage().window().setSize(new Dimension(1600, 761));
    // 3 | click | id=header_sign_in | 
    driver.findElement(By.id("header_sign_in")).click();
    // 4 | type | id=signInName | seng401g23@gmail.com
    driver.findElement(By.id("signInName")).sendKeys("seng401g23@gmail.com");
    // 5 | type | id=password | SENG401Group#23
    driver.findElement(By.id("password")).sendKeys("SENG401Group#23");
    // 6 | click | id=signInName | 
    driver.findElement(By.id("signInName")).click();
    // 7 | click | id=signInName | 
    driver.findElement(By.id("signInName")).click();
    // 8 | doubleClick | id=signInName | 
    {
      WebElement element = driver.findElement(By.id("signInName"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    // 9 | click | id=signInName | 
    driver.findElement(By.id("signInName")).click();
    // 10 | click | css=.material-icons | 
    driver.findElement(By.cssSelector(".material-icons")).click();
    // 11 | click | id=next | 
    driver.findElement(By.id("next")).click();
    // 12 | runScript | window.scrollTo(0,36) | 
    js.executeScript("window.scrollTo(0,36)");
    // 13 | runScript | window.scrollTo(0,113) | 
    js.executeScript("window.scrollTo(0,113)");
    // 14 | click | id=shopAsNonMemberBtn | 
    driver.findElement(By.id("shopAsNonMemberBtn")).click();
    // 15 | assertText | id=myaccount-react-d | Account
    assertThat(driver.findElement(By.id("myaccount-react-d")).getText(), is("Account"));
  }
}
