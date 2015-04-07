package spring2048.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User Entity
 * 
 * @author Shallong
 *
 */
@SuppressWarnings("serial")
@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long user_id;

  @Column(name = "username", length = 20, nullable = false)
  private String username;

  @Column(name = "password", length = 20, nullable = false)
  private String password;

}
