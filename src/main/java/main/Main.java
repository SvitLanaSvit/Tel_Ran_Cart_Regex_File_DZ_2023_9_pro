package main;

import generator.Generator;
import parser.Parser;
import savingListToString.DataToString;
import writerToFile.Writer;

public class Main {
    static public String path = "carts.txt";

    public static void main(String[] args) {
        Generator g = new Generator(25);
        DataToString dts = new DataToString();
        Writer writer = new Writer();
        Parser parserFromFile = new Parser();

        try {
            System.out.println(writer.writeToFile(dts.getStringFromList(g.getDataOfListCart()), path));
            parserFromFile.print();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}