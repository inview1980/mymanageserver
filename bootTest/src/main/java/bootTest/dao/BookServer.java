package bootTest.dao;

import bootTest.mapper.BookMapper;
import bootTest.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServer {
    @Autowired
    BookMapper bookMapper=null;

    public List<Book> findAll(){
        return bookMapper.findAll();
    }
//    int insert(BaseBook record);
//
//    Book selectOne(String pk);
//
//    Book selectOne(BookCriteria criteria);
//
//    List<Book> selectList(BookCriteria criteria);
//
//    int count(BookCriteria criteria);
//
//    int update(BaseBook record);
//
//    int update(BaseBook record, BookCriteria criteria);
//
//    int delete(String pk);
//
//    int delete(BookCriteria criteria);
}