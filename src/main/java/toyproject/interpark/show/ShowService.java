package toyproject.interpark.show;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.interpark.show.dto.CreateShowRequest;
import toyproject.interpark.show.dto.UpdateShowRequest;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;

    // 공연 등록
    public int createShow(CreateShowRequest showRequest) {
        Show newShow = new Show();
        newShow.setShowName(showRequest.getShowName());
        newShow.setShowDate(showRequest.getShowDate());
        newShow.setShowPrice(showRequest.getShowPrice());
        newShow.setTheaterId(showRequest.getTheaterId());
        newShow.setShowPoster(showRequest.getShowPoster());
        return showRepository.save(newShow).getShowId();
    }

    // 공연 전체 조회
    public List<Show> getAllShows() {
        System.out.println(showRepository.findAll().get(0));
        return showRepository.findAll();
    }

    // 공연 개별 조회
    public Optional<Show> getShowById(int showId) {
        return showRepository.findById(showId);
    }

    // 공연 정보 수정
    public Show updateShow(int showId, UpdateShowRequest showRequest) {
        Optional<Show> optionalShow = showRepository.findById(showId);

        if (optionalShow.isPresent()) {
            Show existingShow = optionalShow.get();

            existingShow.setShowName(showRequest.getShowName());
            existingShow.setShowDate(showRequest.getShowDate()); // show를 date 형식으로 바꿔서 그런 것 같음
            existingShow.setShowPrice(showRequest.getShowPrice());
            existingShow.setTheaterId(showRequest.getTheaterId());
            existingShow.setShowPoster(showRequest.getShowPoster());

            return showRepository.save(existingShow);
        } else {
            throw new EntityNotFoundException();
        }
    }

    // 공연 삭제
    public void deleteShow(int showId) {
        showRepository.deleteById(showId);
    }

}
