package toyproject.interpark.show;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "show")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "show_id")
    private int showId;

    @Column(name = "show_name")
    private String showName;

    // 날짜 형식이어야 함
    @Column(name = "show_date")
    private Date showDate;

    @Column(name = "show_price")
    private int showPrice;

    // theater FK 임
    @Column(name = "theater_id")
    private int theaterID;

    // 사진임
    @Column(name = "show_poster")
    private float showPoster;

}
