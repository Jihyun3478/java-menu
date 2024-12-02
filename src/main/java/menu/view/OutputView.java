package menu.view;

import java.util.List;

import menu.Category;
import menu.Menu;

public class OutputView {
    public static void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public static void inputCoachNames() {
        System.out.println("\n코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    public static void inputCantEatingMenus(String coachName) {
        System.out.printf("\n%s(이)가 못 먹는 메뉴를 입력해 주세요.", coachName);
    }

    public static void printDayAndCategory(List<Category> categories) {
        System.out.println("\n메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리");
        for(Category category : categories) {
            System.out.printf(" | %s", category.getCategoryName());
        }
        System.out.print(" ]");
    }

    public static void printResult(String coachName, List<Menu> menus) {
        System.out.printf("\n[ %s", coachName);
        for(Menu menu : menus) {
            System.out.printf(" | %s", menu.getMenuName());
        }
        System.out.print(" ]");
    }

    public static void finish() {
        System.out.println("\n\n추천을 완료했습니다.");
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage() + " 다시 입력해주세요.");
    }
}
