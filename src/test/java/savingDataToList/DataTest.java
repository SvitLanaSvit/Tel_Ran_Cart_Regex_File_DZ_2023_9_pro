package savingDataToList;

import model.Cart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@ExtendWith(MockitoAnnotations.class)
class DataTest {

    public DataTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    Data dataWithList;

    @Spy
    Data data;

    @Mock
    Cart cart;

    @BeforeEach
    void init(){
        dataWithList.addCart(new Cart("123", "Lana", "Low", 123, "12/24"));
    }

    @Test
    void testAddCartNewList() {
        Assertions.assertTrue(data.addCart(cart));
        verify(data, Mockito.times(1)).addCart(cart);
    }

    @Test
    void testAddCartExistsCart() {
        Assertions.assertFalse(dataWithList.addCart(new Cart("123", "Lana", "Low", 123, "12/24")));
    }

    @Test
    void testAddCartExistsList() {
        Assertions.assertTrue(dataWithList.addCart(new Cart("345", "Svit", "Kohl", 777, "01/24")));
    }
}