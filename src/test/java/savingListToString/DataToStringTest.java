package savingListToString;

import model.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import savingDataToList.Data;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DataToStringTest {
    @Spy
    DataToString dataToString;
    @Spy
    Data data;
    @Spy
    Data dataEmpty;
    @Mock
    Cart cart;

    @BeforeEach
    void init(){
        data.addCart(cart);
    }

    @Test
    void testGetStringFromList() {
        try {
            Assertions.assertTrue(dataToString.getStringFromList(data).length() > 0);
            verify(dataToString, Mockito.times(1)).getStringFromList(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testListEmptyException(){
        Assertions.assertThrows(Exception.class, () -> dataToString.getStringFromList(dataEmpty),
                "exception empty list of data");
    }
}