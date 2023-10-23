package toyproject.interpark.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import toyproject.interpark.book.dto.CreateBookRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 공연 예매
    public int createBook(CreateBookRequest createBookRequest) {
        Book newBook = new Book();
        BeanUtils.copyProperties(createBookRequest, newBook);

        return bookRepository.save(newBook).getBookId();
    }

    // 공연 조회
    public List<Book> getAllBooksByUserId(String userId) {
        return bookRepository.findAllBooksByUserId(userId);
    }

    // 예매 취소
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
