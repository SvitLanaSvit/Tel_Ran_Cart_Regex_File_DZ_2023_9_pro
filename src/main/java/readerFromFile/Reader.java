package readerFromFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Reader {
     public String getStringFromFile(String path){
         StringBuilder sb = new StringBuilder();
         try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(path))){
             int characters;
             while ((characters = reader.read()) != -1){
                 sb.append((char)characters);
             }
         } catch (FileNotFoundException e) {
             throw new RuntimeException("The file has been not found!!!");
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         return sb.toString();
     }
}