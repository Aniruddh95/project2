package com.aniruddh.DAO;

import java.util.ArrayList;

import com.aniruddh.entity.Author;
import com.aniruddh.entity.Book;

public interface IBookDAO {
	
public ArrayList<Book> getAllBookDetails(); 
	
	public ArrayList<Book> getBookDetails(String authorName);
	
	public ArrayList<Book> getBookDetailsInRange(int ll, int ul);
	
	public String getAuthorName(int id);
	
	public void setBookDetails(Book book);
	
	//public void setAuthorDetails(Author author);
	
	public void startTransaction();
	
	public void endTransaction();
	
	public void setBook(Book book);
	
	public void setAuthor(Author author);


}
