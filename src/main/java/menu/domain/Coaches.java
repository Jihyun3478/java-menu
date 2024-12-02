package menu.domain;

import static menu.exception.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {
    private List<Coach> coaches = new ArrayList<>();

    public Coaches(List<String> coachNames) {
        validateCoachesCount(coachNames);
        this.coaches = getCoaches(coachNames);
    }

    private void validateCoachesCount(List<String> coachNames) {
        if(!(coachNames.size() >= 2 && coachNames.size() <= 5)) {
            throw new IllegalArgumentException(INVALID_COACHES_COUNT.getMessage());
        }
    }

    private List<Coach> getCoaches(List<String> coachNames) {
        return coachNames.stream()
            .map(Coach::new)
            .collect(Collectors.toList());
    }

    public String getCoachName(int index) {
        return coaches.get(index).getCoachName();
    }
}
