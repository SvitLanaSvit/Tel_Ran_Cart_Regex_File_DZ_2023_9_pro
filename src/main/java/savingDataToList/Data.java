package savingDataToList;

import lombok.Getter;
import model.Cart;
import java.util.ArrayList;
import java.util.List;
@Getter
public class Data {
    private List<Cart> list;

    public boolean addCart(Cart cart){
        boolean res = false;
        if(list == null){
            list = new ArrayList<>();
            list.add(cart);
            res = true;
        }
        else if(list.contains(cart.getFirstname()) &&
                list.contains(cart.getLastname()) &&
                list.contains(cart.getNumberCart())){
            System.out.println("The cart is already exists!!!");
        }
        else{
            list.add(cart);
            res = true;
        }
        return res;
    }
}