import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Lesson3 {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void selenideOnGitHubTest() {
        open("https://github.com/selenide/selenide");
        $("span[data-content='Wiki']").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        $("#wiki-pages-box").$("a[href*='SoftAssertions']").click();
        $("#wiki-wrapper").shouldHave(text("Using JUnit5 extend test class"));
    }
}
