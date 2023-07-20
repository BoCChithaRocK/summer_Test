package com.zzh.shopcarSet.DAO;
import com.zzh.shopcarSet.pojo.Orders;
import com.zzh.shopcarSet.pojo.ShopCar;

public interface OrderDAO {
    void getAddress(ShopCar shopCar, Orders orders);
    void insert(Orders order, ShopCar shopCar);//插入数据，新增订单时使用
}
