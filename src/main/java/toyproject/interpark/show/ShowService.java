package toyproject.interpark.show;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    // 공연 등록
    public Show createShow(CreateShowRequest showRequest) {
        Show newShow = new Show();
        newShow.setShowName(showRequest.getShowName());
        newShow.setShowDate(showRequest.getShowDate());
        newShow.setShowPrice(showRequest.getShowPrice());
        newShow.setTheaterID(showRequest.getTheaterId());
        newShow.setShowPoster(showRequest.getShowPoster());
        return showRepository.save(newShow);
    }

    // 공연 전체 조회
    public Show getShows() {
        return showRepository.findAll();
    }

    // 공연 개별 조회
    public Show getShowById(int show_id) {
        return showRepository.findById(show_id);
    }

    // 공연 정보 수정
    public Show updateShow() {

    }

    // 공연 삭제
    public Show deleteShow() {

    }

}
