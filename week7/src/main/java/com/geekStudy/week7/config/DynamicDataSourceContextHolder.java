package com.geekStudy.week7.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataSourceContextHolder {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    /**
     * TreadLocal数据隔离，但并非数据的复制，而是在每一个线程中创建一个新的数据对象，然后每一个线程使用的是不一样的
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<String>();

    /**
     * 管理所有的数据源id
     * 主要是为了判断数据源是否存在
     */
    public static List<String> dataSourceIds = new ArrayList<String>();

    //设置数据源
    public static void setDataSourceType(String dataSourceType){
        logger.info("切换至{}数据源",dataSourceType);
        CONTEXT_HOLDER.set(dataSourceType);
    }

    //获取数据源
    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    //清除数据源
    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }

    public static void savaDataSourceTypeName(String name){
        dataSourceIds.add(name);
    }

    /**
     * 判断指定DataSource当前是否存在
     */
    public static boolean containsDataSource(String dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
