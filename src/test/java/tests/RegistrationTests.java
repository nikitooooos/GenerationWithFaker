package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static tests.TestData.*;
import static utils.RandomUtils.*;
public class RegistrationTests extends TestBase {

    Faker faker = new Faker();
    TestData testData = new TestData();
    @Test
    void successfulRegistrationTest() {
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = getRandomItemFromArray(gender),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = String.valueOf(faker.number().numberBetween(10, 28)),
                monthOfBirth = getRandomItemFromArray(months),
                yearOfBirth = String.valueOf(getRandomInt(1900,2100)),
                subject = getRandomItemFromArray(subjects),
                randomHobbies = getRandomItemFromArray(hobbies),
                picture = "test.jpg",
                currentAddress = faker.address().streetAddress(),
                randomState = testData.state,
                randomCity = testData.city;

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subject)
                .selectHobbies(randomHobbies)
                .upLoadPictureInput(picture)
                .setCurrentAddress(currentAddress)
                .selectStateCity(randomState, randomCity)
                .submit();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", randomHobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", randomState + " " + randomCity);
    }
}
