import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Steps {
    private static final String BASE_URL = "http://github.com";

    @Step("Open main page")
    public void openMainPage() {
        open(BASE_URL);
    }

    @Step("Search repository {repository}")
    public void searchForRepository(final String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Got to repository {repository}")
    public void goToRepositoryFromSearch(final String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Go to Issues tab")
    public void openRepositoryIssues() {
        $(withText("Issues")).click();
    }

    @Step("Check that Issue with name {name} exists")
    public void shouldSeeIssueWithName(final String name) {
        $(withText(name)).should(Condition.exist);
    }
}
