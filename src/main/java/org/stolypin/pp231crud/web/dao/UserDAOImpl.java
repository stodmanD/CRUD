package org.stolypin.pp231crud.web.dao;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stolypin.pp231crud.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
      List <User> allUser = entityManager.createQuery("from User").getResultList();
      return allUser;
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0){
        entityManager.persist(user);
    } else {
        entityManager.merge(user);}
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }


}
