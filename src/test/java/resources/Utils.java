package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Utils {
    RequestSpecification req;
    public static String getJsonValue(Response response, String key){
        String res=response.asString();
        JsonPath js =new JsonPath(res);
        return js.get(key).toString();
    }

    public RequestSpecification Requestspecification() throws FileNotFoundException {
        PrintStream stream=new PrintStream(new FileOutputStream("logs.txt"));
         req=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON)
                .addQueryParam("key","qaclick123")
                 .addFilter(RequestLoggingFilter.logRequestTo(stream))
                 .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .build();
        return req;
    }
}
