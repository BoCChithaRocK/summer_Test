package com.zzh.shopcarSet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int userID;
    private int productID;
    private String name;
    private int productCount;
    private int productPrice;
}