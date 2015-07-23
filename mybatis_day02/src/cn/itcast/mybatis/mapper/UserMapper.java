package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public interface UserMapper {
	/**
	 * �����淶
	 * 	1.��mapper.xml��namespace����mapper�ӿڵ�ַ
	 * 	2.mapper.java�ӿ��еķ�������mapper.xml��statement��idһ��
	 * 	3.mapper.java�ӿ��еķ�������������ͺ�mapper.xml�е�statement��parameterTypeָ��������һ��
	 *  4.mapper.java�ӿ��еķ�������ֵ���ͺ�mapper.xml��statement��resultTypeָ��������һ��
	 * 
	 * 	���ϵĿ����淶�Ƕ�ģ������ͳһ����
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public User findUserById(int id) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	//�û���Ϣ�ۺϲ�ѯ
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	//ResultMap���
	public User findUserByIdResultMap(int id) throws Exception;
}









