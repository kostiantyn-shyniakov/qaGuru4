import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepTest {
    private static final String BASE_URL = "http://github.com";
    private static final String REPOSITORY = "kostiantyn-shyniakov/qaGuru4";
    private static final String ISSUE_NAME = "TestIssue";

    @Test
    public void testIssueSearch() {
        step("Open main page", () -> {
            open(BASE_URL);
        });

        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Go to repository " + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Go to Issues tab", () -> {
            $(withText("Issues")).click();
        });
        step("Check that Issue with name " + ISSUE_NAME + " exists", () -> {
            $(withText(ISSUE_NAME)).should(visible);
        });

    }
}
