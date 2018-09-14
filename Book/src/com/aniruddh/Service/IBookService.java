package com.aniruddh.Service;

import java.util.ArrayList;

import com.aniruddh.entity.Author;
import com.aniruddh.entity.Book;

public interface IBookService {
	
	public ArrayList<Book> getAllBookDetails(); 
	
	public ArrayList<Book> getBookDetails(String authorName);
	
	public ArrayList<Book> getBookDetailsInRange(int ll, int ul);
	
	public String getAuthorName(int id);
	
    public void setBookDetails(Book book);
	
//	public void setAuthorDetails(Author author);
    
	public void setBook(Book book);
	
	public void setAuthor(Author author);
	
public void startTransaction();
	
	public void endTransaction();

}
