package com.scp.java.endtoend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.scp.java.endtoend.AppConstants.BookProperties;

//business part..
public class BookServiceImpl implements BookService{

	public BookDaoImpl bookDatabaseOp = null;
	public BookServiceImpl() {
		bookDatabaseOp = new BookDaoImpl();//ini
	}
	
	public void sortByUserSpecificedProperty(String property, boolean isdesc) {
		//ordered collection - get filtered data from sql query itself -- **--always 
		//sorted collection -- get data from db first and then apply ur condition in service
	}
	
	
	public int addBook(Book book) {
		int num=0;
		if(book==null) {
			System.out.println("Invalid book ...");
		}else if(book.getBkPrice()<100) {
			System.out.println("Invalid Price");
		}else {
			num= bookDatabaseOp.insertBook(convertToEntity(book));
			System.out.println("Book Saved Successfully....!");
		}
		return num;
	}

	private BookEn convertToEntity(Book book) {
		BookEn en = new BookEn();
		en.setBookName(book.getBkName());
		en.setBookPrice(book.getBkPrice());
		en.setBookRemarks(book.getBkRemarks());
		return en;
	}

	public Book getBook(int bookId) {
		if(bookId>0) {
				BookEn entity = bookDatabaseOp.fetchBook(bookId);
				if(entity!=null)
					return convertToBook(entity);
				System.out.println("Book not present with given identifier..!");
		}
		System.out.println("invalid book id..canot fetch the values..");
		return null;
	}

	public List<Book> getAllBook(boolean flag,BookProperties ...property) {
		List<BookEn> entities =  bookDatabaseOp.fetchAllBook(flag,property);
		if(entities!=null && !entities.isEmpty())
			return convertToBooks(entities);
		System.out.println("No Books Avaiable in database..!");
		return null;
	}

	public List<Book> getAllBookSorted(boolean flag,BookProperties ...property) {
		List<BookEn> entities =  bookDatabaseOp.fetchAllBook(false,null);
		List<Book> books = null;
		if(entities!=null && !entities.isEmpty()) {
				books = convertToBooks(entities);
				if(property!=null && property.length>0) {
					if(flag) {
						switch (property[0]) {
						case bookName:
							Comparator<Book> bookCmprNM = new Comparator<Book>() {
								public int compare(Book o1, Book o2) {
									return -(o1.getBkName().compareTo(o2.getBkName()));
								}
							};
							Collections.sort(books,bookCmprNM);
							break;
						case bookPrice:
							Comparator<Book> bookCmprPR = new Comparator<Book>() {
								public int compare(Book o1, Book o2) {
									return -(int)(o1.getBkPrice()-o2.getBkPrice());
								}
							};
							Collections.sort(books,bookCmprPR);
							break;
						case bookRemarks:
							Comparator<Book> bookCmprRM = new Comparator<Book>() {
								public int compare(Book o1, Book o2) {
									return -(o1.getBkRemarks().compareTo(o2.getBkRemarks()));
								}
							};
							Collections.sort(books,bookCmprRM);
							break;
						}
					}else {
						switch (property[0]) {
						case bookName:
							Comparator<Book> bookCmprNM = new Comparator<Book>() {
								public int compare(Book o1, Book o2) {
									return (o1.getBkName().compareTo(o2.getBkName()));
								}
							};
							Collections.sort(books,bookCmprNM);
							break;
						case bookPrice:
							Comparator<Book> bookCmprPR = new Comparator<Book>() {
								public int compare(Book o1, Book o2) {
									return (int)(o1.getBkPrice()-o2.getBkPrice());
								}
							};
							Collections.sort(books,bookCmprPR);
							break;
						case bookRemarks:
							Comparator<Book> bookCmprRM = new Comparator<Book>() {
								public int compare(Book o1, Book o2) {
									return (o1.getBkRemarks().compareTo(o2.getBkRemarks()));
								}
							};
							Collections.sort(books,bookCmprRM);
							break;
						}
					
					}
				}else if(flag) {
					
					Comparator<Book> bookCmpr = new Comparator<Book>() {
						public int compare(Book o1, Book o2) {
							return o2.getBkId() - o1.getBkId();
						}
					};
					
				}else {
					Collections.sort(books); // id with asc // comparable
				}
		}
		return books;
	}
	
	
	
	
	public List<Book> getAllBookSortedV1(boolean flag,BookProperties ...property) {
		List<BookEn> entities =  bookDatabaseOp.fetchAllBook(false,null);
		List<Book> books = null;
		if(entities!=null && !entities.isEmpty()) {
				books = convertToBooks(entities);
				if(property!=null && property.length>0) {
					if(flag) {
						switch (property[0]) {
						case bookName:
							Collections.sort(books,(Book o1, Book o2)-> -(o1.getBkName().compareTo(o2.getBkName())) );
							break;
						case bookPrice:
							Collections.sort(books,(Book o1, Book o2)-> -(int)(o1.getBkPrice()- o2.getBkPrice()) );
							break;
						case bookRemarks:
							Collections.sort(books,(Book o1, Book o2)-> -(o1.getBkRemarks().compareTo(o2.getBkRemarks())) );
							break;
						}
					}else {
						switch (property[0]) {
						case bookName:
							Collections.sort(books,(Book o1, Book o2)-> (o1.getBkName().compareTo(o2.getBkName())) );
							break;
						case bookPrice:
							Collections.sort(books,(Book o1, Book o2)-> (int)(o1.getBkPrice()- o2.getBkPrice()) );
							break;
						case bookRemarks:
							Collections.sort(books,(Book o1, Book o2)-> (o1.getBkRemarks().compareTo(o2.getBkRemarks())) );
							break;
						}
					
					}
				}else if(flag) {
					
				}else {
					Collections.sort(books); // id with asc // comparable
				}
		}
		return books;
	}
	
	
	public List<Book> getAllBookSortedV2(boolean flag,BookProperties ...property) {
		List<BookEn> entities =  bookDatabaseOp.fetchAllBook(false,null);
		List<Book> books = null;
		
		Comparator<Book> bookComp = null;
		
		if(entities!=null && !entities.isEmpty()) {
				books = convertToBooks(entities);
				if(property!=null && property.length>0) {
					if(flag) {
						switch (property[0]) {
						case bookName:
							bookComp = (Book o1, Book o2)-> -(o1.getBkName().compareTo(o2.getBkName()));
							break;
						case bookPrice:
							bookComp=(Book o1, Book o2)-> -(int)(o1.getBkPrice()- o2.getBkPrice());
							break;
						case bookRemarks:
							bookComp=(Book o1, Book o2)-> -(o1.getBkRemarks().compareTo(o2.getBkRemarks()));
							break;
						}
					}else {
						switch (property[0]) {
						case bookName:
							bookComp=(Book o1, Book o2)-> (o1.getBkName().compareTo(o2.getBkName()));
							break;
						case bookPrice:
							bookComp=(Book o1, Book o2)-> (int)(o1.getBkPrice()- o2.getBkPrice());
							break;
						case bookRemarks:
							bookComp=(Book o1, Book o2)-> (o1.getBkRemarks().compareTo(o2.getBkRemarks()));
							break;
						}
					
					}
				}else if(flag) {
					
				}
				if(bookComp==null)
					Collections.sort(books); // id with asc // comparable
				else {
					Collections.sort(books,bookComp);
				}
		}
		return books;
	}
	
	
	
	
	private List<Book> convertToBooks(List<BookEn> entities) {
		List<Book>  books =new ArrayList<Book>();
		for(BookEn en : entities) {
			books.add(convertToBook(en));
		}
		return books;
	}


	public Book updateBook(Book book) {
		if(book!=null) {
			if(book.getBkId()<=0) {
				System.out.println("invalid book id...");
				return null;
			}
			BookEn entity = bookDatabaseOp.fetchBook(book.getBkId());
			if(entity!=null) { //present inside db
				BookEn en = convertToEntity(book);
				en.setBookId(book.getBkId());
				entity = bookDatabaseOp.modifyBook(en);
				System.out.println("Book Information Updated successfully...!");
				return convertToBook(entity);
			}
			System.out.println("Specified Id Book Not Found..so cannot update..");
		}else {
			System.out.println("invalid Book so cannot update..");
		}
		return null;
	}

	private Book convertToBook(BookEn entity) {
		Book bk =new Book();
		bk.setBkName(entity.getBookName());
		bk.setBkPrice(entity.getBookPrice());
		bk.setBkRemarks(entity.getBookRemarks());
		bk.setBkId(entity.getBookId());
		return bk;
	}


	public boolean deleteBook(int bookId) {
		if(bookId>0) {
			BookEn entity = bookDatabaseOp.fetchBook(bookId);
			if(entity!=null) {
				return bookDatabaseOp.removeBook(entity);
			}else {
				System.out.println("Not found so cannot delete");
			}
		}else {
			System.out.println("invalid book");
		}
		return false;
	}

}
