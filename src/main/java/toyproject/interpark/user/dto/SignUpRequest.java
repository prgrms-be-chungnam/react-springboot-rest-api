package toyproject.interpark.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String UserId;
    private String UserPw;
    private String UserName;
    private String UserAddr;
    private String UserPhone;
}
