package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private final SelenideElement
            userFirstNameInput = $("#firstName"),
            userLastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderSection = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            calendarSection = $("#dateOfBirthInput"),
            subjectsContainerInput = $("#subjectsContainer input"),
            subjectsContainerAutoCompleteList = $(".subjects-auto-complete__menu"),
            hobbiesSection = $("#hobbiesWrapper"),
            imageUpdateField = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateField = $(byText("Select State")),
            cityField = $("#city"),
            submitButton = $("button#submit");

    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationFormPage setUserFirstNameInput(String value) {
        userFirstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserLastNameInput(String value) {
        userLastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmailInput(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserPhoneInput(String value) {
        userPhoneInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserGenderSection(String value) {
        userGenderSection.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserBOD(String day, String month, String year) {
        calendarSection.click();
        new CalendarComponent().setDOB(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String... value) {
        for (String subject : value) {
            subjectsContainerInput.setValue(subject);
            subjectsContainerAutoCompleteList.$(byText(subject)).click();
        }
        return this;
    }

    public RegistrationFormPage setHobbies(String... value) {
        for (String hobby : value) {
            hobbiesSection.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationFormPage setImage(String fileName) {
        imageUpdateField.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationFormPage setState(String state) {
        stateField.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity(String city) {
        cityField.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationFormPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage verifyTableValues(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
        return this;
    }


}
