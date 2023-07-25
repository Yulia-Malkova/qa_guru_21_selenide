package qa_guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsTest extends TestData {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void softAssertionsPageShouldContainJUnit5() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").$(byText("Soft assertions"))
        .shouldHave(attribute("href","https://github.com/selenide/selenide/wiki/SoftAssertions"));
        $(".markdown-body").$(byText("Soft assertions")).click();
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:"))
                .sibling(0).shouldHave(text(expectedCode));
    }
}
