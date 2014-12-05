/**   
* @author wangboxuan   
* @date 2014-9-17 上午11:11:56 
* @Description: TODO
* @version V1.0   
*/
package wbx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**   
 * @author wangboxuan   
 * @date 2014-9-17 
 * @Description:
 */
public class TestZhengze {

public static void main(String[] args) {
	  final Pattern p = Pattern.compile("<!--\\w*-->");;

	String str ="dssdsdd<!--aaaaadsdjksfkj-->fdkgklfklhkhk<!--aaaafkjjfj-->ddd";
	Matcher m = p.matcher(str);
	while (m.find()) {
		
		System.out.println(m.group());
	}

}
}
