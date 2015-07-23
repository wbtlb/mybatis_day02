package cn.itcast.mybatis.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest {

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
	public void testFindUserById() throws Exception {
		//ͨ���Ự���������Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����һ��UserMapper����,mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(1);
		
		System.out.println(user.getUsername());
		 
		
	}
	
	//@Test
	public void testFindUserByName() throws Exception {
		//ͨ���Ự���������Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����һ��UserMapper����,mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.findUserByName("����");
		
		sqlSession.close();
		
		System.out.println(list);
		 
		
	}
	
	@Test
	public void testFindUserList() throws Exception {
		//ͨ���Ự���������Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����һ��UserMapper����,mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		//userCustom.setSex("");
		userCustom.setUsername("������");
		userQueryVo.setUserCustom(userCustom);
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		
		userQueryVo.setIds(ids);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		
		
		sqlSession.close();
		
		System.out.println(list);
		 
		
	}

	//@Test
	public void testFindUserCount() throws Exception {
		//ͨ���Ự���������Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����һ��UserMapper����,mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("������");
		
		
		userQueryVo.setUserCustom(userCustom);
		
		int count = userMapper.findUserCount(userQueryVo);
		
		
		sqlSession.close();
		
		System.out.println(count);
		 
		
	}
	//@Test
	public void testFindUserByIdResultMap() throws Exception {
		//ͨ���Ự���������Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//����һ��UserMapper����,mybatis�Զ�����mapper�������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserByIdResultMap(1);
		
		System.out.println(user.getUsername());
		 
		
	}
	

}









