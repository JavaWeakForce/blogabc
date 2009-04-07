/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: erichan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import blogabc.entity.SpecialTalk;

public class SpecialTalkDAO extends BaseDAO {

	@SuppressWarnings("unchecked")
	public ArrayList<SpecialTalk> getSpecialTalks() {
		String hql = "select specialTalk from SpecialTalk specialTalk";
		session = getSession();
		Query q = session.createQuery(hql);
		ArrayList<SpecialTalk> list = (ArrayList<SpecialTalk>) q.list();
		session.close();
		return list;
	}

	public SpecialTalk find(Long id) {
		return (SpecialTalk)find(SpecialTalk.class,id);
	}
	
	public Long add(SpecialTalk specialTalk) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(SpecialTalk specialTalk) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(SpecialTalk specialTalk) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
