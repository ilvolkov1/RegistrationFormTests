package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement
            year = $(".react-datepicker__year-dropdown-container"),
            month = $(".react-datepicker__month-dropdown-container");

    public void setDOB(String day, String month, String year) {
        this.year.click();
        $(byText(year)).click();
        this.month.click();
        $(byText(month)).click();
        $(".react-datepicker__day--0" + day).click();
    }
}