import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.util.HashMap;
import java.util.Map;

public class apiPostRequest {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        APIRequestContext request = playwright.request().newContext();

        //Request Payload
        Map<String,Object> data = new HashMap<>();
        data.put("email", "trump@way2automation.com");
        data.put("firstName", "Donny");
        data.put("lastName", "Trip");

        APIResponse response = request.post("http://localhost:8080/api/users", RequestOptions.create().setData(data));

        System.out.println("Status code: "+response.status());
        request.dispose();
        playwright.close();
    }
}
