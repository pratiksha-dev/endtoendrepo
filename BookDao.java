package com.scp.java.endtoend;

import java.util.List;

import com.scp.java.endtoend.AppConstants.BookProperties;

public interface BookDao {
	

	public int insertBook(BookEn book);
	public BookEn fetchBook(int bookId);
	public List<BookEn> fetchAllBook(boolean isDesc,BookProperties ...property);
	public BookEn modifyBook(BookEn book);
	public boolean removeBook(BookEn book);//*


}
