package cn.itcast.mybatis.po;

import java.util.List;

/**
 * ��װ����
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

	//�û���Ҫ��ѯ����
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	//���԰�װ������ѯ��������������Ʒ
}
