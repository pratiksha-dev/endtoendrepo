package com.scp.java.endtoend;

import java.util.List;

import com.scp.java.endtoend.AppConstants.BookProperties;

public interface BookService {
	public int addBook(Book book);
	public Book getBook(int bookId);
	public List<Book> getAllBook(boolean flag,BookProperties ...property);
	public Book updateBook(Book book);
	public boolean deleteBook(int bookId);
}
