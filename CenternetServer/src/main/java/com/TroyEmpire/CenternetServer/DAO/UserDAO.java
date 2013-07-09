package com.TroyEmpire.CenternetServer.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.TroyEmpire.CenternetServer.Entity.User;
import com.TroyEmpire.CenternetServer.IDAO.IUserDAO;

@Component
public class UserDAO extends DAO<User, Long> implements IUserDAO {

	@Override
	public User getUserByName(String username) {
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> query = em.createQuery(
				"select u from User u where u.name=:name", User.class);
		query.setParameter("name", username);
		User user = query.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return user;
	}

	@Override
	public boolean whetherUserExists() {
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		User user;
		EntityManager em = this.getEntityManager();
		em.getTransaction().begin();
		TypedQuery<User> query = em.createQuery(
				"select u from User u where u.email=:email", User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (users != null && users.size() == 1) {
			user = users.get(0);
		} else {
			user = null;
		}
		em.getTransaction().commit();
		em.close();
		return user;
	}
}
