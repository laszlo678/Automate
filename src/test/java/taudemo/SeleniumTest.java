package taudemo;


import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
//this way calling this method I dont need to call the whole name which would be Assertions.assertEquals


@TestInstance(PER_CLASS)
public class SeleniumTest {
    private BrowserGetter browserGetter = new BrowserGetter(); //start the browser
    private WebDriver driver; //i will store the browser iniciation

    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getChromeDriver();
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void openTheComPageAndCheckTheTitle() {
        String expectedComTitle = "Example Domain";
        driver.get("https://www.example.com");
        assertEquals(expectedComTitle, driver.getTitle());
        //Assertions.assertEquals(5,5);
    }
    
    @Test
    public void openTheOrgPageAndCheckTheTitle() {
        String expectedOrgTitle = "Example Domain";
        driver.get("https://www.example.org");
        assertEquals(expectedOrgTitle, driver.getTitle());
        //Assertions.assertEquals(5,5);
    }
}
