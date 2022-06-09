package com.example.library.service;

import com.example.library.model.Address;
import com.example.library.model.Book;
import com.example.library.repository.AddressRepository;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book add(Book book){
        return bookRepository.saveAndFlush(book);
    }
}
