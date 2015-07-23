package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

/**
 * 
 * @author lenovo
 *
 */
public class MybatisFirst {
	// 根据id查询用户信息得到一条记录的结果

	// @Test
	public void findUserByIdTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 通过SqlSession操作数据库
		// 第一个参数:映射文件中statement的id，等于namespace+"."+statement的id
		// 第二个参数:指定和映射文件中的parameterType类型的参数
		// sqlSession.selectOne结果是与映射文件中所匹配的resultType类型的对象
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user.getUsername());
		// 释放资源
		sqlSession.close();
	}

	// 根据用户名称模糊查询用户列表
	// @Test
	public void findUserByNameTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
		System.out.println(list);
		sqlSession.close();
	}

	// @Test
	public void InsertUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setUsername("王瑞");
		user.setBirthday(new Date());
		user.setAddress("山西太原");
		user.setSex("男");

		sqlSession.insert("test.insertUser", user);

		sqlSession.commit();
		// 获取用户信息主键 主键返回
		System.out.println(user.getId());
		// 关闭
		sqlSession.close();
	}

	//@Test
	public void DeleteUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("test.deleteUser",30);

		sqlSession.commit();
		// 关闭
		sqlSession.close();
	}
	
	@Test
	public void UpdateUserTest() throws IOException {
		// mybatis配置文件
		String resource = "SqlMapConfig.xml";
		// 得到配置文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建回话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(1);
		user.setUsername("王瑞");
		user.setBirthday(new Date());
		user.setAddress("山西太原");
		user.setSex("男");

		sqlSession.update("test.updateUser", user);

		sqlSession.commit();
		// 获取用户信息主键 主键返回
		System.out.println(user.getId());
		// 关闭
		sqlSession.close();
	}

}
