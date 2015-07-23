package cn.itcast.mybatis.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.OrdersMapperCustom;
import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

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
	
	//@Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//@Test
	public void findOrdersAndOrdersDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//@Test
	public void  UserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
		
		System.out.println(list);
		
		sqlSession.close();
	}
	
	//查询订单关联用户信息  延迟加载
	@Test
	public void  findOrderUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//查询订单信息(单表)
		List<Orders> list = ordersMapperCustom.findOrderUserLazyLoading();
		
		//遍历上边的订单列表
		for(Orders orders:list)
		{
			User user = orders.getUser();
			System.out.println(user);
		}//id相同 有一级缓存
		
	}

}
