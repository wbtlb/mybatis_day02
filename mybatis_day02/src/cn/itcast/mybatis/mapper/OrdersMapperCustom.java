package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

/**
 * 
 * <p>Title: OrdersMapperCustom</p>
 * <p>Description: 璁㈠崟mapper</p>
 * <p>Company: www.itcast.com</p> 
 * @author	浼犳櫤.鐕曢潚
 * @date	2015-4-23涓婂崍10:28:43
 * @version 1.0
 */
public interface OrdersMapperCustom {
	
	//
	public List<OrdersCustom> findOrdersUser()throws Exception;
	
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	//查询订单以及订单明细
	public List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;
	
}
