package security;

import javax.ejb.EJB;
import javax.ejb.TransactionAttribute;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
  @EJB
  private UserRepo userRepository;

  @TransactionAttribute
  public User findById(int id) {
    return new User(userRepository.findById(id));
  }

  @TransactionAttribute
  public boolean existsById(int id) {
    return userRepository.findById(id) != null;
  }

  @TransactionAttribute
  public List<User> getAllUsers() {
    return userRepository.getAllUsers().stream()
        .map(User::new)
        .collect(Collectors.toList());
  }

}
