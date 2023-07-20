package com.zzh.shopcarSet.DAO;

import com.zzh.shopcarSet.pojo.OrderContent;
import com.zzh.shopcarSet.pojo.ShopCar;
import com.zzh.shopcarSet.pojo.User;


public interface UserDAO {
    void getAccount(ShopCar shopCar, User user);
    void updateAccount(User user, ShopCar shopCar,
                       OrderContent orderContent);//更新用户余额
}
