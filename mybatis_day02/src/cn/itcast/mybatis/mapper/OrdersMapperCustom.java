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
	
	//
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
}
