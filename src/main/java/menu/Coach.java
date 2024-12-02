package menu;

public class Coach {
    private final String coachName;

    public Coach(String coachName) {
        validateCoachName(coachName);
        this.coachName = coachName;
    }

    private void validateCoachName(String coachName) {
        if(!(coachName.length() >= 2 && coachName.length() <= 4)) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 최소 2글자, 최대 4글자여야 합니다.");
        }
    }

    public String getCoachName() {
        return coachName;
    }
}
