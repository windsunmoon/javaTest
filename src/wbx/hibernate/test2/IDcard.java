/**   
* @author wangboxuan   
* @date 2014-12-4 下午02:30:11 
* @Description: TODO
* @version V1.0   
*/
package wbx.hibernate.test2;

import java.io.Serializable;

/**   
 * @author wangboxuan   
 * @date 2014-12-4 
 * @Description:
 */
public class IDcard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4112172018716250474L;
	private int cid ;
	private String pro;
	
	
	
	
	public IDcard() {
		super();
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPro() {
		return pro;
	}
	public void setPro(String pro) {
		this.pro = pro;
	}
	@Override
	public String toString() {
		return "IDcard [cid=" + cid + ", pro=" + pro + "]";
	}
	

}
