package my.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The {@link MouseAction} class is a simulator
 * class for performing mouse actions on a
 * web element.
 */
public class MouseAction {

    private WebDriver driver;

    // Constructors

    /**
     * Creates a MouseActor object in memory with
     * default values.
     */
    public MouseAction() {
    }


    /**
     * Creates a MouseActor object in memory with
     * a user-supplied WebDriver.
     * @param driver The user-supplied WebDriver
     */
    public MouseAction(WebDriver driver) {
        this.driver = driver;
    }

    // Setter(s)

    /**
     * Updates the WebDriver with a user-supplied one.
     * @param driver The user-supplied WebDriver.
     */
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // Mouse Action APIs

    /**
     * Hovers over nav-list items
     * @throws InterruptedException If the operation is interrupted
     */
    public void hoverOverListItems() throws InterruptedException {

        String[] items = NavListUtil.getItems();

        // Hover over each nav-list item.
        for(String item: items) {
            WebElement navLink = driver.findElement(By.linkText(item));
            Actions actions = new Actions(driver);
            System.out.println("Hovering over the " + item + " link....");
            actions.moveToElement(navLink).perform();
            Thread.sleep(3000);
        }

    }

    /**
     * Clicks over nav-list items
     * @throws InterruptedException If the operation is interrupted
     */
    public void clickListItems() throws InterruptedException {

        String[] items = NavListUtil.getItems();

        // Click each nav-list item.
        for(String item: items) {
            // Navigate to the webpage pointed at by the nav-list item
            WebElement navLink = driver.findElement(By.linkText(item));
            System.out.println("Clicking on the " + item + " link...");
            navLink.click();
            Thread.sleep(3000);
        }
    }

}
