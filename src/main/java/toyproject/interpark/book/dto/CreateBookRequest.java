package toyproject.interpark.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import toyproject.interpark.show.Show;
import toyproject.interpark.user.User;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBookRequest {
    private User bookUser;
    private Show bookShow;
}
