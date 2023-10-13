package toyproject.interpark.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private String userId;
    private String userPw;
    private String userName;
    private String userAddr;
    private String userPhone;
}
