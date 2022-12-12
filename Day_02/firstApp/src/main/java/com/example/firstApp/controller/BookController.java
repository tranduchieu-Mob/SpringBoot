package com.example.firstApp.controller;

import com.example.firstApp.model.Book;
import com.example.firstApp.request.UpsertBookRequest;
import com.example.firstApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Exception
//Lambda expression
//Stream
//Functional
//Method Reference
//Generic


@RestController
@RequestMapping("api/v1/")
public class BookController {
    @Autowired //inject bean
    private BookService bookService;



    // GET : api/v1/books : Lấy danh sách tất cả book
    @GetMapping("books")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    // GET : api/v1/books/{id} : Lấy chi tiết 1 cuốn sách
    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }

    // POST : api/v1/books : Tạo mới book --> Đối tượng sau khi tạo
    @PostMapping("books")
    public Book createBook(@RequestBody UpsertBookRequest request){
        return bookService.createBook(request);
    }

    // PUT : api/v1/books/{id} : Cập nhật thông tin cuốn sách--> Đối tượng sau khi cập nhật
    @PutMapping("books/{id}")
    public Book updateBook(@PathVariable int id,@RequestBody UpsertBookRequest request ){
        return bookService.updateBook(id,request);
    }

    // DELETE : api/v1/books/{id} : Xóa cuốn sách theo id
    @DeleteMapping("books/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}
