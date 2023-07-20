package com.zzh.shopcarSet.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders{
    private int OrderID;
    private int UserID;
    private String orderCreateDate;
    private int AddressID;
}