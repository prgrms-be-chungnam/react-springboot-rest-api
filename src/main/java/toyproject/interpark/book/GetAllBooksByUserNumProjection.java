package toyproject.interpark.book;

import toyproject.interpark.show.Show;

import java.time.LocalDateTime;

public interface GetAllBooksByUserNumProjection {
    int getBookId();
    LocalDateTime getBookDate();
    Show getBookShow();
}
