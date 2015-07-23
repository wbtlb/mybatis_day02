package cn.itcast.mybatis.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.core.config.Order;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.OrdersMapperCustom;
import cn.itcast.mybatis.po.OrdersCustom;

public class OrdersMapperCustomTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory
		// mybatis配置文件 
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//@Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<Order> list = ordersMapperCustom.findOrdersUserResultMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}

}
