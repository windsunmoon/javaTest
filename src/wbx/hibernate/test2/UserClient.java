/**   
* @author wangboxuan   
* @date 2014-7-29 下午03:51:09 
* @Description: TODO
* @version V1.0   
*/
package wbx.hibernate.test2;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import wbx.hibernate.HiberNateUtils;

/**   
 * @author wangboxuan   
 * @date 2014-7-29 
 * @Description:
 */
public class UserClient {
	public static void main(String[] args) {
		addUser();
		getUser();
//		updateUser();
		delUser();
		HiberNateUtils.closeFactory();

	}
	
	public static void addUser(){
		Session session =null;
		Transaction tr = null;
		try {
			session = HiberNateUtils.getSession();
			System.out.println("----------增-------");

			IDcard card = new IDcard();
			
			card.setCid(1006);
			card.setPro("河南省");
			
			User a = new User();
			a.setuName("wbx");
			a.setUid(1006);
			a.setTelPhone("139397475");
			a.setCreateTime(new Date(System.currentTimeMillis()));

			a.setCard(card);
			
			
			tr =	session.beginTransaction();
//			session.save(card);

			session.save(a);

//			session.save(card);

			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tr!=null) {
				tr.rollback();
			}
		}finally{
			
		}
	}
	/*
	 * Hibernate加载数据：
两种：get()、load()
1、Session.get(Class arg0, Serializable arg1)方法
* arg0:需要加载对象的类，例如：User.class
* arg1:查询条件(实现了序列化接口的对象)：
例"4028818a245fdd0301245fdd06380001"字符串已经实现了序列化接口。
返回值： 此方法返回类型为Object，也就是对象，然后我们再强行转换为需要加载的对象就可以了。
如果数据不存在，则返回null;
注：执行此方法时立即发出查询SQL语句。加载User对象

2、Object Session.load(Class arg0, Serializable arg1) throws HibernateException
* arg0:需要加载对象的类，例如：User.class
* arg1:查询条件(实现了序列化接口的对象)：例"4028818a245fdd0301245fdd06380001"字符串已经实现
了序列化接口。
* 此方法返回类型为Object，但返回的是代理对象。
* 执行此方法时不会立即发出查询SQL语句。只有在使用对象时，它才发出查询SQL语句，加载对象。
* 因为load方法实现了lazy(称为延迟加载、赖加载)
* 延迟加载：只有真正使用这个对象的时候，才加载(才发出SQL语句)
* hibernate延迟加载实现原理是代理方式。
* 采用load() 方法加载数据， 如果数据库中没有相应的记录， 则会抛出异常对象不找到
(org.hibernate.ObjectNotFoundException)

Hibernate两种加载数据方式的区别：
get()方法默认不支持lazy(延迟加载)功能，而load支持延迟加载
get()方法在查询不到数据时，返回null,而load因为支持延迟加载，只有在使用对象时才加载，所以如果数据
库中不在数据load会抛出异常(org.hibernate.ObjectNotFoundException)。
get()和load()只根据主键查询，不能根据其它字段查询，如果想根据非主键查询，可以使用HQL
	 */
	public static void getUser() {
		System.out.println("----------查-------");
		Session session =null;
		Transaction tr = null;
		try {
			session = HiberNateUtils.getSession();
			tr =	session.beginTransaction();

//		    User u =  	(User) session.get(User.class, 1006);
		    User b =  	(User) session.load(User.class, 1006);

			System.out.println(b);
//			System.out.println(u);
			tr.commit();


//			System.out.println(u.getuName());
		} catch (Exception e) {
			e.printStackTrace();
			if (tr!=null) {
				tr.rollback();
			}
		}finally{
			
		}
	}
	/*
	 * hibernate更新数据：
           建立使用hibernate进行更新数据时，先加载数据，然后再修改后更新。
         否则一些字段可以会被null替换。
	 */
	public static void updateUser() {
		System.out.println("----------改-------");
		Session session =null;
		Transaction tr = null;
		try {
			session = HiberNateUtils.getSession();
			tr =	session.beginTransaction();

		    User u =  	(User) session.get(User.class, 1006);
            
		    u.setTelPhone("12asdfsfgg"); 
		     
			tr.commit();
			System.out.println(u.getuName());
		} catch (Exception e) {
			if (tr!=null) {
				tr.rollback();
			}
		}finally{
			
			
		}
	}
	/*
	 * 删除对象，一般先加载上来对象，然后再删除该对象。
对象删除后，对象状态为Transistent状态。
	 */
	public static void delUser() {
		System.out.println("----------删-------");

		Session session =null;
		Transaction tr = null;
		try {
			session = HiberNateUtils.getSession();
			tr =	session.beginTransaction();

		    User u =  	new User();
		    IDcard card = new IDcard();
		    card.setCid(1006);
		    u.setUid(1006);
		    
		    u.setCard(card);
            
		    session.delete(u); 
			tr.commit();
			System.out.println(u.getuName());
		} catch (Exception e) {
			if (tr!=null) {
				tr.rollback();
			}
		}finally{
			
			
		}
	}

}
