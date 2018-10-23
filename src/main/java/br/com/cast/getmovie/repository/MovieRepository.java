package br.com.cast.getmovie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.getmovie.entities.Movie;

@Repository
public class MovieRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Movie movie){
		em.persist(movie);
	}
	
	public void remove(Movie movie){
		em.remove(movie);
	}
	
	public Movie searchByTitle(String title){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT m ").append("FROM ").append(Movie.class.getName()).append(" m ")
			.append("WHERE title = :title");
		
		Query query = em.createQuery(hql.toString());
		
		query.setParameter("title", title);
		
		return (Movie) query.getSingleResult();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> searchAll(){
		StringBuilder hql = new StringBuilder();
		
		hql.append("SELECT m ").append("FROM ").append(Movie.class.getName()).append(" m ");
		
		Query query = em.createQuery(hql.toString());	
		
		return query.getResultList();
		
	}
}
