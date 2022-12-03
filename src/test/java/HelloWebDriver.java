import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HelloWebDriver {
    private static final Logger LOGGER = Logger.getLogger(HelloWebDriver.class);
    public static void main(String[] args) throws InterruptedException {


        WebDriver chromeDriver  = new ChromeDriver();
        chromeDriver.get("http://ya.ru");
        WebElement searchYa = chromeDriver.findElement(By.id("text"));
        searchYa.sendKeys("Кто такой котик Степа");
        WebElement searchBtn = chromeDriver.findElement(By.xpath("//*[@type=\"submit\"]"));
        searchBtn.click();
        Thread.sleep(10000);
        chromeDriver.quit();
    }
    //for the new commit
    //for the new commit2
}
