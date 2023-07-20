package com.zzh.shopcarSet.service;

import com.zzh.shopcarSet.DAO.Impl.OrderContentDAOImpl;
import com.zzh.shopcarSet.DAO.Impl.OrderDAOImpl;
import com.zzh.shopcarSet.DAO.Impl.ShopCarDAOImpl;
import com.zzh.shopcarSet.DAO.Impl.UserDAOImpl;
import com.zzh.shopcarSet.DAO.OrderContentDAO;
import com.zzh.shopcarSet.DAO.OrderDAO;
import com.zzh.shopcarSet.DAO.ShopCarDAO;
import com.zzh.shopcarSet.DAO.UserDAO;
import com.zzh.shopcarSet.pojo.ShopCar;

import org.junit.Test;

public class ServiceTest {
    @Test
    public void testMethod() {
        UserDAO userDAO = new UserDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();
        OrderContentDAO orderContentDAO = new OrderContentDAOImpl();
        ShopCarDAO shopCarDAO = new ShopCarDAOImpl();

        Service service = new Service(userDAO, orderDAO, orderContentDAO, shopCarDAO);


        ShopCar shopCar = new ShopCar();
        shopCar.setShopCarID(2);
        shopCar.setUserID(2);
        shopCar.setProductID(2);
        shopCar.setProductCount(60);

        service.method(shopCar);
    }
}