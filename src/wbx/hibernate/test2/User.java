/**   
* @author wangboxuan   
* @date 2014-7-29 下午02:55:03 
* @Description: TODO
* @version V1.0   
*/
package wbx.hibernate.test2;

import java.io.Serializable;
import java.sql.Date;

/**   
 * @author wangboxuan   
 * @date 2014-7-29 
 * @Description:
 */
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 7105337274388266032L;
	private int uid ;
	private String uName;
	private String telPhone;
	private Date createTime;
	private Date expireTime;
	
	private IDcard card;
	
	
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
	public IDcard getCard() {
		return card;
	}
	public void setCard(IDcard card) {
		this.card = card;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uName=" + uName + ", telPhone=" + telPhone + ", createTime=" + createTime
				+ ", expireTime=" + expireTime + ", card=" + card + "]";
	}
	
	
}
