package jsf;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
@RequestScoped
@Data
public class Menu {
    private List<String> pages;

    public Menu() {
        File f = new File("C:\\Users\\vzvz4\\Desktop\\PAPKA\\GitHub\\JEEGB\\src\\main\\webapp\\jsf_pages\\");
        pages = new ArrayList<>(Arrays.asList(f.list()));
    }

}
