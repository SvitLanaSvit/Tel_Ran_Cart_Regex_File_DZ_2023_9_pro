package generator;

import model.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import savingDataToList.Data;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeneratorTest {
    @Spy
    Data data;

    @Mock
    Cart cart;

    @Mock
    Generator generator;

    @Test
    void testGetDataOfListCart() {
        data.addCart(cart);
        when(generator.getDataOfListCart()).thenReturn(data);
        Assertions.assertEquals(1, generator.getDataOfListCart().getList().size());
        verify(data, Mockito.times(1)).addCart(cart);
    }
}