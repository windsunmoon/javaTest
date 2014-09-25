/**   
* @author wangboxuan   
* @date 2014-7-30 上午10:41:48 
* @Description: TODO
* @version V1.0   
*/
package wbx.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**   
 * @author wangboxuan   
 * @date 2014-7-30 
 * @Description:
 */
public class HiberNateUtils {
	
	private static SessionFactory factory = openFactory();
	
	
	
	public synchronized static  SessionFactory openFactory(){
		return new Configuration().configure().buildSessionFactory();
	}
	

	public static Session getSession(){
		if(factory==null){
			factory = openFactory();
		}
		return factory.openSession();
	}
	
	public static void closeFactory(){
		if (factory!=null) {
			factory.close();
			factory = null;
		}
	}
}
