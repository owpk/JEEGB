package jsf;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Date;

@Named
@RequestScoped
@Data
public class SomeBean {
    private Date localDateField;

    public SomeBean() {
        localDateField = new Date();
    }
}
