package hw_jsf.repos;

import hw_jsf.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.Collection;

@Named
@ApplicationScoped
public class UserRepo extends BaseRepository<User> {


    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
