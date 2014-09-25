/**   
* @author wangboxuan   
* @date 2014-7-30 上午10:55:57 
* @Description: TODO
* @version V1.0   
*/
package wbx.hibernate.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;

import wbx.hibernate.HiberNateUtils;
import wbx.hibernate.User;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**   
 * @author wangboxuan   
 * @date 2014-7-30 
 * @Description:
 */
public class HibernateUtil extends TestCase{

	/**
	 * 
	 */
	public HibernateUtil() {
		super();
	}

	/**
	 * @param name
	 */
	public HibernateUtil(String name) {
		super(name);
	}

	public void testEmptyCollection() {
		Collection collection = new ArrayList();
		assertTrue(collection.isEmpty());
		}
	
	public static Test suite() {
		return new TestSuite(HibernateUtil.class);
	}
	
	public static void main(String args[]) {
		junit.textui.TestRunner.run(suite());
	}
	
	public void testData(){
		Session session = null;
		Transaction tx = null;
		User user =null;
		try {
			session = HiberNateUtils.getSession();
			tx = session.beginTransaction();
			//Transient状态
			user = new User();
			user.setuName("李四");
			user.setUid(63);
			/*
			* persistent状态
			* persistent状态的对象，当属性发生改变的时候，hibernate会自动和数据库同步
			*/
			session.save(user);
			user.setuName("王五");
			//实际上user.setName("王五")此时已经发出一条update指令了。
			//也可以显示的调用update指定
			//session.update(user);
			tx.commit();
			} catch (Exception e) {
			  e.printStackTrace();
			   tx.rollback();
			} finally {
				session.close();
			}
			
			/*
			* 从此处开始session已经在上面关闭，这时user对象状态就变为detached状态，
			* 所有user对象已经不被session管理，但数据库中确实存在与至对应的记录(王五)。
			*/
			//detached状态
			user.setuName("张三");
			try {
			session = HiberNateUtils.getSession();
			session.beginTransaction();
			/*
			* 此时session又对user对象进行管理
			* 当session发出update指定后，进行更新数据为(张三。)
			*/
			session.update(user);
			//update后user对象状态又变为persistent状态
			session.getTransaction().commit();
			/*
			* 此时session提交事务，发出update语句
			* Hibernate: update User set name=?, password=?, createTime=?,
			expireTime=? where id=?
			*/
			} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			}finally {
				session.close();
				HiberNateUtils.closeFactory();
			}
			
	}
}
