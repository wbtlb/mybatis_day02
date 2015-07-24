package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public interface UserMapper {
	/**
	 * 开发规范 1.在mapper.xml中namespace等于mapper接口地址
	 * 2.mapper.java接口中的方法名和mapper.xml中statement的id一致
	 * 3.mapper.java接口中的方法输入参数类型和mapper.xml中的statement的parameterType指定的类型一致
	 * 4.mapper.java接口中的方法返回值类型和mapper.xml中statement的resultType指定的类型一致
	 * 
	 * 以上的开发规范是对模板代码的统一生成
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	public User findUserById(int id) throws Exception;

	public void deleteUser(int id) throws Exception;

	public void insertUser(User user) throws Exception;

	public List<User> findUserByName(String name) throws Exception;

	// 用户信息综合查询
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

	public int findUserCount(UserQueryVo userQueryVo) throws Exception;

	// ResultMap输出
	public User findUserByIdResultMap(int id) throws Exception;

	// 更新用户
	public void updateUser(User user) throws Exception;
}
