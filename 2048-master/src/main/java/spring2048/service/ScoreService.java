package spring2048.service;

import java.util.Date;
import java.util.List;

import spring2048.web.dto.UserScoreDTO;

/**
 * Score service interface
 * 
 * @author Shallong
 *
 */
public interface ScoreService {

  /**
   * Get a list of scores from the database
   * 
   * @return
   */
  List<UserScoreDTO> viewPublicScore();

  /**
   * Get to see the score by username
   * 
   * @param username
   * @return null if no score found
   */
  UserScoreDTO viewMyselfScore(String username);

  /**
   * Upload the new score with the username into the Score table
   * 
   * @param scoring
   * @param date
   * @param username
   * @return true if successful
   */
  Boolean uploadMyScore(Long scoring, Date date, String username);

}
