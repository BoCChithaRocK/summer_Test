package com.zzh.shopcarSet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderContent {
    private int orderID;
    private int productID;
    private int productCount;
    private int productAllPrice;
}
