package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class navigationDemo {
public static void main(String args[]) {
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://www.amazon.com");
		page.goBack();
		page.navigate("https://www.google.com");
		page.goBack();
		page.goForward();
		page.reload();
		page.close();
		browser.close();
		playwright.close();
		
}
	
}
