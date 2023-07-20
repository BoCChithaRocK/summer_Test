package com.zzh.shopcarSet.DAO.Impl;

import com.zzh.shopcarSet.DAO.ShopCarDAO;
import com.zzh.shopcarSet.pojo.OrderContent;
import com.zzh.shopcarSet.pojo.ShopCar;
import com.zzh.shopcarSet.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ShopCarDAOImpl 实现 ShopCarDAO 接口，用于删除购物车商品。
 */
public class ShopCarDAOImpl implements ShopCarDAO {
    /**
     * 从数据库中删除购物车项
     *
     * @param shopCar 要呗删除的购物车项
     */
    @Override
    public void delete(ShopCar shopCar) {
        String sql = "DELETE FROM shopcar WHERE userID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,shopCar.getUserID());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void getPrice(OrderContent orderContent, ShopCar shopCar) {
        String sql = "SELECT * FROM product WHERE productID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1, shopCar.getProductID());
            ps.execute();
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    orderContent.setProductAllPrice(rs.getInt("productPrice"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

