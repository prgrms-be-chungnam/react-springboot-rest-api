package toyproject.interpark.user;

import jakarta.persistence.*;
import lombok.*;
import toyproject.interpark.book.Book;

import java.util.List;

@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_num")
    private int userNum;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pw")
    private String userPw;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_addr")
    private String userAddr;

    @Column(name = "user_phone")
    private String userPhone;

    // 다수의 Book 엔티티를 가질 수 있는 컬렉션 필드
    @OneToMany(mappedBy = "bookUser")
    private List<Book> books;

}
