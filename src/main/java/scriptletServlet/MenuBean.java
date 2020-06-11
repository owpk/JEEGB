package scriptletServlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MenuBean {
    private List<String> menuList;

    public enum PagesSet {
        CATALOG("catalog"),
        CART("cart"),
        ORDER("order");
        private String name;

        PagesSet(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    public MenuBean() {
        this.menuList = new ArrayList<>();
        menuList.addAll(Arrays.stream(PagesSet.values())
                .map(x -> x.name)
                .collect(Collectors.toList()));
    }


    public List<String> getMenuList() {
        return menuList;
    }


    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }
}
