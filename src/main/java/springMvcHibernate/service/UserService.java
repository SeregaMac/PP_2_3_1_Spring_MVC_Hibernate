package springMvcHibernate.service;


import springMvcHibernate.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    User getUser(int id);

    void deleteUser(int id);
}
