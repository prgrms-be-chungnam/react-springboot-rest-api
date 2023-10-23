package toyproject.interpark.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.book.dto.CreateBookRequest;

import java.net.URI;
import java.util.List;

import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 공연 예매
    @PostMapping("")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest bookRequest) {
        int bookId = bookService.createBook(bookRequest);
        URI uri = fromPath("api/books/{id}")
                .buildAndExpand(bookId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // 회원 별 예매한 공연 리스트 조회 -> id는 회원번호
    @GetMapping("/{id}")
    public ResponseEntity<List<GetAllBooksByUserNumProjection>> getAllBooksByUserNum(@PathVariable int id) {
        List<GetAllBooksByUserNumProjection> getBooks = bookService.getAllBooksByUserNum(id);
        return ResponseEntity.ok(getBooks);
    }

    // 예매 취소
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("예매 취소됨");
    }
}
