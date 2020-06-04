package scriptletServlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuBean {
    private List<String> menuList;

    public MenuBean() {
        this.menuList = new ArrayList<>();
        menuList.addAll(Arrays.asList("main", "cart", "order", "catalog",
                "product", "sql", "calc", "po", "test_scripts"));
    }

    public List<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }
}
