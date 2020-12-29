package com.geekStudy.week7.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekStudy.week7.entity.ShoppingCustomerInfo;
import com.geekStudy.week7.mapper.ShoppingCustomerInfoMapper;
import com.geekStudy.week7.service.IShoppingCustomerInfoService;

@Service
public class ShoppingCustomerInfoServiceimpl implements IShoppingCustomerInfoService{

	@Autowired
	private ShoppingCustomerInfoMapper customerInfoMapper;
	
	@Override
	public List<ShoppingCustomerInfo> findAll() {
		return customerInfoMapper.findAll();
	}

	@Override
	public ShoppingCustomerInfo findBySerialno(String id) {
		return customerInfoMapper.findBySerialno(id);
	}

	@Override
	public int insertCustomer(ShoppingCustomerInfo customerInfo) {
		return customerInfoMapper.insertCustomer(customerInfo);
	}

	@Override
	public int updateCustomerBySerialno(ShoppingCustomerInfo customerInfo) {
		return customerInfoMapper.updateCustomerBySerialno(customerInfo);
	}

}
