import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class webforms_learners {
    WebDriver driver;
    @BeforeAll

    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void visitUrl() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        try {
            WebElement cookieButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            cookieButton.click();
        } catch (Exception e)
        {

        }

        WebElement NameField = driver.findElement(By.id("edit-name"));
        NameField.click();
        NameField.sendKeys("Fariha jahan");
        Thread.sleep(2000);

        WebElement phnNum =driver.findElement(By.id("edit-number"));
        phnNum.click();
        phnNum.sendKeys("0153176546");
        Thread.sleep(2000);
        WebElement datePicker =driver.findElement(By.id("edit-date"));
        datePicker.click();
        datePicker.sendKeys("6/26/2025");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        Thread.sleep(2000);

        WebElement email =driver.findElement(By.id("edit-email"));
        email.click();
        email.sendKeys("fariha21@gmail.com");

        Thread.sleep(2000);

        WebElement txtField =driver.findElement(By.tagName("textarea"));
        txtField.click();
        txtField.sendKeys("i want to become a SQA Engineer,i an learning automation");
        Thread.sleep(2000);

        WebElement uploadFile = driver.findElement(By.cssSelector("input[type='file']"));
        uploadFile.sendKeys("C:\\Users\\jahan\\OneDrive\\Documents\\Fariha jahan resume.pdf");


        Thread.sleep(2000);
        WebElement checklist = driver.findElement(By.id("edit-age"));
        checklist.click();

        Thread.sleep(2000);
        WebElement btn = driver.findElement(By.id("edit-submit"));
        btn.click();

        WebElement btnresult =driver.findElement(By.tagName("h1"));
       String actualResult= btnresult.getText();
       String expectedResult ="Thank you for your submission!";
        Assertions.assertTrue(actualResult.contains(expectedResult));



    }
    // @AfterAll
    public void Teardown()
    {
        driver.quit();
    }



}
