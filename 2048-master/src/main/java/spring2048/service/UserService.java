package spring2048.service;

import spring2048.web.dto.UserScoreDTO;

/**
 * User service interface
 * 
 * @author Shallong
 *
 */
public interface UserService {

  /**
   * Login for the system
   * 
   * @param username
   * @param password
   * @return
   */
  UserScoreDTO signin(String username, String password);

  /**
   * Register for the system
   * 
   * @param username
   * @param password
   * @return
   */
  UserScoreDTO signup(String username, String password);

  /**
   * Username must be unique, this is to check if the username is unique
   * 
   * @param username
   * @return true if unique
   */
  Boolean checkUsernameUnique(String username);

}
