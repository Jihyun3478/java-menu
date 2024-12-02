package menu.exception;

public enum ErrorMessage {
    INVALID_COACH_NAME_LENGTH("코치의 이름은 최소 2글자, 최대 4글자여야 합니다."),
    INVALID_COACHES_COUNT("코치는 최소 2명, 최대 5명여야 합니다."),
    INVALID_MENU_COUNT("못 먹는 메뉴는 최소 0개, 최대 2개여야 합니다."),
    NOT_EXIST_MENU("존재하지 않는 메뉴입니다."),
    ;

    private static final String PREFIX = "[ERROR] ";
    private static final String POSTFIX = " 다시 입력해 주세요.";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(PREFIX + message + POSTFIX, args);
    }
}
