/**   
* @author wangboxuan   
* @date 2014-9-25 下午01:53:50 
* @Description: TODO
* @version V1.0   
*/
package androidAutoCompleteCode;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

/**   
 * @author wangboxuan   
 * @date 2014-9-25 
 * @Description:
 */
public class ViewCodeUtil {
	static SAXParserFactory saxfac = SAXParserFactory.newInstance();   

	static SaxHander mySax = new SaxHander();

	
	public static String getCode(String resFileName){
		
		File f = new File(resFileName);
		if (!f.exists()) {
			return null;
		}
		
		try {
			saxfac.newSAXParser().parse(f,mySax);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		List<IdNamePair> res = mySax.getRes();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		sb.append("//---------- 开始定义域--------------\n");
		
		sb1.append("//----------开始initView方法------------------\n");
		sb1.append("public void initView() { \n");

		for (IdNamePair idNamePair : res) {
			sb.append(" private "+idNamePair.getName()+"  "+ idNamePair.getId()+idNamePair.getName()+";\n");
		    
			sb1.append("    "+idNamePair.getId()+idNamePair.getName()+" = ("+idNamePair.getName()+")findViewById(R.id."+idNamePair.getId()+");\n");
		
		}
		sb1.append("}\n");
//		System.out.println(sb.toString());
//		System.out.println(sb1.toString());
		return sb.append(sb1.toString()).toString();

	}
}
