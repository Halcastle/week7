package com.geekStudy.week7.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.geekStudy.week7.entity.ShoppingCustomerInfo;

@Mapper
public interface ShoppingCustomerInfoMapper {

	List<ShoppingCustomerInfo> findAll();
	
	ShoppingCustomerInfo findBySerialno(String id);
}
