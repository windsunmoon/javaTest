/**   
* @author wangboxuan   
* @date 2014-11-24 上午09:35:46 
* @Description: TODO
* @version V1.0   
*/
package wbx.log;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**   
 * @author wangboxuan   
 * @date 2014-11-24 
 * @Description:
 */
public class MyLogger extends Logger{

	
	protected MyLogger(String name, String resourceBundleName) {
		super(name, resourceBundleName);
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) throws Exception {
		LogManager lm = LogManager.getLogManager();
		File p = new File(MyLogger.class.getResource("").toURI());

		File fle = new File(p,"logging.properties");

		lm.readConfiguration(new FileInputStream(fle));
		 Enumeration<String> a = lm.getLoggerNames();
		 
		 while (a.hasMoreElements()) {
			String string = (String) a.nextElement();
			System.out.println("&&&&&&"+string);
			
		}
		 

//		 Logger l = Logger.getLogger("tette");
		 
//		 Logger l1 = Logger.getLogger("wbxtest");

//		
		 
		 
		 EgovaLogger ll = EgovaLogger.getInstance();
		 lm.addLogger(ll);

//		 EyHandler myhandder =  new EyHandler();
//		 myhandder.setFormatter(new EgovaFormatter());
//		 ll.addHandler(myhandder);
		 Handler[] han = ll.getHandlers();
		 System.err.println(han.length);
		 for (Handler handler : han) {
				System.out.println(handler);

		}
		 
		 MLogger.debug("wbxj###", "111111");

		
		 
	
//		 ll.info("testts");
//		  
//		 ll.info("1");
//		 ll.info("2");

		  
		 
	}
}
