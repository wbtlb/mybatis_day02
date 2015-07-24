package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;
import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 订单mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-4-23上午10:28:43
 * @version 1.0
 */
public interface OrdersMapperCustom {
	
	//��ѯ����������ѯ�û���Ϣ
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	//��ѯ����������ѯ�û�ʹ��resultMap
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	//��ѯ�����Լ�������ϸ
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
	
	//��ѯ�û��������Ʒ��Ϣ
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	//��ѯ����������ѯ�û����û���Ϣ���ӳټ���
	public List<Orders> findOrderUserLazyLoading() throws Exception;
	
	
}
