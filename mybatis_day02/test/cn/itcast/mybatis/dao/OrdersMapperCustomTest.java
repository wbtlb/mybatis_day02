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
		// ����sqlSessionFactory
		// mybatis�����ļ� 
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����ػ�����
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
	
	//��ѯ���������û���Ϣ  �ӳټ���
	//@Test
	public void  findOrderUserLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		
		//��ѯ������Ϣ(����)
		List<Orders> list = ordersMapperCustom.findOrderUserLazyLoading();
		
		//�����ϱߵĶ����б�
		for(Orders orders:list)
		{
			User user = orders.getUser();
			System.out.println(user);
		}//id��ͬ ��һ������
		
	}
	
	//һ���������
	@Test
	public void testCache1() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//��һ�η������󣬲�ѯidΪ1���û�
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		//���sqlSessionȥִ��commit����(ִ�в��� ���� ɾ��)�����sqlSession�е�һ�����棬������Ŀ��Ϊ���û����д洢�����µ���Ϣ����������
		
		//�������¶���
		user1.setUsername("����");
		userMapper.updateUser(user1);
		sqlSession.commit();
		
		//�ڶ��η������󣬲�ѯidΪ1���û�
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
		
		sqlSession.close();
	}

}









