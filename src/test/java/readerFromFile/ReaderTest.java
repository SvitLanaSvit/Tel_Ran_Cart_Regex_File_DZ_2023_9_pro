package readerFromFile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReaderTest {
    //private final Reader reader = new Reader();
    @Spy
    Reader reader;

    @Test
    void testGetStringFromFile() {
        String path = "carts.txt";
        Assertions.assertTrue(reader.getStringFromFile(path).length() > 0);
    }

    @Test
    void testReadException(){
        Assertions.assertThrows(RuntimeException.class, () -> reader.getStringFromFile("testWriter"), "exception reader");
    }
}