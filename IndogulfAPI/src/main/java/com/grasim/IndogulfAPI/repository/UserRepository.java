package com.grasim.IndogulfAPI.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grasim.IndogulfAPI.model.User;

@Repository
public class UserRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public List<User> getAll() throws Exception {
		List<User> result = entityManager.createQuery("SELECT s FROM User s").getResultList();
		return result;
	}

	@Transactional
	public User save(User user) {
		try {
			user = entityManager.merge(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllAfterRevId(Long revId) throws Exception {
		Query query = entityManager.createQuery("select u from User u where u.modifiedSrNo > :revId");
		query.setParameter("revId", revId);
		return (List<User>) query.getResultList();
	}

	public User getByUsername(String username) throws Exception {
		Query query = entityManager.createQuery("select u from User u where u.username = :username");
		query.setParameter("username", username);
		return (User) query.getSingleResult();
	}

}
