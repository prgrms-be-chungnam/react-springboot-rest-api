package toyproject.interpark.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.book.dto.CreateBookRequest;
import toyproject.interpark.show.Show;
import toyproject.interpark.show.ShowRepository;
import toyproject.interpark.user.User;
import toyproject.interpark.user.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    // 공연 예매
    public int createBook(CreateBookRequest createBookRequest) {
        Optional<User> user = userRepository.findById(createBookRequest.getUserNum());
        Optional<Show> show = showRepository.findById(createBookRequest.getShowId());

        if (user.isEmpty() || show.isEmpty()) {
            throw new RuntimeException("해당 id의 user 나 show 가 없음");
        }

        Book newBook = new Book();
        newBook.setBookUser(user.get());
        newBook.setBookShow(show.get());
        newBook.setBookDate(LocalDateTime.now());

        return bookRepository.save(newBook).getBookId();
    }

    // 공연 조회
    public List<GetAllBooksByUserNumProjection> getAllBooksByUserNum(int userNum) {
        return bookRepository.findAllByBookUser_UserNum(userNum);
    }

    // 예매 취소
    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}
