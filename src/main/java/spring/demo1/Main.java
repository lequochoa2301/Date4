package spring.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.demo1.config.SpringConfig;
import spring.demo1.entity.BookEntity;
import spring.demo1.repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    //tao du lieu trong table
    private static void createNewBook() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Linux shell programing");
        bookEntity.setAuthor("Roger");
        bookEntity.setCategory("IT books");
        bookEntity.setIsbn("ISI23012002");
        bookEntity.setNumberofPage(134);
        bookEntity.setPrice(18.9);
        bookEntity.setPublishDate(LocalDate.parse("2024-08-11"));

        BookEntity result = bookRepository.save(bookEntity);
        if(result != null) {
            System.out.println("A new book saved successfully, book ID = " + bookEntity.getId());
        }
    }
    //doc tat du lieu trong table
//    private static void readBook() {
//        List<BookEntity> bookList = (List<BookEntity>) bookRepository.findAll();
//        System.out.println("Found " + bookList.size() + "book(s) in the table book");
//        System.out.println("They are: ");
//        for (BookEntity book: bookList){
//            System.out.println(book.toString());
//        }
//    }
//    //doc du lieu table theo ID
//    private static void readBook(int bookID) {
//        Optional<BookEntity> bookEntity = bookRepository.findById(bookID);
//        if (bookEntity != null) {
//            System.out.println("Found a book with book ID = " + bookID);
//            System.out.println(bookEntity.toString());
//        } else {
//            System.out.println("Not found any book with book ID = "+bookID);
//        }
//    }
    //update du lieu table where ID
//    private static void updateBook() {
//        BookEntity bookEntity = bookRepository.findById(4).orElseThrow(() -> new RuntimeException("No book found with ID = 4"));
//        System.out.println("Book data before updating");
//        System.out.println(bookEntity.toString());
//
//        bookEntity.setAuthor("Hoa");
//        bookEntity.setNumberofPage(2002);
//        bookEntity.setPrice(23.5);
//        bookRepository.save(bookEntity);
//
//        System.out.println("Book data after updating");
//        System.out.println(bookEntity.toString());
//    }

    //xoa du lieu table theo ID
//    private static void deleteBookByID(int bookID) {
//
//        Optional<BookEntity> bookEntity = bookRepository.findById(bookID);
//        if (bookEntity != null) {
//
//            bookRepository.deleteById(bookID);
//            System.out.println("Delete thanh cong for book with ID = " + bookID);
//        } else {
//            System.out.println("Delete that bai: No book found with ID = " + bookID);
//        }
//    }
    // delete tat ca du lieu trong table
//    public static void deleteBookAll() {
//       bookRepository.deleteAll();
//       System.out.println("Delete Thanh Cong");
//    }
    //Get All books where author = Roger
//    public static void main(String[] args) {
//        List<BookEntity> bookEntityList = bookRepository.findByAuthor("Roger");
//        if(bookEntityList.size() != 0) {
//            System.out.println("Found " + bookEntityList.size() + "book(s) of Roger");
//            System.out.println("They are:");
//            for (BookEntity book : bookEntityList) {
//                System.out.println(book.toString());
//            }
//    }
    //Get books where author = Roger and price = 98.9
//    public static void main(String[] args) {
//            List<BookEntity> bookEntityList = bookRepository.findByAuthorAndPrice("Roger", 98.9);
//            if(bookEntityList.size() != 0) {
//                System.out.println("Found " + bookEntityList.size() + "book(s) of Roger");
//                System.out.println("They are:");
//                for (BookEntity book : bookEntityList) {
//                    System.out.println(book.toString());
//                }
//            }else {
//                System.out.println("No books found for Roger with price 98.9.");
//    }
    //Get all books where price = 18.9 of number of page = 2206
//    public static void main(String[] args) {
//
//        List<BookEntity> bookEntityList = bookRepository.findByPriceOrNumberofPage(18.9, 2206);
//
//        if (bookEntityList.size() != 0) {
//            System.out.println("Found " + bookEntityList.size() + " book(s) with price 18.9 and number or pages 2206");
//            System.out.println("They are:");
//            for (BookEntity book : bookEntityList) {
//                System.out.println(book.toString());
//            }
//        } else {
//            System.out.println("No books found with price 18.9 or number of pages 2206.");
//        }
//    }
    //Get all books where price < 50
//    public static void main(String[] args) {
//        List<BookEntity> bookEntityList = bookRepository.findByPriceLessThan(50.0);
//
//        if (bookEntityList.size() != 0) {
//            System.out.println("Found " + bookEntityList.size() + " book(s) with price less than 50");
//            System.out.println("They are:");
//            for (BookEntity book : bookEntityList) {
//                System.out.println(book.toString());
//            }
//        } else {
//            System.out.println("No books found with price less than 50.");
//        }
//    }
    //Get all books where price >= 98.9
//    public static void main(String[] args) {
//        List<BookEntity> bookEntityList = bookRepository.findByPriceGreaterThanEqual(98.9);
//
//        if (bookEntityList.size() != 0) {
//            System.out.println("Found " + bookEntityList.size() + " book(s) with price greater than or equal to 120");
//            System.out.println("They are:");
//            for (BookEntity book : bookEntityList) {
//                System.out.println(book.toString());
//            }
//        } else {
//            System.out.println("No books found with price greater than or equal to 98.9");
//        }
//    }
          //Get all books where book name containing "ja"
//    public static void main(String[] args) {
//        List<BookEntity> bookEntityList = bookRepository.findByNameContaining("ja");
//
//        if (bookEntityList != null) {// co the viet (!bookEntityList.isEmpty())
//            System.out.println("Found " + bookEntityList.size() + " book(s) with name containing 'ja'");
//            System.out.println("They are:");
//            for (BookEntity book : bookEntityList) {
//                System.out.println(book.toString());
//            }
//        } else {
//            System.out.println("No books found with name containing 'ja'.");
//        }
//    }
    //Get book where isbn = ISI23012002
//    public static void main(String[] args) {
//        // Tìm cuốn sách có ISBN là "ISI23012002"
//        BookEntity book = bookRepository.findByIsbn("230012002");
//
//        if (book != null) {
//            System.out.println("Found book with ISBN '230012002':");
//            System.out.println(book.toString()); // In thông tin của cuốn sách
//        } else {
//            System.out.println("No book found with ISBN '230012002'.");
//        }
//    }
     //Get all books where publish date is after 2024-08-11
    public static void main(String[] args) {
        LocalDate publishDate = LocalDate.of(2024, 8, 10);
        List<BookEntity> bookEntityList = bookRepository.findByPublishDateAfter(publishDate);
        if(bookEntityList != null) {
            System.out.println("Found " + bookEntityList.size() + " book(s) published after " + publishDate + ":");
            for (BookEntity book : bookEntityList) {
                System.out.println(book.toString());
            }
        } else {
            System.out.println("No books found published after " + publishDate + ".");
        }

    }
}
//    public static void main(String[] args) {
//        createNewBook();
//        readBook();
//        readBook(3);
//        updateBook();
//        deleteBookByID(4);
//        deleteBookAll();
// }


