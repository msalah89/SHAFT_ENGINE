/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testPackage01;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotePadTest {

    static WebDriver driver;
    private final By editTextBox = By.className("Edit");
    private final By dontSaveBtn = By.name("Don't Save");

    @BeforeClass
    public void setup() {

        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("mobile_platformName", "Windows");
        System.setProperty("mobile_app","C:\\Windows\\System32\\notepad.exe");
        System.setProperty("deviceName","Windows10");
        driver =BrowserFactory.getBrowser(BrowserFactory.BrowserType.DESKTOP_WINAPP );
    }

    @AfterClass
    public void teardown()  {
        BrowserActions.closeCurrentWindow(driver);
        ElementActions.click(driver,dontSaveBtn);

    }
    @Test
    public void testNotePad() {
        ElementActions.type(driver,editTextBox,"Hello World from SHAFT Engine!");

    }


}
