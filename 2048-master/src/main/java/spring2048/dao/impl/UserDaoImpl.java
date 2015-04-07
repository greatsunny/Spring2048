package spring2048.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring2048.dao.UserDao;
import spring2048.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public UserEntity createUser(UserEntity user) {
    this.sessionFactory
        .getCurrentSession()
        .persist(user);
    return user;
  }

  @Override
  public UserEntity retrieveUserByUsername(String username) {
    @SuppressWarnings("unchecked")
    List<UserEntity> userList = this.sessionFactory
        .getCurrentSession()
        .createQuery("from UserEntity u where u.username=?")
        .setParameter(0, username)
        .list();
    if (null != userList && userList.size() > 0) {
      return userList.get(0);
    }
    return null;
  }

  @Override
  public UserEntity retrieveUserByUsernameByPassword(String username, String password) {
    @SuppressWarnings("unchecked")
    List<UserEntity> userList = this.sessionFactory
        .getCurrentSession()
        .createQuery("from UserEntity u where u.username=? and u.password=?")
        .setParameter(0, username)
        .setParameter(1, password)
        .list();
    if (null != userList && userList.size() > 0) {
      return userList.get(0);
    }
    return null;
  }

}
