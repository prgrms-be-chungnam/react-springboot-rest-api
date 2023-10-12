package toyproject.interpark.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.user.dto.SignUpRequest;
import toyproject.interpark.user.dto.SignInRequest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원 가입
    public User signUp(SignUpRequest request) {
        User newUser = new User();
        newUser.setUserId(request.getUserId());
        newUser.setUserPw(request.getUserPw());
        newUser.setUserName(request.getUserName());
        newUser.setUserAddr(request.getUserAddr());
        newUser.setUserPhone(request.getUserPhone());

        return userRepository.save(newUser);
    }

    // 로그인
    public User signIn(SignInRequest request) {
        String signInId = request.getUserId();
        String signInPW = request.getUserPw();

        User user = userRepository.findByUserId(signInId);
        if (user != null && signInPW.equals(user.getUserPw())) {
            return user;
        }
        else if (user == null ) {
            throw new RuntimeException("해당 아이디를 찾을 수 없습니다");
        }
        else {
             throw new RuntimeException("로그인 실패");
        }

    }

}
