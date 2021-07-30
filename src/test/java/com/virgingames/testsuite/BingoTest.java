package com.virgingames.testsuite;

import com.virgingames.steps.BingoSteps;
import com.virgingames.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class BingoTest extends TestBase {

    @Steps
    BingoSteps bingoSteps;

    @Title("This will get all Bingo Games")
    @Test
    public void getAllLiveGameAndAssertDefaultGameFrequency() {
        ValidatableResponse response =
                bingoSteps.getALLGames().statusCode(200);
        int gameFreq = response.extract()
                .jsonPath().getInt("bingoLobbyInfoResource.streams[1].defaultGameFrequency");
        assertThat(gameFreq).isEqualTo(300000);

        System.out.println("Game Frequency is: " + gameFreq);

    }

    @Test
    public void getAllLiveBingoFeedAndAssertStartTime() {
        ValidatableResponse response =

                bingoSteps.getALLGames().statusCode(200);

        long startTime = response.extract().jsonPath().getLong("bingoLobbyInfoResource.streams[6].startTime");
        assertThat(startTime).isGreaterThanOrEqualTo(1627415700000L);

        System.out.println("Start time is :  " + startTime);


    }
}
