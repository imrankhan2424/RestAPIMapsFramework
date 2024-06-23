package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    RequestSpecification req;
    public static String getJsonValue(Response response, String key){
        String res=response.asString();
        JsonPath js =new JsonPath(res);
        return js.get(key).toString();
    }

    public RequestSpecification Requestspecification() throws IOException {
        PrintStream stream=new PrintStream(new FileOutputStream("logs.txt"));
         req=new RequestSpecBuilder()
                .setBaseUri(globalValue("baseURI"))
                .setContentType(ContentType.JSON)
                .addQueryParam("key","qaclick123")
                 .addFilter(RequestLoggingFilter.logRequestTo(stream))
                 .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .build();
        return req;
    }

    public static String globalValue(String key) throws IOException {
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream("src/test/java/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}