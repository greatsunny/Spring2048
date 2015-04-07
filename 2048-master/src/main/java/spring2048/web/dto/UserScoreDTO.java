package spring2048.web.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User data transfer object
 * 
 * Actually, VO is more meaningful
 * 
 * @author Shallong
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserScoreDTO {

  private Long uid;

  private String username;

  private Long score;

  private Date date;

}
