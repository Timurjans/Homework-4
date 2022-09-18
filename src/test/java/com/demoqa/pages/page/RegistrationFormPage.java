package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.page.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private final static String TITLE_TEXT = "Student Registration Form";
    private CalendarComponents calendarComponent = new CalendarComponents();


    //Elements
    private SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        genderInput = $("#genterWrapper"),
        numberInput = $("#userNumber");

    //ACTIONS
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstname(String value) {
        firstNameInput.setValue(value);
        return this;

    }

    //public RegistrationFormPage clearFirstname() {
    //  firstNameInput.clear();

      //  return this;


    public RegistrationFormPage setLastname(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
return this;
    }

}