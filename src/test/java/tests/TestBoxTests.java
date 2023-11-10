package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class TestBoxTests extends TestBase{

    Faker faker = new Faker();
    @Test
    void TextBox() {
        String userName = faker.name().firstName(),
                userEmail = faker.internet().emailAddress(),
                currentAddress = faker.address().streetAddress(),
                permanentAddress = faker.address().streetAddress();

        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage.checkResultTextBox("Name:", userName)
                .checkResultTextBox("Email:", userEmail)
                .checkResultTextBox("Current Address :", currentAddress)
                .checkResultTextBox("Permananet Address :", permanentAddress);
    }
}