package toyproject.interpark.show;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.show.dto.CreateShowRequest;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    // 공연 등록
    @PostMapping("/shows")
    public ResponseEntity<Show> createShow(@RequestBody CreateShowRequest showRequest) {
        showService.createShow(showRequest);
        return null;
    }

    // 공연 전체 조회
    @GetMapping("/shows")
    public ResponseEntity<Show> getShows() {
        showService.getShows();
        return null;
    }

    // 공연 개별 조회
    @GetMapping("/shows/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable int show_id) {
        showService.getShowById(show_id);
        return null;
    }

    // 공연 정보 수정
    @PatchMapping("/shows/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable int show_id) {
        showService.updateShow();
        return null;
    }

    // 공연 삭제
    @DeleteMapping("/shows/{id}")
    public ResponseEntity<Show> deleteShow(@PathVariable int show_id) {
        showService.deleteShow();
        return null;
    }


}
