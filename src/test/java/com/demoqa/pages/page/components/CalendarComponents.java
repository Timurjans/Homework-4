package com.demoqa.pages.page;

import static com.codeborne.selenide.Selenide.*;

public class CalendarComponents {

    public CalendarComponents setDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        return this;
    }


}