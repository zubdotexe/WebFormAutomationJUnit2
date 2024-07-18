import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyJUnit {

    WebDriver driver;
    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void pickDate() {
        WebElement calendarElem = driver.findElement(By.cssSelector("[name=date]"));
        calendarElem.click();
        calendarElem.sendKeys(Keys.CONTROL + "a");

        Date todayDate = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MM/dd/YYYY");
        calendarElem.sendKeys(ft.format(todayDate));
        calendarElem.sendKeys(Keys.ENTER);
    }

    @DisplayName("Submit form")
    @Test
    public void submitForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");

        Thread.sleep(3050);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();

        driver.findElement(By.id("edit-name")).sendKeys("Hannah");

        driver.findElement(By.className("form-number")).sendKeys("01567789129");
        
        Utils.scroll(driver, 500);
        Thread.sleep(3050);
        Utils.scroll(driver, 300);

        pickDate();

        List<WebElement> inputElems = driver.findElements(By.tagName("input"));
        inputElems.get(3).sendKeys("hannah@gmail.com");

        driver.findElement(By.cssSelector("[id=\"edit-tell-us-a-bit-about-yourself-\"]")).sendKeys("Hello there I am Hannah and I am a wildlife photographer. Currently I am doing my Bachelors at John Hopkins University. My CV will be uploaded in the section below. Thank you.");

        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir") + "./src/test/resources/CV-Hannah.pdf");

        Thread.sleep(3050);

        driver.findElement(By.className("form-checkbox")).click();

        driver.findElement(By.id("edit-submit")).click();

        String messageActual = driver.findElement(By.id("block-pagetitle-2")).getText();

        String messageExpected = "Thank you for your submission!";

        Assertions.assertEquals(messageActual, messageExpected);
    }

    @AfterAll
    public void closeBrowser() {
        driver.quit();
    }
}
