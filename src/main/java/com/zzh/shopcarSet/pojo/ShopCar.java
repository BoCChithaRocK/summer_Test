package com.zzh.shopcarSet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopCar {
    private int shopCarID;
    private int userID;
    private int addressID;
    private int productID;
    private int productCount;
    private int productPrice;
}
