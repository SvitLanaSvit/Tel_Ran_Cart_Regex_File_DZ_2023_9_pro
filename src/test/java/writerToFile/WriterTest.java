package writerToFile;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

class WriterTest {
    private final Writer writer = new Writer();
    private final String str = "Hello world";

    @Test
    void testWriteToFile() {
        Assertions.assertTrue(writer.writeToFile(str, "test.txt"));
    }

    @Test
    void testWriteException(){
        String pathCheck = "testWriter";
        Assertions.assertThrows(RuntimeException.class, () -> writer.writeToFile(str, pathCheck), "exception writer");
    }
}