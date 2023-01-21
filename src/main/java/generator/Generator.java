package generator;

import com.github.javafaker.Faker;
import model.Cart;
import savingDataToList.Data;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Generator {
    int countOfGeneration;
    public Generator(int countOfGeneration){
        this.countOfGeneration = countOfGeneration;
    }

    public Data getDataOfListCart(){
        Data data = new Data();
        for (int i = 0; i < countOfGeneration; i++) {
            data.addCart(getCart());
        }
        return data;
    }

    private Cart getCart(){
        return new Cart(generateNumberOfCart(), generateFirstname(), generateLastname(), generateCVV(), generateDate());
    }
    private String generateNumberOfCart(){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(String.format("%04d", rnd.nextInt(1,10000)));
        }
        return sb.toString();
    }
    private String generateFirstname(){
        Faker faker = new Faker();
        return faker.name().firstName();
    }
    private String generateLastname(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }
    private int generateCVV(){
        Random rnd = new Random();
        return rnd.nextInt(100,1000);
    }
    private String generateDate(){
        Faker faker = new Faker();
        Date date = faker.date().between(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(LocalDate.now().plusYears(5).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR) % 100;

        int month = calendar.get(Calendar.MONTH);
        return String.format("%02d/%02d", month + 1, year);
    }
}