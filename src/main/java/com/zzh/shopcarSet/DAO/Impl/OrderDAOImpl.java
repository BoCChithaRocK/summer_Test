package com.zzh.shopcarSet.DAO.Impl;

import com.zzh.shopcarSet.DAO.OrderDAO;
import com.zzh.shopcarSet.pojo.Orders;
import com.zzh.shopcarSet.pojo.ShopCar;
import com.zzh.shopcarSet.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;;
/**
 * OrderDAOImpl 实现 OrderDAO 接口，用于生成订单
 /**
 * OrderDAOImpl 实现 OrderDAO 接口，用于生成订单
 */
public class OrderDAOImpl implements OrderDAO {

    /**
     *
     * @param shopCar 通过购物车获取用户id
     * @param orders 将获取到的地址id传入Orders
     */
    @Override
    public void getAddress(ShopCar shopCar, Orders orders){
        String sql = "SELECT * FROM address WHERE userID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1, shopCar.getUserID());
            ps.execute();
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    orders.setAddressID(rs.getInt("addressID"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 将订单插入数据库。
     *
     * @param orders 要插入的订单对象
     */
    @Override
    public void insert(Orders orders,ShopCar shopCar) {
        String sql = "INSERT INTO orders (userID,AddressID,orderCreateDate) VALUES (?,?,?) ";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1,shopCar.getUserID());
            ps.setInt(2,orders.getAddressID());
            ps.setString(3,orders.getOrderCreateDate());

            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
