package menu;

public class Coach {
    private String coachName;

    public Coach(String coachName) {
        validateCoachName(coachName);
        this.coachName = coachName;
    }

    private void validateCoachName(String coachName) {
        if(!(coachName.length() >= 2 && coachName.length() <= 4)) {
            throw new IllegalArgumentException();
        }
    }
}
