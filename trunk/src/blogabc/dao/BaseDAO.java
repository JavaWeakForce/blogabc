/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dao;

import org.hibernate.Session;

import blogabc.tool.HibernateUtil;

public class BaseDAO {
	protected Session session;

	protected Session getSession() {
		session = HibernateUtil.getSession();
		return session;
	}
}
