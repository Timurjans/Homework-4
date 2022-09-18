package com.demoqa.pages.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.demoqa.pages.page.RegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class REGISTRATIONpageobjects {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    }
    @Test
    void fillFormWithTests() {
        registrationFormPage.openPage()
                .setFirstname("Oleg")
                .setLastname("Pikof")
                .setEmail("t.khaziev@mail.ru")
                .setGender("Male")
                .setNumber("8917779962")
                .setBirthDate("21", "May", "1999")
                .setSubjects("Maths")
                .setHobbies("Reading")
                .setUploadFile("од.jpg")
                .setAdress("UFA socialist RMB")
                .setLocation("NCR", "Delhi")
                .setSubmit()

                .checkResultTableVisible()
                .checkResult("Student Name", "Pikof")
                .checkResult("Student Email", "t.khaziev@mail.ru")
                .checkResult("Gender","Male")
                .checkResult("Mobile", "8917779962")
                .checkResult("Date of Birth", "21 May,1999")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "од.jpg")
                .checkResult("Address", "UFA socialist RMB")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void fillFormWithMinimumDataTest() {
        registrationFormPage.openPage()
                .setFirstname("Oleg")
                .setLastname("Pikof")
                .setGender("Other")
                .setNumber("8917779962")
                .setSubmit()

                .checkResultTableVisible()
                .checkResult("Student Name", "Pikof")
                .checkResult("Gender","other")
                .checkResult("Mobile", "8917779962");

    }
}
