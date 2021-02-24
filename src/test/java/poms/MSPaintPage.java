package poms;


import com.shaft.gui.element.ElementActions;
import com.shaft.gui.element.MouseActions;
import org.apache.batik.css.engine.value.RGBColorValue;
import org.apache.xmlgraphics.image.codec.png.PNGEncodeParam;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.css.RGBColor;

import java.awt.*;
import java.util.Set;


/**
 * Created by Muthu on 6/23/2018.
 * Page Factory for MS-Paint application
 */
public class MSPaintPage {

    public By ovalShape = By.name("Rectangle");
    public By lineSize = By.name("Size");
    public By paintArea = By.className("Afx:00007FF6E9C10000:8");
    public By line8pixel;
    public By dontSaveButton = By.name("Don't Save");
    public By  editColors = By.name("Edit colors");
    public By  redTxt = By.name("Red:");
    public By  greenTxt = By.name("Green:");
    public By  blueTxt = By.name("Blue:");
    public By  colorsOK = By.name("Ok");
    public By  textButton  = By.name("Text");
    public By sizeTxt = By.className("RICHEDIT50W");

    WebDriver driver;


    public MSPaintPage(WebDriver driver) {

        this.driver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }


    public void drawText(String text , int size , String font , int xOffset , int yOffset, String colorHex){

//        String redColor = String.valueOf(Color.decode(colorHex).getRed());
//        String greenColor = String.valueOf(Color.decode(colorHex).getGreen());
//        String blueColor = String.valueOf(Color.decode(colorHex).getBlue());
        ElementActions.click(this.driver,textButton);
        mouseDraw(xOffset,yOffset,50,80);
        ElementActions.performMouseActions(driver).sendKeys("SHAFT").moveByOffset(-50,-50).doubleClick().sendKeys(Keys.LEFT_ALT,"t","f","s").sendKeys("100");



    }




    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToLastWindow(Set<String> windowHandles) {
        for (String win : windowHandles) {
            driver.switchTo().window(win);
        }
    }

    public void mouseDraw(int elementPositionX, int elementPostionY,
                                int width , int height) {

        int endX = elementPositionX + width;
        int endY = elementPostionY + height;
        ElementActions.performMouseActions(driver).moveByOffset(elementPositionX, elementPostionY)
                .clickAndHold().moveByOffset(endX, endY).release();


    }

}
