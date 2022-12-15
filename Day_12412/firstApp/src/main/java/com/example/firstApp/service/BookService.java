package com.example.firstApp.service;
import com.example.firstApp.exception.NotFoundException;
import com.example.firstApp.model.Book;
import com.example.firstApp.repository.BookRepository;
import com.example.firstApp.request.UpsertBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Random;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id){
//        Optional<Book> bookOptional = bookRepository.findById(id);
//        if(bookOptional.isPresent()){
//            return bookOptional.get();
//        }
//        throw new NotFoundException("Not found book with id = " +id);

        return bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found book with id = " +id);
        });
    }
    public Book createBook (UpsertBookRequest request){
        Random rd = new Random();
        int id = rd.nextInt(1000);

        Book book = new Book(id, request.getTitle(), request.getDescription(), request.getPublishYear());

        bookRepository.save(book);
        return book;

    }

    public Book updateBook(int id, UpsertBookRequest request){
     Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found book with id = " +id);
        });

     book.setTitle(request.getTitle());
     book.setDescription(request.getDescription());
     book.setPublishYear(request.getPublishYear());

     return book;
    }

    public void deleteBook(int id){
       Book book = bookRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException("Not found book with id = " +id);
        });

       bookRepository.delete(book);
    }
}
