package spring2048.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import spring2048.dao.ScoreDao;
import spring2048.entity.ScoreEntity;
import spring2048.service.ScoreService;
import spring2048.web.dto.UserScoreDTO;

@Transactional(readOnly = true)
@Service
public class ScoreServiceImpl implements ScoreService {

  @Autowired
  private ScoreDao scoreDao;

  @Override
  public List<UserScoreDTO> viewPublicScore() {
    List<UserScoreDTO> userScoreList = null;
    List<ScoreEntity> scoreList = scoreDao.retrieveListScore(true);
    if (scoreList != null) {
      userScoreList = new ArrayList<UserScoreDTO>();
      for (ScoreEntity s : scoreList) {
        userScoreList.add(new UserScoreDTO(null, s.getUsername(), s.getScoring(), s.getScore_date()));
      }
    }
    return userScoreList;
  }

  @Override
  public UserScoreDTO viewMyselfScore(String username) {
    UserScoreDTO userScoreDTO = null;
    if (username != null) {
      ScoreEntity existing = scoreDao.retrieveHighestScoreByUsername(username);
      if (existing != null) {
        userScoreDTO = new UserScoreDTO();
        userScoreDTO.setUsername(existing.getUsername());
        userScoreDTO.setScore(existing.getScoring());
        userScoreDTO.setDate(existing.getScore_date());
      }
    }
    return userScoreDTO;
  }

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
  @Override
  public Boolean uploadMyScore(Long scoring, Date date, String username) {
    if (scoring != null && date != null && username != null) {
      ScoreEntity score = new ScoreEntity();
      score.setUsername(username);
      score.setScoring(scoring);
      score.setScore_date(date);
      scoreDao.createScore(score);
      return true;
    }
    return false;
  }

}
