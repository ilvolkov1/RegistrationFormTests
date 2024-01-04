package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class RegistrationFormTests extends TestBase {


    // Тест на заполнение формы регистрации
    @Test
    void registrationFormTesting() {
        Faker fake = new Faker();
        String nameFirst = fake.name().firstName();
        String nameLast = fake.name().lastName();
        String email = fake.internet().emailAddress();
        String gender = "Male";
        String phone = Long.toString(fake.number().numberBetween(1000000000L, 9999999999L));
        String subject1 = "Maths";
        String subject2 = "Arts";
        String hobby = "Music";
        String pictureName = "picture.png";
        String currentAddress = fake.address().fullAddress();
        String birthDateYear = fake.random().nextInt(1900, 2020).toString();
        String birthDateMonth = "October";
        String birthDateDay = "20";
        String state = "Haryana";
        String city = "Panipat";

        registrationFormPageInstance
                .openPage()
                .setUserFirstNameInput(nameFirst)
                .setUserLastNameInput(nameLast)
                .setUserEmailInput(email)
                .setUserGenderSection(gender)
                .setUserPhoneInput(phone)
                .setSubjects(subject1, subject2)
                .setHobbies(hobby)
                .setImage(pictureName)
                .setState(state)
                .setCity(city)
                .setCurrentAddressInput(currentAddress)
                .setUserBOD(birthDateDay, birthDateMonth, birthDateYear)
                .clickSubmitButton()
                .verifyTableValues("Student Name", nameFirst + " " + nameLast)
                .verifyTableValues("Student Email", email)
                .verifyTableValues("Gender", gender)
                .verifyTableValues("Mobile", phone)
                .verifyTableValues("Date of Birth", birthDateDay + " " + birthDateMonth + "," + birthDateYear)
                .verifyTableValues("Hobbies", hobby)
                .verifyTableValues("Picture", pictureName)
                .verifyTableValues("Address", currentAddress)
                .verifyTableValues("State and City", state + " " + city)
                .verifyTableValues("Subjects", subject1 + ", " + subject2);

    }
}