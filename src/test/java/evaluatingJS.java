package testcases;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class evaluatingJS {
    public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("http://google.com");
		System.out.println(page.evaluate("document.location.href"));

        //Dynamic creation of element in the DOM Using JS
		page.evaluate("() => {"
				+ "const textarea = document.createElement('textarea');"
				+ "document.body.append(textarea);"
				+ "textarea.focus();"
				+"}");
		
		String text = "Hello World !!";
        
        //Keyboard methods is used to perform action based on the key press
		page.keyboard().type(text);
 
	}
    
}
