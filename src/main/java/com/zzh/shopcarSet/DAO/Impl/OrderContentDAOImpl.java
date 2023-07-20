package com.zzh.shopcarSet.DAO.Impl;

import com.zzh.shopcarSet.DAO.OrderContentDAO;
import com.zzh.shopcarSet.pojo.OrderContent;
import com.zzh.shopcarSet.pojo.ShopCar;
import com.zzh.shopcarSet.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class OrderContentDAOImpl implements OrderContentDAO {
    /**
     * 将订单详情插入数据库。
     *
     * @param shopCar,product 从购物车和商品单中获取数据
     */
    @Override
    public void insert(ShopCar shopCar, OrderContent orderContent) {
        String sql = "INSERT INTO ordercontent (orderID,productID,productCount,productAllPrice) VALUES (?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,shopCar.getShopCarID());
            ps.setInt(2,shopCar.getProductID());
            ps.setInt(3,shopCar.getProductCount());
            ps.setInt(4,orderContent.getProductAllPrice());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
