/**   
* @author wangboxuan   
* @date 2014-9-25 下午02:01:51 
* @Description: TODO
* @version V1.0   
*/
package androidAutoCompleteCode;

/**   
 * @author wangboxuan   
 * @date 2014-9-25 
 * @Description:
 */
public class Test {
	
	private static final String[] layoutFiles ={"./res/g_ruler.xml","./res/report.xml"}; 
	
	public static void main(String[] args) {
		
		
		if (args!=null) {
			for (int i = 0; i < args.length; i++) {
				System.out.println("");

				System.out.println("---------"+args[i]+"----------");
				System.out.println(ViewCodeUtil.getCode(args[i]));
			}	
		}
		
		for (int i = 0; i < layoutFiles.length; i++) {
			System.out.println("");

			System.out.println("//---------"+layoutFiles[i]+"----------");
			System.out.println(ViewCodeUtil.getCode(layoutFiles[i]));
		}	
		
	}

}
