/**   
* @author 王柏轩   
* @date 2013-11-25 下午04:49:54 
* @Description: TODO(用一句话描述该文件做什么) 
* @version V1.0   
*/
package wbx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**   
 * @author 王柏轩   
 * @date 2013-11-25 
 * @Description:
 * @version V1.0   
 */
public class TestStringBuilder {
     public  static void build() throws IOException{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\testdbsql.sql"), "UTF-8"));
			String strLine;
			StringBuilder sb = new StringBuilder();
			while ((strLine = reader.readLine()) != null) {
				// 如果不是以#开头的注释,则视为SQL语句,添加至SQL内容.
				if ((!strLine.contains("--"))&&(!strLine.startsWith("#"))) {
					sb.append(strLine);
				}
			}
			System.out.println(sb);
     }
}
