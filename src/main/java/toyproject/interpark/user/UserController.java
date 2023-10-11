package toyproject.interpark.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    // 회원 가입
    @PostMapping("users/sign_up")
    public void signUp() {

    }

    // 로그인
    @PostMapping("users/sing_in")
    public void signIn() {

    }


}
