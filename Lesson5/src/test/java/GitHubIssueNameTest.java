import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubIssueNameTest {
    private static final String BASE_URL = "http://github.com";
    private static final String REPOSITORY = "kostiantyn-shyniakov/qaGuru4";
    private static final String ISSUE_NAME = "TestIssue";

    @Test
    public void testIssueSearch() {
        open(BASE_URL);
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(By.linkText(REPOSITORY)).click();
        $(withText("Issues")).click();
        $(withText(ISSUE_NAME)).should(Condition.exist);
    }
}
