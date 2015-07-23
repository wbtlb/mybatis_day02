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
		// 创建sqlSessionFactory
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	//@Test
	public void testFindUserById() throws Exception {
		//通过会话工厂创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建一个UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(1);
		
		System.out.println(user.getUsername());
		 
		
	}
	
	//@Test
	public void testFindUserByName() throws Exception {
		//通过会话工厂创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建一个UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = userMapper.findUserByName("王瑞");
		
		sqlSession.close();
		
		System.out.println(list);
		 
		
	}
	
	@Test
	public void testFindUserList() throws Exception {
		//通过会话工厂创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建一个UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		//userCustom.setSex("");
		userCustom.setUsername("张三丰");
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
		//通过会话工厂创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建一个UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张三丰");
		
		
		userQueryVo.setUserCustom(userCustom);
		
		int count = userMapper.findUserCount(userQueryVo);
		
		
		sqlSession.close();
		
		System.out.println(count);
		 
		
	}
	//@Test
	public void testFindUserByIdResultMap() throws Exception {
		//通过会话工厂创建会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//创建一个UserMapper对象,mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserByIdResultMap(1);
		
		System.out.println(user.getUsername());
		 
		
	}
	

}









