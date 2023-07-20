package com.zzh.shopcarSet.service;

import com.zzh.shopcarSet.DAO.OrderContentDAO;
import com.zzh.shopcarSet.DAO.OrderDAO;
import com.zzh.shopcarSet.DAO.ShopCarDAO;
import com.zzh.shopcarSet.DAO.UserDAO;
import com.zzh.shopcarSet.pojo.*;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Service {
    private UserDAO userDAO;
    private OrderDAO orderDAO;
    private OrderContentDAO orderContentDAO;
    private ShopCarDAO shopCarDAO;
    /**
     * 构造函数，用于初始化依赖的 DAO 对象。
     *
     * @param userDAO         用户
     * @param orderDAO        订单
     * @param orderContentDAO 订单详情
     * @param shopCarDAO      购物车
     */
    public Service(UserDAO userDAO, OrderDAO orderDAO,
                   OrderContentDAO orderContentDAO, ShopCarDAO shopCarDAO) {
        this.userDAO = userDAO;
        this.orderDAO = orderDAO;
        this.orderContentDAO = orderContentDAO;
        this.shopCarDAO = shopCarDAO;
    }
    @Test
    public void method(ShopCar shopCar) {
        try {
            User user = new User();
            Product product = new Product();
            Orders orders = new Orders();
            OrderContent orderContent = new OrderContent();
            //先获取购物车对应的用户的余额
            userDAO.getAccount(shopCar,user);
            int test = user.getAccount();
            System.out.println("account="+test);


            // 更新用户账户余额
            shopCarDAO.getPrice(orderContent,shopCar);
            userDAO.updateAccount(user,shopCar,orderContent);

            // 创建订单
            orders.setOrderCreateDate(getCurrentDate());
            orderDAO.getAddress(shopCar,orders);
            orderDAO.insert(orders,shopCar);

            // 将购物车中的商品添加到订单详情
            orderContentDAO.insert(shopCar, orderContent);

            // 清空购物车
            shopCarDAO.delete(shopCar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Before
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }
}


