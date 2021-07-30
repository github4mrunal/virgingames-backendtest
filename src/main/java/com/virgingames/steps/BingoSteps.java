package com.virgingames.steps;

import com.virgingames.constants.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class BingoSteps {

    @Step("Getting All Games Information")
  public ValidatableResponse getALLGames(){

        return SerenityRest.rest()
                .given().log().all()
                .contentType(ContentType.JSON)
                .accept("application/json")
                .when()
                .get(EndPoints.GETBINGOFEED_ENDPOINT)
                .then().log().all();





    }
}
