package scriptletServlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MenuBean {
    private List<String> menuList;
    private AtomicInteger index;

    public MenuBean() {
        this.menuList = new ArrayList<>();
        menuList.addAll(Arrays.asList("catalog", "cart", "main", "order"
//                , "product", "sql", "calc", "po", "test_scripts"
               ));
        index = new AtomicInteger(-1);
    }

    public AtomicInteger getIndex() {
        return index;
    }

    public List<String> getMenuList() {
        return menuList;
    }


    public void setMenuList(List<String> menuList) {
        this.menuList = menuList;
    }
}
