package com.geekStudy.week7.service;

import java.util.List;

import com.geekStudy.week7.entity.ShoppingCustomerInfo;

public interface IShoppingCustomerInfoService {

	List<ShoppingCustomerInfo> findAll();
	
	ShoppingCustomerInfo findBySerialno(String id);

	int insertCustomer(ShoppingCustomerInfo customerInfo);

	int updateCustomerBySerialno(ShoppingCustomerInfo customerInfo);
}
