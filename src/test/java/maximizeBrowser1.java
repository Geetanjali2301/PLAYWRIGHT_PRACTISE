package testcases;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class maximizeBrowser1 {
	
	public static void main(String srgs[]) {
		
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		double height=screensize.getHeight();
		double width=screensize.getWidth();
		
		Playwright playwright=Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browsercontext=browser.newContext(new Browser.NewContextOptions().setViewportSize((int)width,(int)height));
		Page page=browsercontext.newPage();
		page.navigate("https://www.google.com");
		page.close();
		browser.close();
		playwright.close();
	}

}
