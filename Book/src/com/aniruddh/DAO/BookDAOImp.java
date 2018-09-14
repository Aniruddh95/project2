package com.aniruddh.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.aniruddh.entity.Author;
import com.aniruddh.entity.Book;

public class BookDAOImp implements IBookDAO {

	
//	EntityManagerFactory factory;
	EntityManager entity;
	
	
	public ArrayList<Book> getAllBookDetails() {
		
		ArrayList<Book> books = new ArrayList<Book>();
		entity = JPAUtil.getEntityManager();
		
		String get = "select book from Book book";
		TypedQuery<Book> details = entity.createQuery(get, Book.class);
		books = (ArrayList<Book>) details.getResultList();
		
		
		
		
		
		
		return books;
	}

	public ArrayList<Book> getBookDetails(String authorName) {
		entity = JPAUtil.getEntityManager();
		ArrayList<Book> bookDetails = new ArrayList<Book>();
		String find = "select book from Book book where book.author.name='"+authorName+"'";
		TypedQuery<Book> auth = entity.createQuery(find, Book.class);
		bookDetails = (ArrayList<Book>) auth.getResultList();
		
		
		
		
		
		
		return bookDetails;
	}

	public ArrayList<Book> getBookDetailsInRange(int ll, int ul) {
		
		entity = JPAUtil.getEntityManager();
		ArrayList<Book> bookDetails = new ArrayList<Book>();
		String detail = "select book from Book book where book.price>'"+ll+"' and book.price<'"+ul+"'";
		TypedQuery<Book> range = entity.createQuery(detail, Book.class);
		bookDetails = (ArrayList<Book>) range.getResultList();
		return bookDetails;
	}

	public String getAuthorName(int id) {
		
		entity = JPAUtil.getEntityManager();
		//Author detail = entity.find(Author.class, id);
		String query = "select book from Book book where book.isbn='"+id+"'";
		TypedQuery<Book> details = entity.createQuery(query, Book.class);
		Book book = details.getSingleResult();
		
		return book.getAuthor().getName();
	}

	public void setBookDetails(Book book) {
		
		entity = JPAUtil.getEntityManager();
		//entity = factory.createEntityManager();
		
		entity.getTransaction().begin();
		entity.persist(book);
		entity.getTransaction().commit();
		
		
	}

	/*public void setAuthorDetails(Author author) {
		// TODO Auto-generated method stub
		
	}*/

	public void startTransaction() {
		entity = JPAUtil.getEntityManager();
		entity.getTransaction().begin();
		
	}

	public void endTransaction() {
		 entity.getTransaction().commit();
		
	}

	public void setBook(Book book) {
		entity.persist(book);
		
		
	}

	public void setAuthor(Author author) {
		
		 entity.persist(author);
	}

}
