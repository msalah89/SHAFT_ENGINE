package testPackage01;


import com.shaft.gui.browser.BrowserFactory;
import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.MouseActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import poms.MSPaintPage;


public class Test_Paint {
    static WebDriver driver;
    private MSPaintPage msPaintPage;

    @BeforeClass
    public void init() {
        System.setProperty("executionAddress", "0.0.0.0:4723");
        System.setProperty("mobile_platformName", "Windows");
        System.setProperty("mobile_app", "C:\\Windows\\System32\\mspaint.exe");
        System.setProperty("deviceName", "Windows10");
        driver = BrowserFactory.getBrowser(BrowserFactory.BrowserType.DESKTOP_WINAPP);
        msPaintPage = new MSPaintPage(driver);

    }


    @Test
    public void moseMove() {
        try {


            MouseActions actions = new MouseActions(driver);


            //ElementActions.click(driver, msPaintPage.ovalShape);
            //msPaintPage.mouseDraw(200, 200,);
            msPaintPage.drawText("SHAFT",11,"",200,200,"");

            ElementActions.performMouseActions(driver).contextClick();

        } catch (Exception e) {
            e.printStackTrace();
            tearDown();

        }
    }

    @AfterClass
    public void tearDown() {
//        if (msPaintPage.getDriver() != null) {
//            msPaintPage();
//        }
    }

}
