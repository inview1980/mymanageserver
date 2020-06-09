package myboot.mappers;

import myboot.pojo.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    List<BookEntity> getBooks();
}
