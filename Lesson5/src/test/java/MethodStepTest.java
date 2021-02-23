import org.junit.jupiter.api.Test;

public class MethodStepTest {
    final Steps steps = new Steps();

    private static final String REPOSITORY = "kostiantyn-shyniakov/qaGuru4";
    private static final String ISSUE_NAME = "TestIssue";

    @Test
    public void testIssueSearch() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepositoryFromSearch(REPOSITORY);
        steps.openRepositoryIssues();

        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }

}
