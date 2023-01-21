package readerFromFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Reader {
     public String getStringFromFile(String path){
         StringBuilder sb = new StringBuilder();
         try(BufferedInputStream reader = new BufferedInputStream(new FileInputStream(path))){
             int characters;
             while ((characters = reader.read()) != -1){
                 sb.append((char)characters);
             }
         }catch(IOException ex){
             ex.printStackTrace();
         }
         return sb.toString();
     }
}