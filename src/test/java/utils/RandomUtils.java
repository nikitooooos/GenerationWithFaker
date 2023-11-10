package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {

    static Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomCity(String state) {
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
}
