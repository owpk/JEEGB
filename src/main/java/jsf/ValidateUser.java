package jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class ValidateUser {
    @NotNull(message = "Поле не должно быть пустым")
    private String name;

    @NotNull(message = "Поле не должно быть пустым")
    @Size(min = 4, max = 10,message = "Поле должно содержать от 4 до 10 символов")
    private String pw;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
}
