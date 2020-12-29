package com.geekStudy.week7.aspect;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.engine.spi.SessionImplementor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.geekStudy.week7.config.DS;
import com.geekStudy.week7.config.DynamicDataSourceContextHolder;

/**
 * 切换数据源Advice
 */
@Aspect
@Order(-1)//设置AOP执行顺序(需要在事务之前，否则事务只发生在默认库中)
@Component
public class DynamicDataSourceAspect {

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    /*
     * @Before("@annotation(ds)")
     * 的意思是：
     * @Before：在方法执行之前进行执行：@annotation(targetDataSource)：
     * 会拦截注解targetDataSource的方法，否则不拦截;
     */
    @Before("@annotation(ds)")
    public void changeDataSource(JoinPoint point, DS ds) throws Throwable {
        //获取当前的指定的数据源;
        String dsId = ds.value();
        /**
         * 通过aop拦截，获取注解上面的value的值key，然后取判断我们注册的keys集合中是否有这个key,如果没有，则使用默认数据源，如果有，则设置上下文中当前数据源的key为注解的value。
         */
        if (DynamicDataSourceContextHolder.containsDataSource(dsId)) {
//            logger.debug("切入:{} >", dsId, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(dsId);
        } else {
            logger.info("数据源[{}]不存在，使用默认数据源 >{}", dsId, point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType("master");
        }
    }

    @After("@annotation(ds)")
    public void restoreDataSource(JoinPoint point, DS ds) {
        logger.info("Revert DataSource : {} > {}", ds.value(), point.getSignature());
        logger.info("切完");
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
        SessionImplementor session = entityManager.unwrap(SessionImplementor.class);
        //最关键的一句代码， 手动断开连接，不用重新设置 ，会自动重新设置连接。
        session.disconnect();
    }
}