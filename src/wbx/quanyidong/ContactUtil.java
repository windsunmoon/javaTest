/**   
* @author 王柏轩   
* @date 2014-2-27 下午05:22:39 
* @Description: TODO(用一句话描述该文件做什么) 
* @version V1.0   
*/
package wbx.quanyidong;

/**   
 * @author 王柏轩   
 * @date 2014-2-27 
 * @Description:
 * @version V1.0   
 */
public abstract class ContactUtil {

	public static void tel(HumanBO to){}
	public static void sendMsg(HumanBO from,HumanBO to,String msg){}
	public static void sendMail(HumanBO from,HumanBO to,String mail){}
	public static void talkTo(HumanBO from,HumanBO to,String msg){}
	
}


class HumanBO{}