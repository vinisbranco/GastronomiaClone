package br.com.gastronomia.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.gastronomia.db.GenericHibernateDAO;
import br.com.gastronomia.db.HibernateUtil;
import br.com.gastronomia.model.User;

public class UserDAO extends GenericHibernateDAO<User> {
	public List<User> listForName(Object User, String q) {
		Session session = HibernateUtil.getFactory();
		List<User> users = session.getNamedQuery("findUserForName").setParameter("userName", q).list();
		return users;
	}

	public User findUserByCPF(String cpf) {
		return (User) findSingleObject("cpf", User.class, cpf);
	}

	public User findUserByEmail(String email) {
		return (User) findSingleObject("email", User.class, email);
	}
	
	public User findUserByMatricula(String matricula) {
		return (User) findSingleObject("matricula", User.class, matricula);
	}


	public long removeUser(User user) {
		return remove(user);
	}

	public User findUserByID(long id) {
		return (User) findId(id, User.class);
	}

	public long updateUser(User user) {
		return merge(user);
	}

	public long alterStatus(long id, boolean status) {
		User user = findUserByID(id);
		user.setActive(status);
		return merge(user);
	}
}