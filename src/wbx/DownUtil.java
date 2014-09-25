/**   
* @author wangboxuan   
* @date 2014-7-7 ����04:19:26 
* @Description: TODO
* @version V1.0   
*/
package wbx;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;




/**   
 * @author wangboxuan   
 * @date 2014-7-7 
 * @Description:
 */
public class DownUtil {
	
	
	private static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
	
		downLoadBreakPoint(
				"e:/aa1.html","http://localhost:8080/a/gongshi4pc.html"
		);
		
	}
	

	/**
	 * @Description:断点下载
	 * @param
	 * @return void
	 */
	public static void downLoadBreakPoint(String bo1,String b) {
		String des = bo1;
		String sUrl = b;

		// 此任务是否下载完成
		boolean bComplete = false;
		// 本地文件大小
		long lLocalLength;
		// 远程文件大小
		long lRemoteLength = -1;
		// 本地文件写入起始位置
		long lStartPos = 0;

		// 断点续传的本地temp文件路径
		String tempLocalPath = des + ".temp11";

		// 生成File对象
		File file = new File(des);
		File tempFile = new File(tempLocalPath);

		if (file.exists()) {
			// 若已存在本地文件，则删除
			file.delete();
		} else {
			// 若不存在，则判断文件路径中各文件夹是否存在，
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			// 若不存在断点文件，则新建temp文件
			if (!tempFile.exists()) {
				try {
					tempFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// 获取已存在的断点文件的大小
		lLocalLength = tempFile.length();

		HttpURLConnection objConn = null;
		RandomAccessFile outputStream = null;
		InputStream inputStream = null;

		lRemoteLength = getRemoteSize(sUrl);
		// 取得远程文件大小
		if (lRemoteLength <= 0) {
			// 这里可以回调等。
		} else {

		}
		try {
			URL objURL = new URL(sUrl);
			objConn = (HttpURLConnection) objURL.openConnection();
			objConn.setRequestMethod("POST");
			objConn.setRequestProperty("Content-Type", "text/xml;");

			// 比较本地断点文件和远程文件大小,设置本地文件写入位置
			if (lLocalLength > lRemoteLength) {
				lStartPos = 0;
			} else if (lLocalLength < lRemoteLength) {
				lStartPos = lLocalLength;
			} else {
				bComplete = true;
			}


			if (!bComplete) {
				objConn.setRequestProperty("RANGE", "bytes=" + lStartPos + "-");
                 System.out.println( "" + "[断点下载" + sUrl + "]RANGE:"
							+ "bytes=" + lStartPos + "-" + lRemoteLength);

				// 设置连接和读取超时时间
				objConn.setConnectTimeout(5*1000);
				objConn.setReadTimeout(5*1000);

				// 设置URLConnection不允许输出
				objConn.setDoOutput(false);

				// 读取返回字节数组
				inputStream = objConn.getInputStream();

				// 设置文件写入起始点
				outputStream = new RandomAccessFile(tempLocalPath, "rw");
				outputStream.setLength(lStartPos);
				outputStream.seek(lStartPos);

				byte[] by = new byte[BUFFER_SIZE];
				int c;
				while ((c = inputStream.read(by)) != -1) {
					outputStream.write(by, 0, c);
					lLocalLength += c;

				}

				// 创建过inputstream之后,断开网络不会引起异常,所以需判断下载的文件大小判定是否下载完成
				bComplete = lRemoteLength == tempFile.length();

				System.out.println("远程文件:" + sUrl
							+ "下载至:" + tempLocalPath + ";完成" + tempFile.length() + "/" + lRemoteLength);
			}

			

		} catch (Exception ex) {
			// 读取出现异常,认为没有完成下载.
			ex.printStackTrace();
			bComplete = false;
		} finally {
			// 最后关闭连接和数据流

			if (outputStream != null) {
				try {
					outputStream.close();
					outputStream = null;
				} catch (IOException e) {
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
				}
			}
			if (objConn != null) {
				objConn.disconnect();
			}
			
			// 下载成功后，将断点文件重命名
			if (bComplete) {
				System.out.println(tempFile.renameTo(file));
				
				// 继续回调。
			}
		}

	}

	/**
	 * 获取远程文件大小.
	 * 
	 * @param url
	 *            远程文件路径
	 * @return 文件大小
	 */
	public static long getRemoteSize(String strurl) {
		HttpURLConnection objConn = null;
		// 判断远程文件是否存在
		URL url = null;
		try {
			url = new URL(strurl);

			// 打开连接
			objConn = (HttpURLConnection) url.openConnection();
			objConn.setRequestMethod("POST");
			objConn.setRequestProperty("Content-Type", "text/xml;");
			objConn.connect();
			// 取得远程文件大小
			if(objConn.getResponseCode()==HttpURLConnection.HTTP_OK)
			    return Long.parseLong(objConn.getHeaderField("Content-Length"));
			else{
				return -1;
			}
		} catch (Exception ex) {
			// 记录错误信息
			ex.printStackTrace();
			return -1;
		} finally {
			if (objConn != null) {
				objConn.disconnect();
			}
		}

	}

	/**
	 * 判断远程文件是否存在.
	 * 
	 * @param URLstr
	 *            远程文件路径
	 * @return 是否存在
	 */
	public static boolean fileIsExist(String URLstr) {
		HttpURLConnection objConn = null;
		URL url = null;
		try {
			url = new URL(URLstr);

			// 打开连接
			objConn = (HttpURLConnection) url.openConnection();
			objConn.setRequestMethod("POST");
			objConn.setRequestProperty("Content-Type", "text/xml;");
			objConn.connect();
			return objConn.getResponseCode() == HttpURLConnection.HTTP_OK;
		} catch (Exception ex) {
			// 记录错误信息
			ex.printStackTrace();
			return false;
		} finally {
			if (objConn != null) {
				objConn.disconnect();
			}
		}
	}

}
