package com.tedge.repository;  
import org.springframework.data.repository.CrudRepository;  
import com.tedge.model.Books;  
//repository that extends CrudRepository  
public interface BooksRepository extends CrudRepository<Books, Integer>  
{  
} 