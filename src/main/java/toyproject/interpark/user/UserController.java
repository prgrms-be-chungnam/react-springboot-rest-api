package toyproject.interpark.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import toyproject.interpark.user.dto.SignInRequest;
import toyproject.interpark.user.dto.SignUpRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입
    @PostMapping("users/sign_up")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 로그인
    @PostMapping("users/sing_in")
    public ResponseEntity<User> signIn(SignInRequest request) {
        User user = userService.signIn(request);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
