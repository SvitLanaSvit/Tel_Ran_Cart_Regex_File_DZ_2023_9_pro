package parser;

import model.Cart;
import readerFromFile.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static main.Main.path;

public class Parser {
    private List<Cart> getParseDataFromString(String str){
        List<Cart> carts = new ArrayList<>();
        String regex = "(NUMBER:)(\\d+)(FIRSTNAME:)(\\w+)(LASTNAME:)(\\w+)(CVV:)(\\d+)(DATE:)(\\d+.\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            if(matcher.group(1).equals("NUMBER:") && matcher.group(3).equals("FIRSTNAME:") &&
            matcher.group(5).equals("LASTNAME:") && matcher.group(7).equals("CVV:") && matcher.group(9).equals("DATE:")){
                String reg = "(\\d{4})(\\d{4})(\\d{4})(\\d{4})";
                Pattern pat = Pattern.compile(reg);
                Matcher mat = pat.matcher(matcher.group(2));
                String numberOfCard = mat.replaceAll("$1 $2 $3 $4");
                carts.add(new Cart(numberOfCard, matcher.group(4), matcher.group(6), Integer.parseInt(matcher.group(8)), matcher.group(10)));
            }
        }
        return carts;
    }
    public void print(){
        Reader reader = new Reader();
        System.out.printf("%21s %19s %15s %11s %15s%n", "NUMBER OF CARD", "FIRSTNAME", "LASTNAME", "CVV", "MONTH/YEAR");
        System.out.println("---------------------------------------------------------------------------------------");
        getParseDataFromString(reader.getStringFromFile(path)).forEach(e ->
                System.out.printf("| %-25s| %-15s| %-15s| %-10d| %-10s |%n",
                        e.getNumberCart(),
                        e.getFirstname(),
                        e.getLastname(),
                        e.getCvv(),
                        e.getDate()));
        System.out.println("---------------------------------------------------------------------------------------");
    }
}