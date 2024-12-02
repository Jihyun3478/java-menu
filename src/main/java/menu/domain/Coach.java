package menu.domain;

import static menu.exception.ErrorMessage.*;

public class Coach {
    private final String coachName;

    public Coach(String coachName) {
        validateCoachName(coachName);
        this.coachName = coachName;
    }

    private void validateCoachName(String coachName) {
        if(!(coachName.length() >= 2 && coachName.length() <= 4)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH.getMessage());
        }
    }

    public String getCoachName() {
        return coachName;
    }
}
