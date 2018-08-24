package com.easynotes.easynotes.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easynotes.easynotes.dto.DataIntegerObject;
import com.easynotes.easynotes.dto.DataObject;
import com.easynotes.easynotes.dto.DataStringObject;
import com.easynotes.easynotes.dto.NameValueObject;
import com.easynotes.easynotes.model.Book;
import com.easynotes.easynotes.repository.BooksRepository;

@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired 
	BooksRepository booksRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@GetMapping("/get")
	public List<Book> getBooks() {
		return booksRepository.findAll();
	}
	
	@PostMapping("/store")
	public Book createBook(@RequestBody Book book) {
		book.setCreatedAt(LocalDateTime.now());
		return booksRepository.save(book);
	}
	
	@GetMapping("/getBooksPerCategory")
	public List<NameValueObject> getBooksPerCategory() {
		List<NameValueObject> booksPerCat = new ArrayList<NameValueObject>();
		List<Object[]> result = em.createNativeQuery("SELECT category, COUNT(id) FROM Book GROUP BY category").getResultList();
		result.stream().forEach(b -> {
			NameValueObject obj = new NameValueObject();
			obj.setName((String) b[0]);
			obj.setValue((BigInteger) b[1]);
			booksPerCat.add(obj);
		});
		return booksPerCat;
	}
	
	@GetMapping("/getBooksPerAuthor")
	public List<DataObject> getBooksPerAuthor() {
		List<DataObject> booksPerAuthor = new ArrayList<DataObject>();
		List<Object[]> result = em.createNativeQuery("SELECT author, COUNT(id) FROM book GROUP BY author").getResultList();
		result.stream().forEach(a -> {
			DataStringObject author = new DataStringObject();
			DataIntegerObject count = new DataIntegerObject();
			author.setData((String) a[0]);
			count.setData((BigInteger) a[1]);
//			NameValueObject obj = new NameValueObject();
//			obj.setName((String) a[0]);
//			obj.setValue((BigInteger) a[1]);
			booksPerAuthor.add(author);
		});
		return booksPerAuthor;
	}
	
	
	
}
