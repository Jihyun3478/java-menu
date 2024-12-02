package menu.domain;

import static menu.exception.ErrorMessage.*;

public class Coach {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 4;

    private final String coachName;

    public Coach(String coachName) {
        validateCoachName(coachName);
        this.coachName = coachName;
    }

    private void validateCoachName(String coachName) {
        if(!(coachName.length() >= MINIMUM_NAME_LENGTH && coachName.length() <= MAXIMUM_NAME_LENGTH)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME_LENGTH.getMessage());
        }
    }

    public String getCoachName() {
        return coachName;
    }
}
