package spring2048.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring2048.dao.ScoreDao;
import spring2048.entity.ScoreEntity;

@Repository
public class ScoreDaoImpl implements ScoreDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public ScoreEntity createScore(ScoreEntity score) {
    this.sessionFactory
        .getCurrentSession()
        .persist(score);
    return score;
  }

  @Override
  public ScoreEntity retrieveHighestScoreByUsername(String username) {
    @SuppressWarnings("unchecked")
    List<ScoreEntity> scoreList = this.sessionFactory
        .getCurrentSession()
        .createQuery("from ScoreEntity s where s.username = ? order by s.scoring desc")
        .setParameter(0, username)
        .list();
    if (null != scoreList && scoreList.size() > 0) {
      return scoreList.get(0);
    }
    return null;
  }

  @Override
  public List<ScoreEntity> retrieveListScore(Boolean desc) {
    @SuppressWarnings("unchecked")
    List<ScoreEntity> scoreList = this.sessionFactory
        .getCurrentSession()
        .createQuery("from ScoreEntity s order by s.scoring desc")
        .list();
    if (null != scoreList && scoreList.size() > 0) {
      return scoreList;
    }
    return null;
  }

}
