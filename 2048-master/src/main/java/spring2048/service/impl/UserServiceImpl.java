package spring2048.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring2048.dao.UserDao;
import spring2048.entity.UserEntity;
import spring2048.service.UserService;
import spring2048.web.dto.UserScoreDTO;

@Transactional(readOnly = true)
@Service
public class UserServiceImpl implements UserService {

  // public static void main(String[] args) {
  // System.out.println(DigestUtils.md5Hex("ben").substring(0, 20));
  // }

  @Autowired
  private UserDao userDao;

  @Override
  public UserScoreDTO signin(String username, String password) {
    UserScoreDTO userDTO = null;
    UserEntity existing = userDao.retrieveUserByUsernameByPassword(username,
        DigestUtils.md5Hex(password).substring(0, 20));
    if (existing != null) {
      userDTO = new UserScoreDTO();
      userDTO.setUid(existing.getUser_id());
      userDTO.setUsername(username);
    }
    return userDTO;
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  @Override
  public UserScoreDTO signup(String username, String password) {
    UserScoreDTO userDTO = null;
    UserEntity user = new UserEntity();
    user.setUsername(username);
    user.setPassword(DigestUtils.md5Hex(password).substring(0, 20));
    user = userDao.createUser(user);
    if (user.getUser_id() != null && user.getUser_id() > 0) {
      userDTO = new UserScoreDTO();
      userDTO.setUid(user.getUser_id());
      userDTO.setUsername(user.getUsername());
    }
    return userDTO;
  }

  @Override
  public Boolean checkUsernameUnique(String username) {
    UserEntity checking = userDao.retrieveUserByUsername(username);
    return checking == null;
  }

}
