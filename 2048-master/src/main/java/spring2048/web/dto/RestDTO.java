package spring2048.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * REST entrance JSON bean wrapper
 * 
 * success: true/false
 * 
 * errorMessage: any info or error message that needs to be transferred to the user
 * 
 * result: holds the real content
 * 
 * @author Shallong
 *
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RestDTO {

  @NonNull
  private Boolean success;

  private String errorMessage = "";

  @NonNull
  private Object result;

}
