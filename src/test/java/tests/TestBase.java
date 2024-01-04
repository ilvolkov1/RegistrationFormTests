package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationFormPage;

public class TestBase {
    RegistrationFormPage registrationFormPageInstance = new RegistrationFormPage();

    // Настройка Selenide и WebDriver перед запуском тестов
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.timeout = 7000;
    }

}
