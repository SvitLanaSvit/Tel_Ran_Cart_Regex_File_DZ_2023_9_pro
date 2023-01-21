package savingListToString;

import model.Cart;
import savingDataToList.Data;

public class DataToString {
    public String getStringFromList(Data data){
        StringBuilder sb = new StringBuilder();
        if(!data.getList().isEmpty()){
            for (Cart cart : data.getList()) {
                sb.append("NUMBER:").append(cart.getNumberCart())
                        .append("FIRSTNAME:").append(cart.getFirstname())
                        .append("LASTNAME:").append(cart.getLastname())
                        .append("CVV:").append(cart.getCvv())
                        .append("DATE:").append(cart.getDate());
            }
        }
        else{
            System.out.println("The list of carts is empty!!!");
        }
        return sb.toString();
    }
}