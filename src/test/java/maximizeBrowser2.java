package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class maximizeBrowser2 {
	
	public static void main(String args[]) {
		
		Playwright playwright=Playwright.create();
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
		BrowserContext browsercontext=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=browsercontext.newPage();
		page.navigate("https://www.google.com");
		page.close();
		browser.close();
		playwright.close();
		
	}

}
