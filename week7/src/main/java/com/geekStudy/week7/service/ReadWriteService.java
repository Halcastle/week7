package com.geekStudy.week7.service;


import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekStudy.week7.config.DS;
import com.geekStudy.week7.entity.ShoppingCustomerInfo;
import com.geekStudy.week7.service.impl.ShoppingCustomerInfoServiceimpl;

@Service
public class ReadWriteService {
    private final static Logger logger = LoggerFactory.getLogger(ReadWriteService.class);
    @Autowired
    ShoppingCustomerInfoServiceimpl shoppingCustomerInfoService;

    public ReadWriteService() throws SQLException {
    }

    @DS("master")
    public ShoppingCustomerInfo masterRead(String id){
        logger.info("使用maser数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----maser对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    @DS("slave1")
    public ShoppingCustomerInfo slave1Read(String id){
        logger.info("使用slave1数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----slave1对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    @DS("slave2")
    public ShoppingCustomerInfo slave2Read(String id){
        logger.info("使用slave2数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----slave2对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }

    @DS("slave3")
    public ShoppingCustomerInfo slave3Read(String id){
        logger.info("使用slave3数据源读取id为：{}数据",id);
        ShoppingCustomerInfo shoppingCustomerInfo = shoppingCustomerInfoService.findBySerialno(id);
        logger.info("----slave3对象读取为{}----",shoppingCustomerInfo.toString());
        return shoppingCustomerInfo;
    }


}
