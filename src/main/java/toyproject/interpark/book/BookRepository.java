package toyproject.interpark.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<GetAllBooksByUserNumProjection> findAllByBookUser_UserNum(int userNum);
}
