package br.com.cast.getmovie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.getmovie.entities.User;

@Repository
public class UserRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(User user){
		em.persist(user);
	}
	
	public void update(User user){
		em.merge(user);
	}
	
	public User searchById(Integer id){
		return em.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> searchAll(){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT u ").append("FROM ").append(User.class.getName()).append(" u ");
		
		Query query = em.createQuery(hql.toString());
		
		return query.getResultList();
	}
	
	public User login(String email, String password){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT u ").append("FROM ").append(User.class.getName()).append(" u ")
			.append("WHERE email = :email ")
			.append("AND ")
			.append("password = :password");
		
		Query query = em.createQuery(hql.toString());
		
		query.setParameter("email", email);
		query.setParameter("password", password);
		
		return (User) query.getSingleResult();
		
	}
	
	public void remove(User user){
		em.remove(user);
	}
}
