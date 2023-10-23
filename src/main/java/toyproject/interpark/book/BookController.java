package toyproject.interpark.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.book.dto.CreateBookRequest;

import java.net.URI;

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

    // 회원 별 예매한 공연 조회
    @GetMapping("/{id}")
    public ResponseEntity<Book> getAllBooksByUserId(@PathVariable int id) {

        return null;
    }

    // 예매 취소
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("예매 취소됨");
    }
}
