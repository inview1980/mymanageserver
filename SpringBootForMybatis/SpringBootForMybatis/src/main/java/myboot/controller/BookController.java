package myboot.controller;

import myboot.pojo.BookEntity;
import myboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/allBook")
    @ResponseBody
    public List<BookEntity> getAllBook(){
        return bookService.getList();
    }

//    @RequestMapping("/addBook")
//    @ResponseBody
//    public BookEntity addBook(){
//        var tmp=new BookEntity();
//        var random = new Random();
//        tmp.setBookid("Book".concat(String.valueOf(random.nextInt())));
//        tmp.setBookName(String.valueOf(random.nextInt()));
//        tmp.setAuthor("jjjj");
//        tmp.setBooktypeid((short)44);
//        tmp.setBorrowDate(new Date(4444L));
//        tmp.setPrice(new BigDecimal(44));
//        tmp.setPublishment("jjjjj");
//        tmp.setUserCode("user:".concat(String.valueOf(random.nextInt())));
//        tmp.setPublishDate(new Date(1111L));
//        bookRepository.save(tmp);
//        return tmp;
//    }

//    @RequestMapping("/find")
//    @ResponseBody
//    public List<BookEntity> findBook() {
//        var criter=entityManager.cr
//        criter.getParameters()
//    }

}
