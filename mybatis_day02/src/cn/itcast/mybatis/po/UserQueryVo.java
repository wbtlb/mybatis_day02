package cn.itcast.mybatis.po;

import java.util.List;

/**
 * 包装类型
 * @author lenovo
 *
 */
public class UserQueryVo {
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	//用户需要查询条件
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	//可以包装其他查询条件，订单，商品
}
