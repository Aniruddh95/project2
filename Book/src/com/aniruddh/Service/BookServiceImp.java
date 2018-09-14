package com.aniruddh.Service;

import java.util.ArrayList;

import com.aniruddh.DAO.BookDAOImp;
import com.aniruddh.DAO.IBookDAO;
import com.aniruddh.entity.Author;
import com.aniruddh.entity.Book;

public class BookServiceImp implements IBookService {

	IBookDAO dao = new BookDAOImp();
	
	public ArrayList<Book> getAllBookDetails() {
		// TODO Auto-generated method stub
		return dao.getAllBookDetails();
	}

	public ArrayList<Book> getBookDetails(String authorName) {
		// TODO Auto-generated method stub
		
		return dao.getBookDetails(authorName);
	}

	public ArrayList<Book> getBookDetailsInRange(int ll, int ul) {
		
		
		return dao.getBookDetailsInRange(ll, ul);
	}

	public String getAuthorName(int id) {
		
		
		
		return dao.getAuthorName(id);
	}

	public void setBookDetails(Book book) {
		
		dao.setBookDetails(book);
		
	}

	public void setBook(Book book) {
		dao.startTransaction();
		dao.setBook(book);
		dao.endTransaction();
	}

	public void setAuthor(Author author) {
		dao.startTransaction();
		dao.setAuthor(author);
		dao.endTransaction();
	}

	public void startTransaction() {
		
		dao.startTransaction();
		
	}

	public void endTransaction() {
		
		dao.endTransaction();
		
	}

	/*public void setAuthorDetails(Author author) {
		// TODO Auto-generated method stub
		
	}
*/
}
