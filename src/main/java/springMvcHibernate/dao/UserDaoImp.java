package springMvcHibernate.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springMvcHibernate.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

//    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getUsers() {

        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {

        sessionFactory.getCurrentSession().createQuery("DELETE User where id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    @Transactional
    public User getUser(long id) {

        User user = sessionFactory.getCurrentSession().get(User.class, id);

        return user;
    }


}
