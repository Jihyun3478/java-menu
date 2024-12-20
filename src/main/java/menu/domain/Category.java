package menu.domain;

import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public enum Category {
    JAPANESE("일식", Arrays.asList("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", Arrays.asList("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", Arrays.asList("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", Arrays.asList("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", Arrays.asList("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));;

    private final String categoryName;
    private final List<String> menus;

    Category(String categoryName, List<String> menus) {
        this.categoryName = categoryName;
        this.menus = menus;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<String> getMenus() {
        return menus;
    }

    public static Category randomCategory() {
        int randomIndex = Randoms.pickNumberInRange(0, 4);
        return Category.values()[randomIndex];
    }

    public static List<String> getMenusByCategory(Category category) {
        return category.menus;
    }

    public static String getMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
