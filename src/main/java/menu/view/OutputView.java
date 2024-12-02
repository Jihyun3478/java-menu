package menu.view;

public class OutputView {
    public static void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void inputCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void inputCantEatingMenus(String coachName) {
        System.out.printf("%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName);
    }

    public static void printResult() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        // TODO: 메인 결과 출력 구현
    }

    public static void finish() {
        System.out.println("추천을 완료했습니다.");
    }
}
