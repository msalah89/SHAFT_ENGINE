package com.shaft.gui.element;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import java.util.List;


public class MouseActions {

    private final String unsupportedMethodMessage = "Please use By instead of WebElement";
    public WebDriver driver;
    private Actions mouseActions;

    public MouseActions(WebDriver driver) {

        this.driver = driver;
        mouseActions = new Actions(driver);
    }


    /**
     * Clicks at the current mouse location.
     *
     * @return a self-reference to be used to chain actions
     */
    public MouseActions click() {

        (new Actions(this.driver)).click().perform();
        List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "click", null, true);
        ElementActions.passAction(this.driver, null, screenshot);
        return this;

    }

    /**
     * Clicks (without releasing) at the current mouse location.
     *
     * @return a self-reference to be used to chain actions
     */
    public MouseActions clickAndHold() {

        (new Actions(this.driver)).clickAndHold().perform();
        List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "clickAndHold", null, true);
        ElementActions.passAction(this.driver, null, screenshot);
        return this;
    }


    /**
     * Performs a context-click at the current mouse location.
     *
     * @return a self-reference to be used to chain actions
     */
    public MouseActions contextClick() {
        (new Actions(this.driver)).contextClick().perform();
        List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "contextClick", null, true);
        ElementActions.passAction(this.driver, null, screenshot);
        return this;
    }

    /**
     * Performs a double-click at the current mouse location.
     *
     * @return a self-reference to be used to chain actions
     */
    public MouseActions doubleClick() {
        (new Actions(this.driver)).doubleClick().perform();
        List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "doubleClick", null, true);
        ElementActions.passAction(this.driver, null, screenshot);
        return this;
    }

    /**
     * Moves the mouse from its current position (or 0,0) by the given offset. If the coordinates
     * provided are outside the viewport (the mouse will end up outside the browser window) then
     * the viewport is scrolled to match.
     *
     * @param xOffset horizontal offset. A negative value means moving the mouse left.
     * @param yOffset vertical offset. A negative value means moving the mouse up.
     * @return a self-reference to be used to chain actions
     */
    public MouseActions moveByOffset(int xOffset, int yOffset) {
        try {
            (new Actions(this.driver)).moveByOffset(xOffset, yOffset).perform();
            String offSetData = "xOffset : " + xOffset + "yOffset : " + yOffset;
            List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "doubleClick", offSetData, true);
            ElementActions.passAction(this.driver, null, screenshot);
        } catch (MoveTargetOutOfBoundsException rootCauseException) {

            ElementActions.failAction(driver, null, rootCauseException);

        }
        return this;
    }

    /**
     * Equivalent to calling:
     * <i>Actions.click(element).sendKeys(keysToSend)
     *
     * @param keys The keys.
     * @return a self-reference to be used to chain actions
     * @see #sendKeys(java.lang.CharSequence[])
     */
    public MouseActions sendKeys(CharSequence... keys) {
        try {
            String keysData = "";
            for (CharSequence key : keys) {
                (new Actions(this.driver)).sendKeys(key).pause(3000).perform();
                keysData += key + " , ";
            }

            List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "sendKeys", keysData, true);
            ElementActions.passAction(this.driver, null, screenshot);
        } catch (IllegalArgumentException rootCauseException) {
            ElementActions.failAction(driver, null, rootCauseException);


        }
        return this;
    }

    /**
     * Performs a double-click at the current mouse location.
     *
     * @return a self-reference to be used to chain actions
     */
    public MouseActions release() {
        (new Actions(this.driver)).release().perform();

        List<Object> screenshot = ElementActions.takeScreenshot(driver, null, "mouse release", null, true);
        ElementActions.passAction(this.driver, null, screenshot);
        return this;
    }

}
