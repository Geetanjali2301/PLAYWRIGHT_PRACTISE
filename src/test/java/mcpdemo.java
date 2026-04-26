import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class mcpdemo {
    public static void main(String[] args) {
        // Initialize Playwright
        Playwright playwright = Playwright.create();

        // Launch Chromium browser in headed mode
        Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions().setHeadless(false)
        );

        // Create a new page
        Page page = browser.newPage();

        // Navigate to Google
        page.navigate("https://www.google.com");

        // Wait for the page to fully load
        page.waitForLoadState();

        // Capture a screenshot and save it
        page.screenshot(new Page.ScreenshotOptions().setPath(
            Paths.get("google_screenshot.png")
        ));

        System.out.println("Screenshot captured successfully as google_screenshot.png");

        // Close the page and browser
        page.close();
        browser.close();

        // Close Playwright
        playwright.close();
    }
}
