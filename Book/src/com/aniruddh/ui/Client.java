package com.aniruddh.ui;

import java.util.ArrayList;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.aniruddh.DAO.JPAUtil;
import com.aniruddh.Service.BookServiceImp;
import com.aniruddh.Service.IBookService;
import com.aniruddh.entity.Author;
import com.aniruddh.entity.Book;

public class Client {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);	
	Book book = new Book();
	Author author = new Author();
	IBookService service = new BookServiceImp();
	
	EntityManager entity = JPAUtil.getEntityManager();
	entity.getTransaction().begin();
	
	entity.getTransaction().commit();
	
	
		
	System.out.println("Select your option");

	System.out.println("1. All book Details");
	System.out.println("2. Books written by given author name");
	System.out.println("3. All books within given range");
	System.out.println("4. Author name for given book id");
	System.out.println("5. Enter Details");
	
	int choice = sc.nextInt();
	
	switch (choice) {
	case 1:
		
		ArrayList<Book> books = new ArrayList<Book>();
		books = service.getAllBookDetails();
		
		System.out.println("Book Details Are");
		System.out.print("ISBN     ");
		System.out.print("Title         ");
		System.out.println("Price");
		for (Book b : books) {
			System.out.print(b.getIsbn());
			System.out.print("      "+b.getTitle());
			System.out.println("     "+b.getPrice());
		}
		
		
	
		
		break;
    case 2:
		
    	System.out.println("Enter the name of the author : ");
    	String name = sc.next();
    	
    	ArrayList<Book> bookDetails = new ArrayList<Book>();
    	bookDetails = service.getBookDetails(name);
    	
    	for (Book b : bookDetails) {
			System.out.print(b.getIsbn());
			System.out.print("      "+b.getTitle());
			System.out.println("     "+b.getPrice());
		}
    	
		break;
    case 3:
    	
    	System.out.println("Enter lower limit : ");
    	int ll = sc.nextInt();
    	System.out.println("Enter upper limit : ");
    	int ul = sc.nextInt();
    	
    	ArrayList<Book> bookD = new ArrayList<Book>();
    	bookD = service.getBookDetailsInRange(ll, ul);
    	
    	for (Book b : bookD) {
			System.out.print(b.getIsbn());
			System.out.print("      "+b.getTitle());
			System.out.println("     "+b.getPrice());
		}
	
	  break;
    case 4:
    	
    	System.out.println("Enter book id : ");
    	int id = sc.nextInt();
    	String authorName = service.getAuthorName(id);
    	
    	System.out.println("Author name for id "+id+" is "+authorName);
    	
    	
    	break;
 case 5:
    	
	 
	 System.out.println("Enter Book title : ");
	 String title = sc.next();
	 book.setTitle(title);
	 System.out.println("Enter Book price : ");
	 int price = sc.nextInt();
	 book.setPrice(price);
	 System.out.println("Enter Author Name : ");
	 String nameAuthor = sc.next();
	 author.setName(nameAuthor);
	 
	 book.setAuthor(author);
	 
	 service.setBook(book);
	 
	 
	 service.setAuthor(author);
	 
	 
	
	 
    	break;

	default:
		break;
	}
		
		

	}

}
