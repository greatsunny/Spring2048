package spring2048.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import spring2048.dao.ScoreDao;
import spring2048.entity.ScoreEntity;
import spring2048.service.impl.ScoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceTest {

  @Mock
  private ScoreDao scoreDao;

  @InjectMocks
  private ScoreService scoreService = new ScoreServiceImpl();

  @Test
  public void testViewPublicScoreNotNull() {
    // given
    List<ScoreEntity> scoreList = new ArrayList<ScoreEntity>();
    ScoreEntity score = new ScoreEntity(1L, "Test", 100L, new Date());
    scoreList.add(score);

    // when
    when(scoreDao.retrieveListScore(true)).thenReturn(scoreList);

    // then
    assertNotNull(scoreService.viewPublicScore());
    assertEquals("Test", scoreService.viewPublicScore().get(0).getUsername());
  }

  @Test
  public void testViewPublicScoreNull() {
    // given

    // when
    when(scoreDao.retrieveListScore(true)).thenReturn(null);

    // then
    assertNull(scoreService.viewPublicScore());
  }

  @Test
  public void testViewMyselfScoreNotNull() {
    // given
    ScoreEntity score = new ScoreEntity(1L, "Test", 100L, new Date());

    // when
    when(scoreDao.retrieveHighestScoreByUsername("Test")).thenReturn(score);

    // then
    assertNotNull(scoreService.viewMyselfScore("Test"));
    assertEquals(100L, scoreService.viewMyselfScore("Test").getScore().longValue());
  }

  @Test
  public void testUploadScoreSuccess() {
    // given
    ScoreEntity score = new ScoreEntity(null, "Test", 100L, new Date());

    // when
    when(scoreDao.createScore(score)).thenReturn(score);

    // then
    assertNotNull(scoreService.uploadMyScore(100L, new Date(), "Test"));
  }
}
