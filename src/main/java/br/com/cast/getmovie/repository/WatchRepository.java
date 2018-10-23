package br.com.cast.getmovie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.getmovie.entities.Watch;

@Repository
public class WatchRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Watch watch){
		em.persist(watch);
	}
	
	public void remove(Watch watch){
		em.remove(watch);
	}
	
	public Watch searchById(Integer id){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT w ").append("FROM ").append(Watch.class.getName()).append(" w ")
			.append("Join fetch w.user ")
			.append("Join fetch w.movie")
			.append("WHERE w.id = :id");
		
		Query query = em.createQuery(hql.toString());
		query.setParameter("id", id);
		
		return (Watch) query.getSingleResult();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Watch> searchAll(){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT w ").append("FROM ").append(Watch.class.getName()).append(" w ")
			.append("Join fetch w.user ")
			.append("Join fetch w.movie ");
		
		Query query = em.createQuery(hql.toString());
		
		return query.getResultList();
	}
}
