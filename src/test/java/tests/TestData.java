package tests;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    Faker faker = new Faker();

    public static String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    public static String[] subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
            "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"};

    public static String[] hobbies = {"Reading", "Sports", "Music"};

    public static String[] gender = {"Male", "Female", "Other"};

    final Map<String, String[]> stateAndCity = new HashMap<>(); {

        stateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
    }
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);

    public String getRandomCity(String state) {
        String city = null;
        if (state.equals("NCR")) {
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        }
        if (state.equals("Uttar Pradesh") ) {
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        }
        if (state.equals("Haryana") ) {
            city =  faker.options().option("Karnal", "Panipat");
        }
        if (state.equals("Rajasthan") ) {
            city = faker.options().option("Jaipur", "Jaiselmer");
        }

        return city;
    }
    public String state(String state) {
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        return state;
    }

    public String city(String city) {
        city = getRandomCity(state);
        return city;
    }
}

