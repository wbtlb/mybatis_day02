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
import cn.itcast.mybatis.mapper.UserMapper;
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

	// @Test
	public void testFindOrdersUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();

		System.out.println(list);

		sqlSession.close();
	}

	// @Test
	public void testFindOrdersUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	// @Test
	public void findOrdersAndOrdersDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	// @Test
	public void UserAndItemsResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();

		System.out.println(list);

		sqlSession.close();
	}

	// 查询订单关联用户信息 延迟加载
	// @Test
	public void findOrderUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

		// 查询订单信息(单表)
		List<Orders> list = ordersMapperCustom.findOrderUserLazyLoading();

		// 遍历上边的订单列表
		for (Orders orders : list) {
			User user = orders.getUser();
			System.out.println(user);
		} // id相同 有一级缓存

	}

	// 一级缓存测试
	// @Test
	public void testCache1() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);

		// 如果sqlSession去执行commit操作(执行插入 更新
		// 删除)，清空sqlSession中的一级缓存，这样的目的为了让缓存中存储的最新的信息避免脏数据

		// 创建更新对象
		user1.setUsername("波波");
		userMapper.updateUser(user1);
		sqlSession.commit();

		// 第二次发起请求，查询id为1的用户
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);

		sqlSession.close();
	}

	// 二级缓存测试
	@Test
	public void testCache2() throws Exception {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();

		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		// 第一次发起请求，查询id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		// 这里执行关闭操作，将sqlSession中的数据写到二级缓存中
		sqlSession1.close();

		//使用sqlSession3执行commit()操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user3 = userMapper3.findUserById(1);
		user3.setUsername("俞敏洪");
		userMapper3.updateUser(user3);
		//执行提交 清空UserMapper下边的二级缓存
		sqlSession3.commit();
		sqlSession3.close();
		
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}

}
