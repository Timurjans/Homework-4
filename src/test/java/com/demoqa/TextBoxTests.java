package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {



        @BeforeAll
        static void configure() {
            Configuration.baseUrl = "https://demoqa.com/";
            Configuration.browserSize = "1920x1080";
}

        @Test
        void fillFormTests() {

            open("https://demoqa.com/automation-practice-form");
            $("#firstName").setValue("Oleg");
            $("#lastName").setValue("Pikof");
            $("#userEmail").setValue("t.khaziev@mail.ru");
            $(byText("Male")).click();
            $("#userNumber").setValue("8917777964");
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
          //  text("Oleg");
         //   text("Oleg");

sleep(5000);



      //      $("#submit").click();

          //  $("#output #name").shouldHave(text("Oleg"));
       //     $("#output").$("#name").shouldHave(text("Oleg"));
         //   $("#output").$("#name").shouldHave(text("Oleg"));
        //    $("#output").$("#name").shouldHave(text("Oleg"));
         //   $("#output #email").shouldHave(text("t.khaziev@mail.ru"));
         //   $("#output #currentAddress").shouldHave(text("ADress 5"));
          //  $("#output #permanentAddress").shouldHave(text("drygoi adress"));

           // react-datepicker__day react-datepicker__day--001

        }
}

// executeJavaScript("$('footer').remove()");
  //  executeJavaScript("$('#fixedban').remove()");