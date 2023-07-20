package com.zzh.shopcarSet.DAO;

import com.zzh.shopcarSet.pojo.OrderContent;
import com.zzh.shopcarSet.pojo.ShopCar;

public interface ShopCarDAO {
    void delete(ShopCar shopCar);
    void getPrice(OrderContent orderContent, ShopCar shopCar);
}
