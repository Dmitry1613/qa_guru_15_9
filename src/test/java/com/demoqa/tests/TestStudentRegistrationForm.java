package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestStudentRegistrationForm extends TestData {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @DisplayName("Fill full form")
    @Test
    void fillFormTest() {
        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setNumber(number)
                    .setBirthDate(day, month, year)
                    .setSubjects(subject)
                    .setHobbie(hobby)
                    .pictureUpload(picture)
                    .setCurrentAddress(address)
                    .setStateAndCity(state, city)
                    .clickSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage
                    .checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", number)
                    .checkResult("Date of Birth", day + " " + month + "," + year)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", picture)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }
    @DisplayName("Fill minimum fields form")
    @Test
    void fillFormWithMinimumTest() {

        step("Open registrations form", () -> {
            registrationFormPage.openPage();
        });
        step("Fill minimum fields for form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setNumber(number)
                    .clickSubmit();
        });
        step("Check form results", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", number);
        });
    }
}
