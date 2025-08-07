package com.example.tests.tests;

import com.example.tests.steps.GoogleSearchSteps;
import com.example.tests.utils.JsonDataReader;

import net.serenitybdd.annotations.Steps;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.assertj.core.api.Assertions;
import java.util.Map;
import java.util.List;
import java.util.stream.Stream;

@ExtendWith(net.serenitybdd.junit5.SerenityJUnit5Extension.class)
public class GoogleSearchTest {
    @Steps
    GoogleSearchSteps googleSearchSteps;

    public static Stream<Map<String, Object>> searchDataProvider() {
        List<Map<String, Object>> testDataList = JsonDataReader.readJsonList("searchData.json");
        return testDataList.stream();
    }

    @ParameterizedTest(name = ParameterizedTest.ARGUMENTS_WITH_NAMES_PLACEHOLDER)
    @MethodSource("searchDataProvider")
    @Tag("smoke")
    void searchingAndVerifyingGoogle(Map<String, Object> testData) {
        String query = (String) testData.get("searchQuery");
        String expectedTitle = (String) testData.get("expectedTitle");
        googleSearchSteps.searchFor(query);
        Assertions.assertThat(googleSearchSteps.googleHomePage.getTitle())
            .containsIgnoringCase(expectedTitle);
    }
}