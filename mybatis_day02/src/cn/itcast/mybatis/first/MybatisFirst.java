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
	// ����id��ѯ�û���Ϣ�õ�һ����¼�Ľ��

	// @Test
	public void findUserByIdTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����ػ�����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// ͨ��SqlSession�������ݿ�
		// ��һ������:ӳ���ļ���statement��id������namespace+"."+statement��id
		// �ڶ�������:ָ����ӳ���ļ��е�parameterType���͵Ĳ���
		// sqlSession.selectOne�������ӳ���ļ�����ƥ���resultType���͵Ķ���
		User user = sqlSession.selectOne("test.findUserById", 1);
		System.out.println(user.getUsername());
		// �ͷ���Դ
		sqlSession.close();
	}

	// �����û�����ģ����ѯ�û��б�
	// @Test
	public void findUserByNameTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����ػ�����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		List<User> list = sqlSession.selectList("test.findUserByName", "С��");
		System.out.println(list);
		sqlSession.close();
	}

	// @Test
	public void InsertUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����ػ�����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setAddress("ɽ��̫ԭ");
		user.setSex("��");

		sqlSession.insert("test.insertUser", user);

		sqlSession.commit();
		// ��ȡ�û���Ϣ���� ��������
		System.out.println(user.getId());
		// �ر�
		sqlSession.close();
	}

	//@Test
	public void DeleteUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����ػ�����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.delete("test.deleteUser",30);

		sqlSession.commit();
		// �ر�
		sqlSession.close();
	}
	
	@Test
	public void UpdateUserTest() throws IOException {
		// mybatis�����ļ�
		String resource = "SqlMapConfig.xml";
		// �õ������ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// �����ػ�����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// ͨ�������õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();

		User user = new User();
		user.setId(1);
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setAddress("ɽ��̫ԭ");
		user.setSex("��");

		sqlSession.update("test.updateUser", user);

		sqlSession.commit();
		// ��ȡ�û���Ϣ���� ��������
		System.out.println(user.getId());
		// �ر�
		sqlSession.close();
	}

}
