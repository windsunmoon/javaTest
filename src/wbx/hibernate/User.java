/**   
* @author wangboxuan   
* @date 2014-7-29 下午02:55:03 
* @Description: TODO
* @version V1.0   
*/
package wbx.hibernate;

import java.sql.Date;

/**   
 * @author wangboxuan   
 * @date 2014-7-29 
 * @Description:
 */
public class User {
	
	private int uid ;
	private String uName;
	private String telPhone;
	private Date createTime;
	private Date expireTime;
	
	
	public User() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	
}
