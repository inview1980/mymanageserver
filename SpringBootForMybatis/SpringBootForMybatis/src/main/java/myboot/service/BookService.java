package myboot.service;

import myboot.mappers.BookMapper;
import myboot.pojo.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public List<BookEntity> getList(){
        return bookMapper.getBooks();
    }
}
