package writerToFile;

import java.io.*;

public class Writer {
    public boolean writeToFile(String str, String path){
        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(path))){
            byte[] array = str.getBytes();
            writer.write(array);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file has been not found!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}