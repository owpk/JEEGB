package hw_jsf;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Named
@RequestScoped
@Data
public class MenuBean {

    public enum Pages {
        CATALOG("catalog.xhtml"),
        CART("cart.xhtml");
        private final String url;

        Pages(String url) {
            this.url = url;
        }
    }

    private Pages[] pages;
    private List<String> menuPages;
    private Set<String> pageNames;

    public Pages[] getPages() {
        return Pages.values();
    }

    public String getPage(String page) {
       return pageNames.stream()
               .filter(data -> !page.isEmpty() && data.startsWith(page))
               .findFirst()
               .orElse("OWPK");
    }

    @PostConstruct
    private void initList() {
        pageNames = Arrays.stream(Pages.values())
                .map(x -> x.url)
                .map(x -> x.substring(0, x.indexOf(".")))
                .collect(Collectors.toSet());

        menuPages = Arrays.stream(Pages.values())
                .map(x -> x.url)
                .collect(Collectors.toList());
    }

}
