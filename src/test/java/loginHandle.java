package testcases;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class loginHandle {
	public static void main(String args[]) {
		
		Playwright playwright=Playwright.create();
		ArrayList<String> arguments=new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(arguments));
		BrowserContext browsercontext=browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page=browsercontext.newPage();
		page.navigate("http://gmail.com");
		page.locator("#identifierId").fill("trainer@way2automation.com");
		page.click("button:has-text('Next')");
		page.locator("[type=password]").fill("sdfsdfsdf");
		page.click("button:has-text('Next')");
		page.close();
		
	}
}
