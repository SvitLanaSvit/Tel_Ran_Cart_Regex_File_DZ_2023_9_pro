package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
public class Cart {
    private String numberCart;
    private String firstname;
    private String lastname;
    private int cvv;
    private String date;
}