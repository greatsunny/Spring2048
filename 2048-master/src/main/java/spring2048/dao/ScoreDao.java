package spring2048.dao;

import java.util.List;

import spring2048.entity.ScoreEntity;

/**
 * Score DAO interface
 * 
 * @author Shallong
 *
 */
public interface ScoreDao {

  /**
   * Create a new score in the Score table
   * 
   * @param score
   * @return
   */
  ScoreEntity createScore(ScoreEntity score);

  /**
   * Retrieve the highest score of a username
   * 
   * @param username
   * @return null if no score found
   */
  ScoreEntity retrieveHighestScoreByUsername(String username);

  /**
   * Retrieve a list of scores, order by the score desc.
   * 
   * @param desc
   *          (yes, desc only...)
   * @return
   */
  List<ScoreEntity> retrieveListScore(Boolean desc);

}
