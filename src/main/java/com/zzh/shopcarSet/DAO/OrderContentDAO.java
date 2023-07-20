package com.zzh.shopcarSet.DAO;
import com.zzh.shopcarSet.pojo.OrderContent;
import com.zzh.shopcarSet.pojo.ShopCar;

public interface OrderContentDAO {
    void insert (ShopCar shopCar, OrderContent orderContent);//插入数据，新增订单详情时使用
}

