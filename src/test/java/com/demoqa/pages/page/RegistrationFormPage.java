package com.demoqa.pages.page;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.page.components.CalendarComponents;
import com.demoqa.pages.page.components.ResultTableComponents;
import com.demoqa.pages.page.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponents calendarComponent = new CalendarComponents();
    private ResultTableComponents resultTableComponents = new ResultTableComponents();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    //Elements
    private SelenideElement
        firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        genderInput = $("#genterWrapper"),
        numberInput = $("#userNumber"),
        subjectsinput = $("#subjectsInput"),
        hobbiesInput = $("#hobbiesWrapper"),
        uploadFileInput = $("#uploadPicture"),
        adressInput =$("#currentAddress"),
        sumbitInput = $("#submit");

    private final static String TITLE_TEXT = "Student Registration Form";

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

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }
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
    public RegistrationFormPage setSubjects(String value) {
        subjectsinput.setValue(value).pressEnter();;
        return this;
    }
    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setUploadFile(String value) {
        uploadFileInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setAdress(String value) {
        adressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setLocation(String state, String city) {
        stateAndCityComponent.setLocation(state, city);
        return this;
    }

    public RegistrationFormPage checkResultTableVisible() {
        resultTableComponents.checkVisible();
        return this;
    }
    public RegistrationFormPage setSubmit() {
         sumbitInput.click();
         return this;
        }
    public RegistrationFormPage checkResult(String key, String value){
        resultTableComponents.chechResult(key, value);
        return this;
    }

}