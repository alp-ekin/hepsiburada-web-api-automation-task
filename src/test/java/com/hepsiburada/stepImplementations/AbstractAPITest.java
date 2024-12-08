package com.hepsiburada.stepImplementations;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class AbstractAPITest {

        public static RequestSpecification reqSpec;
        public static JsonPath jsonPath;
        public static int testId;

        @BeforeScenario
        public static void init() {

            baseURI = "https://restful-booker.herokuapp.com/booking/";

            try {
                jsonPath = JsonPath.from(new FileReader(System.getProperty("user.dir") + "/src/test/resources/APIRequestAndResponseData.json"));

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }


        @AfterScenario
        public static void close() {

            //Reset the info we set above, method comes from Rest-Assured
            reset();
        }


        public static Response getResponse(int testId) {

            String path = jsonPath.getString("find{it.testId == " + testId + "}.path");
            return getResponseWithDynamicPathParameter(testId, path);
        }


    public static Response getResponseWithDynamicPathParameter(int testId, String path) {

        String method = jsonPath.getString("find{it.testId == " + testId + "}.method");
        Map<String, String> mapBody = jsonPath.getMap("find{it.testId == " + testId + "}.request.body");
        System.out.println("mapBody = " + mapBody);

        switch (method) {
            case "post":
                return given().spec(getRequestSpec(testId)).post(path);
            case "get":
                return given().spec(getRequestSpec(testId)).get(path);
            case "put":
                return given().spec(getRequestSpec(testId)).put(path);
            case "patch":
                return given().spec(getRequestSpec(testId)).patch(path);
            case "delete":
                return given().spec(getRequestSpec(testId)).delete(path);

        }

        return null;
    }

    /**
         * Bu method her test için requestleri specific hale getiriyor.
         *
         * @param testId
         * @return
         */
        public static RequestSpecification getRequestSpec(int testId) {
            reqSpec = new RequestSpecBuilder()
                    .addHeaders(getHeaderFromJSON(testId))
                    .build();
            if (getRequestBodyFromJSON(testId) != null) {
                reqSpec.body(getRequestBodyFromJSON(testId));
                System.out.println("getRequestBodyFromJSON(testId) = " + getRequestBodyFromJSON(testId));
            }
            return reqSpec;
        }

        /**
         * Bu method resources/resourcesOfAPI altında bulunan JSON dosyasındaki ilgili testId'ye sahip dizi elemanının
         * request.header altındaki json objectini map formatında döndürmektedir.
         *
         * @param testId
         * @return
         */
        public static Map<String, String> getHeaderFromJSON(int testId) {
            Map<String, String> headerMap = jsonPath.getMap("find{it.testId == " + testId + "}.request.header");
            return headerMap;
        }

        /**
         * Bu method resources/resourcesOfAPI altında bulunan JSON dosyasındaki ilgili testId'ye sahip dizi elemanının
         * request.body altındaki json objectini map formatında döndürmektedir.
         *
         * @param testId
         * @return
         */
        public static Map<Object, Object> getRequestBodyFromJSON(int testId) {
            Map<Object, Object> requestBodyMap = jsonPath.getMap("find{it.testId == " + testId + "}.request.body");
            return requestBodyMap;
        }

        /**
         * Bu method geliştirilebilir. Json dosyasına response body bilgileri ayrıntılı konulabilir
         * Bu konu ileriki bir aşamada geliştirilecek.
         *
         * @param response
         * @param testId
         */
        public static void checkResponseInfo(Response response, int testId) {
            Assert.assertEquals(response.statusCode(), jsonPath.getInt("find{it.testId == " + testId + "}.response.statusCode"));
            Assert.assertEquals(response.contentType(), jsonPath.getString("find{it.testId == " + testId + "}.response.contentType"));
        }

    }

