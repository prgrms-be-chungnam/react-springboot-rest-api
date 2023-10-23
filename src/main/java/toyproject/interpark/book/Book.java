package toyproject.interpark.book;

import jakarta.persistence.*;
import lombok.*;
import toyproject.interpark.show.Show;
import toyproject.interpark.user.User;

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

    @JoinColumn(name = "user_num")
    @ManyToOne
    private User bookUser;

    @JoinColumn(name = "show_id")
    @ManyToOne
    private Show bookShow;

}
