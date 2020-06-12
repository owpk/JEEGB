package hw_jsf.repos;

import hw_jsf.models.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class UserRepo extends BaseRepository<User> {

    @Override
    protected String obtainName() {
        return User.class.getName();
    }
}
