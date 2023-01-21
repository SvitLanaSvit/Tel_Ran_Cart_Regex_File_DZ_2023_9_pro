package writerToFile;

import java.io.*;

public class Writer {
    public boolean writeToFile(String str, String path){
        boolean res = false;
        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(path))){
            byte[] array = str.getBytes();
            writer.write(array);
            res = true;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return res;
    }
}