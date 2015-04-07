package spring2048.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import spring2048.dao.UserDao;
import spring2048.entity.UserEntity;
import spring2048.service.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

  @Mock
  private UserDao userDao;

  @InjectMocks
  private UserService userService = new UserServiceImpl();

  @Test
  public void testSignInSuccess() {
    // given
    String testUsername = "Test";
    String testPassword = "Test";
    UserEntity existingUser = new UserEntity(1L, testUsername, testPassword);

    // when
    when(userDao.retrieveUserByUsername(testUsername)).thenReturn(existingUser);
    when(userDao.retrieveUserByUsernameByPassword(testUsername, DigestUtils.md5Hex(testPassword).substring(0, 20)))
        .thenReturn(existingUser);

    // then
    assertNotNull(userService.signin(testUsername, testPassword));
  }

  @Test
  public void testSignInFailure() {
    // given
    String testUsername = "Test";
    String testPassword = "Test";
    UserEntity existingUser = new UserEntity(1L, testUsername, testPassword);

    // when
    when(userDao.retrieveUserByUsername(testUsername)).thenReturn(existingUser);
    when(userDao.retrieveUserByUsernameByPassword(testUsername, DigestUtils.md5Hex(testPassword).substring(0, 20)))
        .thenReturn(existingUser);

    // then
    assertNull(userService.signin(testUsername, "wrongPassword"));
    assertNull(userService.signin("wrongUsername", "wrongPassword"));
  }

  @Test
  public void testSignUpSuccess() {
    // given
    String testUsername = "Test";
    String testPassword = "Test";
    UserEntity createUser = new UserEntity(null, testUsername, DigestUtils.md5Hex(testPassword).substring(0, 20));
    UserEntity existingUser = new UserEntity(1L, testUsername, DigestUtils.md5Hex(testPassword).substring(0, 20));

    // when
    when(userDao.createUser(createUser)).thenReturn(existingUser);

    // then
    assertNotNull(userService.signup(testUsername, testPassword));
  }

  @Test
  public void testSignUpFailure() {
    // given
    String testUsername = "Test";
    String testPassword = "Test";
    UserEntity createUser = new UserEntity(null, testUsername, DigestUtils.md5Hex(testPassword).substring(0, 20));
    UserEntity existingUser = new UserEntity(null, testUsername, DigestUtils.md5Hex(testPassword).substring(0, 20));

    // when
    when(userDao.createUser(createUser)).thenReturn(existingUser);

    // then
    assertNull(userService.signup(testUsername, testPassword));
  }

}
