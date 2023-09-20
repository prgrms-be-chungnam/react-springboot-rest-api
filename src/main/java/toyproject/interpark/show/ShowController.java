package toyproject.interpark.show;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    // 공연 등록
    @PostMapping("/shows")
    public Show createShow() {
        showService.createShow();
        return ____;
    }

    // 공연 전체 조회
    @GetMapping("/shows")
    public Show getShows() {
        showService.getShows();
        return;
    }

    // 공연 개별 조회
    @GetMapping("/shows/{id}")
    public Show getShowById(@PathVariable int show_id) {
        showService.getShowById();
        return;
    }

    // 공연 정보 수정
    @PostMapping("/shows/{id}")
    public Show updateShow(@PathVariable int show_id) {
        showService.updateShow();
        return;
    }

    // 공연 삭제
    @DeleteMapping("/shows/{id}")
    public Show deleteShow(@PathVariable int show_id) {
        showService.deleteShow();
        return;
    }


}
