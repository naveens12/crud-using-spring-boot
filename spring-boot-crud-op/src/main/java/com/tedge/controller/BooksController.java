package com.tedge.controller;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
import com.tedge.model.Books;  
import com.tedge.service.BooksService;  

//Controller class
//@RestController is a convenience annotation for creating Restful controllers. 
//It is a specialization of @Component and is autodetected through classpath scanning. 
//It adds the @Controller and @ResponseBody annotations. 
//It converts the response to JSON or XML.
@RestController  
public class BooksController   
{  	
	@Autowired  
	BooksService booksService;  
	
	//get mapping for retrieval from db   
	@GetMapping("/book")  
	private List<Books> getAllBooks()   
	{  
		return booksService.getAllBooks();  
	}
	
	//get mapping that retrieves specific book  
	@GetMapping("/book/{bookid}")  
	private Books getBooks(@PathVariable("bookid") int bookid)   
	{  
		return booksService.getBooksById(bookid);  
	} 
	
	//delete mapping that deletes a specified book  
	@DeleteMapping("/book/{bookid}")  
	private void deleteBook(@PathVariable("bookid") int bookid)   
	{  
		booksService.delete(bookid);  
	}  
	
	//post mapping that post the book in db  
	@PostMapping("/books")  
	private int saveBook(@RequestBody Books books)   
	{  
		booksService.saveOrUpdate(books);  
		return books.getBookid();  
	} 
	
	//put mapping that updates the book detail   
	@PutMapping("/books")  
	private Books update(@RequestBody Books books)   
	{  
		booksService.saveOrUpdate(books);  
		return books;  
	}  
} 