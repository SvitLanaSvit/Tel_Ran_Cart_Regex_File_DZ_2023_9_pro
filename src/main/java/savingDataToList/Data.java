package savingDataToList;

import lombok.Getter;
import model.Cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Getter
public class Data {
    private List<Cart> list;

    public boolean addCart(Cart cart){
        boolean res = false;
        List<Cart> existCart = null;
        if(list != null)
        {
            existCart = list.stream().filter(el -> el.getNumberCart().equals(cart.getNumberCart())).toList();
        }
        if(list == null){
            list = new ArrayList<>();
            list.add(cart);
            res = true;
        }
        else if(!existCart.isEmpty()){
            System.out.println("The cart is already exists!!!");
        }
        else{
            list.add(cart);
            res = true;
        }
        return res;
    }
}