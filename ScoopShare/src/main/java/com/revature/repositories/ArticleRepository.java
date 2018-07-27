package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Article;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {
	
	static {
		System.out.println("[DEBUG] - ArticleRepository instantiated...");
	}
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Article> getAll() {
		
		System.out.println("[DEBUG] - ArticleRepository.getAll...");
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Article", Article.class).getResultList();
	}
	
	public Article getById(int id) {
		
		System.out.println("[DEBUG] - ArticleRepository.getById...");
		Session session = sessionFactory.getCurrentSession();
		return session.get(Article.class, id);
		
	}
	
	public Article addArticle(Article newArticle) {
		
		System.out.println("[DEBUG] - In FlashCardRepository.addArticle()...");
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(newArticle);
		return newArticle;
	}
	
	public Article updateArticle(Article updatedArticle) {
		
		System.out.println("[DEBUG] - In FlashCardRepository.updateArticle()...");
		Session currentSession = sessionFactory.getCurrentSession();
		Article article = currentSession.get(Article.class, updatedArticle.getArticle_id());
		
		if(article == null) {
			return article;
		}
		
		article = updatedArticle;
		return article;
	}
	
}