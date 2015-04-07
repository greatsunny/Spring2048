package spring2048.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Score Entity
 * 
 * @author Shallong
 *
 */
@SuppressWarnings("serial")
@Entity(name = "score")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "score_id")
  private Long score_id;

  @Column(name = "username", length = 20, nullable = false)
  private String username;

  @Column(name = "scoring", nullable = false)
  private Long scoring;

  @Column(name = "score_date", nullable = false)
  private Date score_date;

}
