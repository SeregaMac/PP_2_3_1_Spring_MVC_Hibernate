package springMvcHibernate.repository;

import springMvcHibernate.models.User;

import java.util.List;

public interface UserRepository {

    List<User> getUsers();

    void save(User user);

    User getUser(long id);

    void deleteUser(long id);
}
