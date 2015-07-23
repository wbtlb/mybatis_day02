package cn.itcast.mybatis.po;

/**
 * 
 * <p>Title: OrdersCustom</p>
 * <p>Description: ∂©µ•¿©’π¿‡</p>
 * <p>Company: www.itcast.com</p> 
 * @author	
 * @date	2015-4-23‰∏äÂçà10:25:47
 * @version 1.0
 */

public class OrdersCustom extends Orders{
	
	
	/*USER.username,
	  USER.sex,
	  USER.address */
	
	private String username;
	private String sex;
	private String address;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
