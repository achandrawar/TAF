package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends PageObject {
    @FindBy(name = "q")
    private WebElement searchBox;

    public void enterSearchQuery(String query) {
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.submit();
    }
}
