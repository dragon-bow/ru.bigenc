package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    static ChromeDriver driver;
    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "D:\\downloads\\chromeDriver\\ch\\chromedriver.exe");
        driver = new ChromeDriver();
    }



    @After
    public void after() {
        driver.quit();
    }



}
