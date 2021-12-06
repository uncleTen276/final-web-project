package com.data;

import java.util.Properties;

import com.cart.Cart;
import com.item.Item;
import com.tree.Tree;
import com.user.User;
import com.userInfo.UserInfo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUntil {
	private static SessionFactory sessionFactory;

	// public static SessionFactory getSessionFacoty() {
	// if (sessionFactory == null) {
	// try {
	// Configuration configuration = new Configuration();
	// Properties settings = new Properties();
	// settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
	// settings.put(Environment.DRIVER, "org.postgresql.Driver");
	// settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
	// settings.put(Environment.USER, "postgres");
	// settings.put(Environment.PASS, "2762001T");
	// settings.put(Environment.SHOW_SQL, "true");
	// settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	// configuration.setProperties(settings);
	// configuration.addAnnotatedClass(UserInfo.class);
	// configuration.addAnnotatedClass(User.class);
	// configuration.addAnnotatedClass(Item.class);
	// configuration.addAnnotatedClass(Tree.class);
	// configuration.addAnnotatedClass(Cart.class);
	// ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// .applySettings(configuration.getProperties()).build();
	// System.out.println("Hibernate Java Config serviceRegistry created");
	// sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	// return sessionFactory;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }

	// }
	// return sessionFactory;
	// }

	// for heroku
	// public static SessionFactory getSessionFacoty() {
	// if (sessionFactory == null) {
	// try {
	// Configuration configuration = new Configuration();
	// Properties settings = new Properties();
	// settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
	// settings.put(Environment.DRIVER, "org.postgresql.Driver");
	// settings.put(Environment.URL,
	// "jdbc:postgresql://ec2-54-89-105-122.compute-1.amazonaws.com:5432/d6k0f35nhokahq");
	// settings.put(Environment.USER, "urwapcimxudohp");
	// settings.put(Environment.PASS,
	// "760f8a18253c2db8e314d1af371a6bcdda02fc0e3691f987f2aa5de25dd52d94");
	// settings.put(Environment.SHOW_SQL, "true");
	// settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	// settings.put(Environment.HBM2DDL_AUTO, "update");

	// configuration.setProperties(settings);
	// configuration.addAnnotatedClass(UserInfo.class);
	// configuration.addAnnotatedClass(User.class);
	// configuration.addAnnotatedClass(Item.class);
	// configuration.addAnnotatedClass(Tree.class);
	// configuration.addAnnotatedClass(Cart.class);
	// ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// .applySettings(configuration.getProperties()).build();
	// System.out.println("Hibernate Java Config serviceRegistry created");
	// sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	// return sessionFactory;
	// } catch (Exception e) {
	// e.printStackTrace();
	// }

	// }
	// return sessionFactory;
	// }

	public static SessionFactory getSessionFacoty() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL,
						"jdbc:mysql://database-1.ctmpvntqk27b.ap-southeast-1.rds.amazonaws.com:3306/postgres");
				settings.put(Environment.USER, "admin");
				settings.put(Environment.PASS, "chobeosuiroi:sadcow");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(UserInfo.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Item.class);
				configuration.addAnnotatedClass(Tree.class);
				configuration.addAnnotatedClass(Cart.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sessionFactory;
	}
}
