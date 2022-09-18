package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.RegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class REGISTRATIONpageobjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormWithTests() {
        registrationFormPage.openPage()
                .setFirstname("Oleg")
                .setLastname("Pikof")
                .setEmail("t.khaziev@mail.ru")
                .setGender("Other")
                .setNumber("8917779962")
                .setBirthDate("30", "May", "1999");


        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/од.jpg"));


        $("#currentAddress").setValue("UFA stolicia RMB");
        $("#state").click();
        $("#react-select-3-option-1").click();

        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();



        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(
                text("Oleg Pikof"),
                text("t.khaziev@mail.ru"),
                text("Male"),
                text("8917777964"),
                text("01 May,1999"),
                text("Maths"),
                text("Reading"),
                text("од.JPG"),
                text("UFA stolicia RMB"),
                text("Uttar Pradesh Lucknow"));


    }


    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstname("Oleg")
                .setLastname("Pikof")
                .setEmail("t.khaziev@mail.ru")
                .setGender("Other")
                .setNumber("8917779962");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();

        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/од.jpg"));


        $("#currentAddress").setValue("UFA stolicia RMB");
        $("#state").click();
        $("#react-select-3-option-1").click();

        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();


        $(".modal-body").shouldHave(
                text("Oleg Pikof"),
                text("t.khaziev@mail.ru"),
                text("Male"),
                text("8917777964"),
                text("01 May,1999"),
                text("Maths"),
                text("Reading"),
                text("од.JPG"),
                text("UFA stolicia RMB"),
                text("Uttar Pradesh Lucknow"));


    }
}
