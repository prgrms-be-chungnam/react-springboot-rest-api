package toyproject.interpark.book;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "book_date")
    private LocalDateTime bookDate;

    @Column(name = "book_user_id")
    private int bookUserId;

    @Column(name = "book_show_id")
    private int bookShowId;

}
