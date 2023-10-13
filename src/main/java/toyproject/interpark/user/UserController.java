package toyproject.interpark.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.user.dto.SignInRequest;
import toyproject.interpark.user.dto.SignUpRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입
    @PostMapping("users/sign_up")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequest request) {
        userService.signUp(request);
        return ResponseEntity.ok("가입이 완료되었습니다.");
    }

    // 로그인
    @PostMapping("users/sign_in")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest request) {
        String signInName = userService.signIn(request);
        return ResponseEntity.ok(signInName + " 님 반갑습니다!");
    }


}
