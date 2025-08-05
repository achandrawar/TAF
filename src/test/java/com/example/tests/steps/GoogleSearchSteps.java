package com.example.tests.steps;

import com.example.tests.pages.GoogleHomePage;
import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSearchSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleSearchSteps.class);

    public GoogleHomePage googleHomePage;

    @Step("User searches for '{0}' on Google")
    public void searchFor(String query) {
        LOGGER.info("Searching for: {}", query);
        googleHomePage.open();
        googleHomePage.enterSearchQuery(query);
    }
}
