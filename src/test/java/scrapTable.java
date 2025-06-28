import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.commons.function.Try;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class scrapTable {
    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void scrapData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        try {
        WebElement table= driver.findElement(By.cssSelector(".table-responsive.inner-scroll")); //table

            FileWriter writer = new FileWriter("src/test/resources/table_list");

        List<WebElement> allRows = table.findElements(By.tagName("tr")); //row
        for (WebElement row : allRows)
        {
            List<WebElement> cells = row.findElements(By.tagName("td")); //cell

            for (WebElement cell : cells)
            {
                String text = cell.getText().trim();
                writer.write(String.format("%-20s", text)); // each column fixed width

            }
            if (!cells.isEmpty()) {
                writer.write("\n");
            }
        }

            writer.close();
            System.out.println("Data saved to share_table.txt");
        }
        catch (IOException e) {
            System.out.println("File writing failed: " + e.getMessage());
        }

    }

    // @AfterAll
    public void Teardown()
    {
        driver.quit();
    }
}
