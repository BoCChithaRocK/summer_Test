package com.zzh.shopcarSet.DAO.Impl;

import com.zzh.shopcarSet.DAO.UserDAO;
import com.zzh.shopcarSet.pojo.OrderContent;
import com.zzh.shopcarSet.pojo.ShopCar;
import com.zzh.shopcarSet.pojo.User;
import com.zzh.shopcarSet.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * UserDAOImpl 实现 UserDAO 接口，用于更新用户的存款
 */
/**
 * UserDAOImpl 实现 UserDAO 接口，用于更新用户的存款
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void getAccount(ShopCar shopCar, User user){
        String sql = "SELECT * FROM user WHERE UserID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ){
            ps.setInt(1, shopCar.getUserID());
            ps.execute();
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()){
                    user.setAccount(rs.getInt("account"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 更新用户存款
     *
     * @param
     */
    @Override
    public void updateAccount(User user, ShopCar shopCar,
                              OrderContent orderContent) {
        String sql = "UPDATE user SET account = ? WHERE UserID = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
        ) {
            orderContent.setProductCount(shopCar.getProductCount());
            int a = orderContent.getProductAllPrice();
            System.out.println("a="+a);
            int b = orderContent.getProductCount();
            System.out.println("b="+b);
            int totalValue = a*b; // 计算订单内容的总价值
            int newAccount = user.getAccount() - totalValue; // 计算新的账户余额
            if(newAccount<0){
                System.out.println("余额不足");
                System.exit(0);
            }else{
                ps.setInt(1, newAccount);
                ps.setInt(2, shopCar.getUserID());
                ps.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}