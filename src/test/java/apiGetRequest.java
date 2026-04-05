import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class apiGetRequest {

    public static void main(String args[]){
        Playwright playwright = Playwright.create();

        //Created a new context for the request
        APIRequestContext request = playwright.request().newContext();

        //Stored the request's response
        APIResponse response = request.get("http://localhost:8080/api/users/1");

        //Verified response status and response body
        System.out.println("Status code : "+response.status());
        String responseBody = response.text();
        System.out.println("Response Body : "+responseBody);

        //Transformed response body to json object format
        JsonObject jsonResposne = JsonParser.parseString(responseBody).getAsJsonObject();
        String firstName = jsonResposne.get("firstName").getAsString();
        System.out.println(firstName);

        //Closed the request
        request.dispose();
        playwright.close();
    }
}
