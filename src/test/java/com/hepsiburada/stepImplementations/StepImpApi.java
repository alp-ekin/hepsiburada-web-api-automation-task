package com.hepsiburada.stepImplementations;

import com.thoughtworks.gauge.Step;
import io.restassured.response.Response;

public class StepImpApi {

    public static Integer bookingId=0;

    @Step("TestId <testId> olan API testi run et")
    public void testApi(int testId) {
        Response response = AbstractAPITest.getResponse(testId);
        response.prettyPrint();
        AbstractAPITest.checkResponseInfo(response, testId);
        bookingId = response.getBody().jsonPath().get("bookingid");
    }

    @Step("TestId <testId> olan API testi run et, bookingId check")
    public void testApiWithParameter(int testId) {

        Response response = AbstractAPITest.getResponseWithDynamicPathParameter(testId, ""+bookingId);
        response.prettyPrint();
        AbstractAPITest.checkResponseInfo(response, testId);
    }
}
