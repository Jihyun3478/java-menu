package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CantEatingMenus {
    private List<Menu> cantEatingMenus = new ArrayList<>();

    public CantEatingMenus(List<String> cantEatingMenus) {
        validateMenusLength(cantEatingMenus);
        validateIsMenuExist(cantEatingMenus);
        this.cantEatingMenus = cantEatingMenus(cantEatingMenus);
    }

    private void validateMenusLength(List<String> cantEatingMenus) {
        if(!(cantEatingMenus.size() <= 2)) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 최소 0개, 최대 2개여야 합니다.");
        }
    }

    private void validateIsMenuExist(List<String> cantEatingMenus) {
       if(!isMenuExist(cantEatingMenus)) {
           throw new IllegalArgumentException("[ERROR] 존재하지 않는 메뉴입니다.");
       }
    }

    public List<Menu> getCantEatingMenus() {
        return cantEatingMenus;
    }

    private List<Menu> cantEatingMenus(List<String> cantEatingMenus) {
        return cantEatingMenus.stream()
            .map(Menu::new)
            .collect(Collectors.toList());
    }

    private boolean isMenuExist(List<String> cantEatingMenus) {
        List<String> allMenus = Arrays.stream(Category.values())
            .flatMap(category -> category.getMenus().stream())
            .collect(Collectors.toList());

        return cantEatingMenus.stream().anyMatch(allMenus::contains);
    }
}
