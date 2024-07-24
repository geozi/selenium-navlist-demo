package my.project;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main
{
    public static void main( String[] args )
    {
        String website = "https://www.telekom.com";
        WebDriver driver = new ChromeDriver();
        MouseAction mouseAction = new MouseAction(driver);

        try {

            /*
            Navigate to the company's landing page
            and maximize the browser window.
             */
            System.out.println("Navigating to " + website);
            driver.get(website);
            Thread.sleep(3000);
            System.out.println("Maximizing browser window...");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            /*
            Check if a pop-up window is displayed and
            click it to proceed with the rest of the testing.
             */
            WebElement popUpWindow = driver.findElement(By.id("promptLayerContent"));
            if(popUpWindow.isDisplayed()) {
                WebElement acceptCookiesBtn = driver.findElement(By.id("consentAcceptAll"));
                System.out.println("Clicking on the pop-up window...");
                acceptCookiesBtn.click();
                Thread.sleep(3000);
            }

            // Perform mouse actions.
            mouseAction.hoverOverListItems();
            Thread.sleep(3000);

            // Refresh page.
            System.out.println("Refreshing the page...");
            driver.navigate().refresh();
            Thread.sleep(3000);

            // Perform mouse actions.
            mouseAction.clickListItems();
            Thread.sleep(3000);

            /*
            Return to the company's landing page
            and set the size of the browser window to
            400x814 (responsive)
             */
            System.out.println("Returning to landing page...");
            driver.get(website);
            Thread.sleep(3000);
            System.out.println("Resizing browser window to 400x814...");
            driver.manage().window().setSize(new Dimension(400, 814));
            Thread.sleep(3000);


        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Exiting the program...");
        driver.quit();


    }
}
