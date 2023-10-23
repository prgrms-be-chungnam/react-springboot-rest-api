package toyproject.interpark.show;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import toyproject.interpark.show.dto.CreateShowRequest;
import toyproject.interpark.show.dto.UpdateShowRequest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.util.UriComponentsBuilder.fromPath;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    // 공연 등록
    @PostMapping("")
    public ResponseEntity<Show> createShow(@RequestBody CreateShowRequest showRequest) {
        int showId = showService.createShow(showRequest);
        URI uri = fromPath("/api/shows/{id}")
                .buildAndExpand(showId)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // 공연 전체 조회
    @GetMapping("")
    public ResponseEntity<List<Show>> getAllShows() {
        List<Show> showList = showService.getAllShows();
        return ResponseEntity.ok(showList);
    }

    // 공연 개별 조회
    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable int id) {
        Optional<Show> getShow = showService.getShowById(id);
        return getShow.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 공연 정보 수정
    @PatchMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable int id, @RequestBody UpdateShowRequest showRequest) {
        Show updateShow = showService.updateShow(id, showRequest);
        return ResponseEntity.ok(updateShow);
    }

    // 공연 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShow(@PathVariable int id) {
        showService.deleteShow(id);
        return ResponseEntity.ok("공연이 제거되었습니다.");
    }


}
