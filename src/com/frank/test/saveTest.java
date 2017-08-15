package com.frank.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.frank.bean.Item;
import com.frank.bean.User;
import com.frank.service.ItemService;
import com.frank.sessionfcty.HibernateSessionFactory;

public class saveTest {
	public static void main(String[] args) {
		
		
		
		
		
		String username="frank";
		String pwd="112233";
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where username='" + username + "' and password='" + pwd+"'";
		Query query = session.createQuery(hql);
		List<User> list=query.list();
		User user  = list.get(0);
		System.out.println(user.getAge());
		// BeanFactory factory=new
		// ClassPathXmlApplicationContext("/WebContent/WEB-INF/ApplicationContext.xml");
//		BeanFactory factory = new FileSystemXmlApplicationContext("/ApplicationContext.xml");
//		ItemService itemService = (ItemService) factory.getBean("itemService");
//		Session session = HibernateSessionFactory.getSession();
//		Object ob = session.load(com.frank.bean.User.class, 1);
//		User u = (User) ob;
//		Item item = new Item();
//		item.setItemName("item2");
//		item.setManager(u);
//		item.setItemDescription("this is item2");
//		itemService.saveItem(item);
//		System.out.println("got");
		// User u=(User)ob;
		// Item item=new Item();
		// item.setItemName("item2");
		// item.setManager(u);
		// item.setItemDescription("this is item2");
		// List<Item> items=itemdao.findItemsByManager(1);
		// if(items!=null)
		// {
		// System.out.println(items.get(0).getItemDescription());
		// }
		// List<Item> list=itemdao.findItemsByManager(1);
		// Item item=list.get(0);
		// System.out.println(item.getItemID());
	}

}
