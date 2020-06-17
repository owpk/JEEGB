package hw_jsf.service;

import hw_jsf.models.User;
import hw_jsf.repos.BaseRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class AuthService implements Serializable {

    @Inject
    private BaseRepository<User> repository;

    @PostConstruct
    public void init() {
        user = new User();
    }

    //TODO
    private User user;

    public String login() {
        return "login.xhtml?faces-redirect=true";
    }
    //TODO
    public String sign() {
        return "sign.xhtml?faces-redirect=true";
    }

    //TODO
    public String submitLogin() {
        return "";
    }

    //TODO
    public String submitSign() {
        return "";
    }


}
